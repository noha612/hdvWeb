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
    import java.io.IOException;

    /**
     * @author minhm
     */
    public class DetailProductServlet extends HttpServlet {

        ProductService productDAO = new ProductService();

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            int id = Integer.parseInt(req.getParameter("product_id"));
            Product product = productDAO.getProductByID(id);
            if (product != null) {
                req.setAttribute("product", product);
                req.getRequestDispatcher("JSP/detailProduct.jsp").forward(req, resp);
            }
        }
    }
