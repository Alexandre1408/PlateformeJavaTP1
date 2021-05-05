package com.pltjava.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pltjava.form.ConnexionForm;

public class Connexion extends HttpServlet {
	
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Affichage de la page de connexion */
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Préparation de l'objet formulaire */
        ConnexionForm form = new ConnexionForm();

        /* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();
        
        form.connecterUtilisateur(request);
        
        request.setAttribute( "form", form );

        this.getServletContext().getRequestDispatcher("/connexion.jsp").forward( request, response );
    }
}
