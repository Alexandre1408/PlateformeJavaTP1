package com.pltjava.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pltjava.beans.Database;
import com.pltjava.forms.AdminForm;
import com.pltjava.forms.NewPromotionForm;

/**
 * Servlet implementation class NewPromotion
 */
public class NewPromotion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/newpromotion.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		NewPromotionForm form = new NewPromotionForm();
		form.initializeMatiere();
		//adminForm.remplirlisteEtuParPromo();
		
        request.setAttribute("list",form.getNameAllMatiere());
        this.getServletContext().getRequestDispatcher("/newpromotion.jsp").forward(request, response );	
    }

}
