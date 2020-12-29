package fr.shcherbakov.shop.Controller;

import fr.shcherbakov.shop.Model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/createOrder")
public class CreateOrder extends HttpServlet {
    Order order;

    public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        order = new Order();
        Map<String, String[]> orderMap = request.getParameterMap();
        for (Map.Entry<String, String[]> entrySet: orderMap.entrySet()) {
            switch (entrySet.getKey()) {
                case "dateCommande" : order.setDate(entrySet.getValue()[0]);
                case "montantCommande" : order.setTotal(entrySet.getValue()[0]);
                case "modePaiementCommande" : order.setPayMode(entrySet.getValue()[0]);
                case "statutPaiementCommande" : order.setPayStatus(entrySet.getValue()[0]);
                case "modeLivraisonCommande" : order.setDeliveryMode(entrySet.getValue()[0]);
                case "statutLivraisonCommande" : order.setDeliveryStatus(entrySet.getValue()[0]);
            }
        }
        request.setAttribute("order", order);
//        request.setAttribute("orderMap", orderMap);
        this.getServletContext().getRequestDispatcher("/WEB-INF/createOrder.jsp").forward(request, response);
    }
}
