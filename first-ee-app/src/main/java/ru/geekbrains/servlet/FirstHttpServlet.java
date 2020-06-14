package ru.geekbrains.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/*
    /something  -> только так и перейдет "/something"

    /something/* -> /something/first     любые ссылки после something
                ->  /something/first/second
                ...
   *.png        -> для расширения

   /            -> все урлы

   ""           -> привязка к корню

   "/*"         -> нежелательно использовать в сервлетах

 */
@WebServlet(name = "FirstHttpServlet", urlPatterns = "/first_http_servlet/*")
public class FirstHttpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter pw = resp.getWriter();

        //pw.println("<h1>HttpServletRequest</h1>");
        req.setAttribute("headerText", "FirstHttpServlet");
        getServletContext().getRequestDispatcher("/header").include(req, resp);
        pw.println("Привет!");
        pw.println("<p>contextPath: "+getServletContext().getContextPath()+"</p>");
        pw.println("<p>servletPath: "+req.getServletPath()+"</p>");
        pw.println("<p>pathInfo: "+req.getPathInfo()+"</p>");
        pw.println("<p>queryString: "+req.getQueryString()+"</p>");

        resp.setHeader("Our-Header", "value");

        Cookie ck = new Cookie("user","userName");
        ck.setMaxAge(10);
        resp.addCookie(ck);

        Enumeration<String> names = req.getParameterNames();
        while (names.hasMoreElements()){
            String name = names.nextElement();
            resp.getWriter().println("<p>" + name + ": " + req.getParameter(name) + "</p>");
        }

//        Map m = req.getParameterMap();
//        Set s = m.entrySet();
//        Iterator it = s.iterator();
//
//        while(it.hasNext()){
//
//            Map.Entry<String,String[]> entry = (Map.Entry<String,String[]>)it.next();
//            String key             = entry.getKey();
//            String[] value         = entry.getValue();
//            pw.println("Key is "+key+"<br>");
//            if(value.length>1){
//                for (int i = 0; i < value.length; i++) {
//                    pw.println("<li>" + value[i].toString() + "</li><br>");
//                }
//            }else
//                pw.println("Value: "+value[0].toString()+"<br>");
//
//            pw.println("-------------------<br>");
//        }
//        pw.close();
    }
}
