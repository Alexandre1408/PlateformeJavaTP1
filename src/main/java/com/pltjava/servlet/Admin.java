package com.pltjava.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pltjava.forms.AdminForm;

/**
 * Servlet implementation class Admin
 */
public class Admin extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		AdminForm adminForm = new AdminForm();
		adminForm.orderedEtudiantList();
		adminForm.remplirlisteEtuParPromo();
		
        request.setAttribute("form", adminForm );
        this.getServletContext().getRequestDispatcher("/admin.jsp").forward(request, response );	
    }
}



