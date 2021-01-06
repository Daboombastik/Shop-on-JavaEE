package fr.shcherbakov.shop.Controller;

import fr.shcherbakov.shop.Model.Client;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/createClient")
public class CreateClient extends HttpServlet {
    Client client;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        client = new Client();
        client.mapClient(request);
        request.setAttribute("client", client);
        this.getServletContext().getRequestDispatcher("/WEB-INF/createClient.jsp").forward(request, response);
    }
}

