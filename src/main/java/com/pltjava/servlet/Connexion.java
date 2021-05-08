package com.pltjava.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pltjava.beans.Database;
import com.pltjava.beans.Etudiant;
import com.pltjava.beans.Utilisateur;
import com.pltjava.forms.ConnexionForm;

public class Connexion extends HttpServlet 
{
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Affichage de la page de connexion */
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Préparation de l'objet formulaire */
    	//Database.addUtilisateur(new Utilisateur("tom","tom"));
    
        ConnexionForm form = new ConnexionForm();

        form.connecterUtilisateur(request);
        
        request.setAttribute( "form", form );
        
        /* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();
        
        if((Utilisateur)session.getAttribute("connectedUser") == null)
        {
	        this.getServletContext().getRequestDispatcher("/connexion.jsp").forward( request, response );
        }
		if(((Utilisateur)session.getAttribute("connectedUser")).getAdmin())
		{
	        this.getServletContext().getRequestDispatcher("/admin").forward( request, response );
		}
		else
		{
	        this.getServletContext().getRequestDispatcher("/etudiant").forward( request, response );
		}
    }
}
