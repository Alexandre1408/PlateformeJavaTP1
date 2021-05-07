package com.pltjava.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pltjava.beans.Database;
import com.pltjava.beans.Utilisateur;
import com.pltjava.forms.InscriptionForm;

/**
 * Servlet implementation class Inscription
 */
public class Inscription extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String ATT_USER = "utilisateur";
    public static final String ATT_FORM = "form";


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	if(Database.getListePromotions().size() == 0)
    	{
    		Database.initializeData();
    	}
    	
        this.getServletContext().getRequestDispatcher("/inscription.jsp").forward(request, response);
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        InscriptionForm form = new InscriptionForm(); //Objet formulaire

        Utilisateur user = form.inscrireUtilisateur(request);

        request.setAttribute(ATT_FORM,form);
        request.setAttribute(ATT_USER,user);

        if(form.getErreurs().isEmpty())
        {
            response.sendRedirect("connexion.jsp");
        }
        else
            this.getServletContext().getRequestDispatcher("/inscription.jsp").forward(request,response);
    }

}