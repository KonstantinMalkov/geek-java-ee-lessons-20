package ru.geekbrains.servlet.homework_2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CatalogServlet", urlPatterns = "/catalog_servlet/*")
public class CatalogServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("headerText", "Catalog page");
        getServletContext().getRequestDispatcher("/header").include(req, resp);

        getServletContext().getRequestDispatcher("/links").include(req, resp);

    }
}
