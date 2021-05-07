package com.pltjava.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pltjava.beans.Database;
import com.pltjava.beans.Matiere;
import com.pltjava.beans.Etudiant;

/**
 * Servlet implementation class Etudiants
 */
public class Etudiants extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//com.pltjava.beans.Etudiant etu = Collections.getEtudiantByNom((String) request.getSession().getAttribute("nom"));
		//request.setAttribute( "etu", etu );
		
		
		HashMap<Matiere,ArrayList<Float>> test = new HashMap<Matiere,ArrayList<Float>>();
        
        Matiere Anglais = new Matiere("Anglais", 3.0f);
        ArrayList<Float> NotesAnglaisEtudiant1 = new ArrayList<Float>();
        NotesAnglaisEtudiant1.add(10.0f);
        NotesAnglaisEtudiant1.add(10.0f);
        
        Matiere Maths = new Matiere("Maths", 9.0f);
        ArrayList<Float> NotesMathsEtudiant1 = new ArrayList<Float>();
        NotesMathsEtudiant1.add(15.0f);
        NotesMathsEtudiant1.add(15.0f);
        
        test.put(Anglais, NotesAnglaisEtudiant1);
        test.put(Maths, NotesMathsEtudiant1);

        Etudiant Etudiant1 = new Etudiant("Kaaris",test);
        request.setAttribute( "etudiant", Etudiant1 );
        
		this.getServletContext().getRequestDispatcher("/etudiant.jsp").forward( request, response );
	}

}