package fr.shcherbakov.shop.Controller;

import fr.shcherbakov.shop.Forms.OrderForm;
import fr.shcherbakov.shop.Model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/createOrder")
public class CreateOrder extends HttpServlet {
    public static final String ATT_COMMANDE = "commande";
    public static final String ATT_FORM     = "form";

    public static final String VUE_SUCCES   = "/WEB-INF/afficherCommande.jsp";
    public static final String VUE_FORM     = "/WEB-INF/createOrder.jsp";


        public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
            this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );
        }

        public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

            OrderForm form = new OrderForm();
            Order order = form.createOrder( request );


            request.setAttribute( ATT_COMMANDE, order );
            request.setAttribute( ATT_FORM, form );

            if ( form.getErrors().isEmpty() ) {
                this.getServletContext().getRequestDispatcher( VUE_SUCCES ).forward( request, response );
            } else {
                this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );
            }
        }
    }

//    Order order;
//    public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//        order = new Order();
//        order.mapOrder(request);
//        request.setAttribute("order", order);
//        this.getServletContext().getRequestDispatcher("/WEB-INF/createOrder.jsp").forward(request, response);
//

