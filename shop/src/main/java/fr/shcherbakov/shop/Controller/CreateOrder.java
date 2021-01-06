package fr.shcherbakov.shop.Controller;

import fr.shcherbakov.shop.Model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/createOrder")
public class CreateOrder extends HttpServlet {
    Order order;

    public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        order = new Order();
        order.mapOrder(request);
        request.setAttribute("order", order);
        this.getServletContext().getRequestDispatcher("/WEB-INF/createOrder.jsp").forward(request, response);
    }
}
