package fr.shcherbakov.shop.Controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(name = "ServletTest", value = "/servletTest")

public class ServletTest extends HttpServlet {
    final String VIEW = "/WEB-INF/form.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userID = "Ya man, this is your Cookie";
        HttpSession session = request.getSession();
        session.setAttribute("userID",userID);
        this.getServletContext().getRequestDispatcher(VIEW).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cookie = new Cookie("name", request.getParameter("name")).toString();
        request.setAttribute("cookieID",cookie);
        this.getServletContext().getRequestDispatcher(VIEW).forward(request, response);
    }
}
