package fr.shcherbakov.shop.Controller;
import fr.shcherbakov.shop.Forms.SignUpForm;
import fr.shcherbakov.shop.Model.Client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/inscription")
public class Inscription extends HttpServlet {

    public static final String ATT_USER = "client";
    public static final String ATT_FORM = "form";
    public static final String VUE = "/WEB-INF/inscription.jsp";

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        /* Show init web page */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        /* Prepare the form */
        SignUpForm form = new SignUpForm();

        /* Validate data and set Bean */
        Client client = form.signUpClient( request );

        /* Set request */
        request.setAttribute( ATT_FORM, form );
        request.setAttribute( ATT_USER, client );

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
}