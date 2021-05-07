package com.pltjava.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pltjava.beans.Database;
import com.pltjava.beans.Utilisateur;
import com.pltjava.forms.ConnexionForm;

public class Connexion extends HttpServlet 
{
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Affichage de la page de connexion */
    	this.getServletContext().getRequestDispatcher("/connexion.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
    	/* Préparation de l'objet formulaire */
    	
        ConnexionForm form = new ConnexionForm();

        /* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();
        
        Utilisateur user = form.connecterUtilisateur(request);
        
        request.setAttribute("form", form);
        if(user!=null)
        {
	        session.setAttribute("etudiant",user.getEtudiant());
	        if(form.getErrors().isEmpty() && user.getAdmin()==false)
	        {
	        	response.sendRedirect("etudiant.jsp");
	        }
	        else if(form.getErrors().isEmpty() && user.getAdmin()==true)
	        {
	        	response.sendRedirect("admin.jsp");
	        }
	        
        }
        else
        	this.getServletContext().getRequestDispatcher("connexion.jsp").forward(request,response);
    }
}
