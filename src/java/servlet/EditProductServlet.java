/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import model.Product;
import service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author SA Nice
 */
public class EditProductServlet extends HttpServlet {

    ProductService productDAO = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int product_id = Integer.parseInt(req.getParameter("product_id"));
        Product product = productDAO.getProductByID(product_id);
        session.setAttribute("product_select", product);
        req.getRequestDispatcher("JSP/editProduct.jsp").forward(req, resp);
    }

}
