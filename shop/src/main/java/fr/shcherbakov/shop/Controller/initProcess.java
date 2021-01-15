package fr.shcherbakov.shop.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.stream.Stream;

@WebServlet("/initProcess")
public class initProcess extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Stream.of(request.getParameterMap().keySet()).forEach(System.out::println);

        request.setAttribute("lName", request.getParameter("lName"));
        request.setAttribute("fName", request.getParameter("fName"));
        request.setAttribute("countriesForm1", request.getParameterValues("country"));
        request.setAttribute("countriesForm2", request.getParameter("other"));

        this.getServletContext().getRequestDispatcher("/WEB-INF/initProcess.jsp").forward(request, response);
    }
}
