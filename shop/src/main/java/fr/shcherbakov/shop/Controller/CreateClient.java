package fr.shcherbakov.shop.Controller;

import fr.shcherbakov.shop.Model.Client;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

@WebServlet("/createClient")
public class CreateClient extends HttpServlet {
    Client client;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        client = new Client();
        Enumeration<String> params = request.getParameterNames();
        while (params.hasMoreElements()) {
            String temp = params.nextElement();
            switch (temp) {
                case "clientName":
                    client.setName(request.getParameter(temp));
                    break;
                case "clientSurname":
                    client.setSurname(request.getParameter(temp));
                    break;
                case "clientAddress":
                    client.setAddress(request.getParameter(temp));
                    break;
                case "clientPhoneNumber":
                    client.setPhone(request.getParameter(temp));
                    break;
                case "clientEmail":
                    client.setEmail(request.getParameter(temp));
                    break;
            }
        }
        request.setAttribute("client", client);
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,45,8));
        request.setAttribute("list", list);

        this.getServletContext().getRequestDispatcher("/WEB-INF/createClient.jsp").forward(request,response);
    }
}

