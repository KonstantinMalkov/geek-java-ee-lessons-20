package ru.geekbrains.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

public class FirstServlet implements Servlet {
    private static final Logger logger = LoggerFactory.getLogger(FirstServlet.class);
    private transient ServletConfig config;

    @Override // инициализация
    public void init(ServletConfig servletConfig) throws ServletException {
        logger.info("servlet created");
        this.config = config;
    }

    @Override
    public ServletConfig getServletConfig() {
        return this.config;
    }

    @Override
    public void service(ServletRequest rec, ServletResponse resp) throws ServletException, IOException {
        logger.info("new request");
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        rec.setAttribute("headerText", "FirstServlet");
        //config.getServletContext().getRequestDispatcher("/header").include(rec, resp);
        resp.getWriter().println("<h1>Hello from first servlet!!</h1>");
        resp.getWriter().println("finish");

    }

    @Override
    public String getServletInfo() {
        return "Our first servlet";
    }

    @Override
    public void destroy() {

    }
}
