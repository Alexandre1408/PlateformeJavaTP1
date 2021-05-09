package com.pltjava.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pltjava.forms.AdminForm;


/**
 * Servlet implementation class Suppresion
 */
public class Suppresion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String etudiantNoms[] = request.getParameterValues("etudiant");
		AdminForm Form = new AdminForm();
		Form.suppresionEleves(etudiantNoms);

		this.getServletContext().getRequestDispatcher("/admin").forward( request, response );	
	}

}
