package ru.geekbrains.servlet.homework_2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LinksServlet", urlPatterns = "/links")
public class LinksServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("<p><a href=\"main_page_servlet\">Main</a></p>");
        resp.getWriter().println("<p><a href=\"catalog_servlet\">Catalog</a></p>");
        resp.getWriter().println("<p><a href=\"product_servlet\">Product</a></p>");
        resp.getWriter().println("<p><a href=\"cart_servlet\">Cart</a></p>");
        resp.getWriter().println("<p><a href=\"order_servlet\">Order</a></p>");
    }
}
