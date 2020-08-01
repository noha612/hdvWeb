/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import dto.CartDTO;
import dto.OrderDTO;
import dto.OrderPayPalDTO;
import service.paypal.PaypalService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import model.Product;
import model.User;
import service.OrderService;

/**
 * @author Phạm Ngọc Hoàng - B16DCCN159
 */
public class PaymentServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PaypalServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PaypalServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        CartDTO cartDTO = (CartDTO) session.getAttribute("cartDTO");
        OrderPayPalDTO order = new OrderPayPalDTO();
        order.setPrice(Double.parseDouble(request.getParameter("price")));
        order.setCurrency(request.getParameter("currency"));
        order.setDescription(request.getParameter("description"));
        order.setIntent("sale");
        order.setMethod(request.getParameter("method"));
        System.out.println(order);
        switch (order.getMethod()) {
            case "PayPal": {
                try {
                    PaypalService service = new PaypalService();
                    Payment payment = service.createPayment(order.getPrice(), order.getCurrency(), order.getMethod(),
                            order.getIntent(), order.getDescription(), "https://github.com/",
                            "http://localhost:8080/webserver/checkoutSuccess");
                    for (Links link : payment.getLinks()) {
                        if (link.getRel().equals("approval_url")) {
                            response.sendRedirect(link.getHref());
                        }
                    }
                    OrderDTO dto = new OrderDTO();
                    dto.setUser(user);
                    dto.setDate(new Date().toString());
                    dto.setMethod(order.getMethod());
                    dto.setStatus("Da thanh toan");
                    dto.setItems(cartDTO.getList());
                    new OrderService().order(dto);

                } catch (PayPalRESTException e) {

                    response.sendRedirect("/");

                    e.printStackTrace();
                }
                break;
            }
            case "CashOnDelivery": {
                OrderDTO dto = new OrderDTO();
                dto.setUser(user);
                dto.setDate(new Date().toString());
                dto.setMethod(order.getMethod());
                dto.setStatus("Chua thanh toan");
                dto.setItems(cartDTO.getList());
                new OrderService().order(dto);
                request.getRequestDispatcher("/JSP/checkoutSuccess.jsp").forward(request, response);
                break;
            }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
