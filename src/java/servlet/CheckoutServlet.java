/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dto.CartDTO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import model.User;

/**
 * @author SA Nice
 */
public class CheckoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
//        session.setAttribute("cartDTO", null);
        CartDTO cartDTO = (CartDTO) session.getAttribute("cartDTO");
        User user = (User) session.getAttribute("user");
        System.out.println(cartDTO);
        System.out.println(user);
        req.getRequestDispatcher("JSP/checkout.jsp").forward(req, resp);
    }

}
