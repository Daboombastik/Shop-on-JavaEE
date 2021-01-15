package fr.shcherbakov.shop.Controller;

import fr.shcherbakov.shop.Model.Motocyclette;
import fr.shcherbakov.shop.Model.Vehicule;
import fr.shcherbakov.shop.Model.Voiture;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet("/vehicules")
public class Vehicules extends HttpServlet {
    final String VIEW = "/WEB-INF/vehicules.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Vehicule moto1 = new Motocyclette("Suzuki", "Gros moteur", 600, "Paris");
        Vehicule moto2 = new Motocyclette("Yamaha", "Moyen moteur", 300, "Antibes");
        Vehicule voiture1 = new Voiture("Renault", "Moteur citadine", 140, "Nice");
        Vehicule voiture2 = new Voiture("Volkswagen", "Moteur allemand(beau et puissant)", 940, "Berlin");
        List<Vehicule> vehiculeList = new ArrayList<>(Arrays.asList(moto1,moto2,voiture1, voiture2));
        request.setAttribute("vehicules", vehiculeList);
        this.getServletContext().getRequestDispatcher(VIEW).forward(request,response);
    }
}
