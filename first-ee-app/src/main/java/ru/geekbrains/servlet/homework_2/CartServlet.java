package ru.geekbrains.servlet.homework_2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CartServlet", urlPatterns = "/cart_servlet/*")
public class CartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("headerText", "Cart page");
        getServletContext().getRequestDispatcher("/header").include(req, resp);

        getServletContext().getRequestDispatcher("/links").include(req, resp);

    }
}
