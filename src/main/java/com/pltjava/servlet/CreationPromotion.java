package com.pltjava.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pltjava.beans.Matiere;
import com.pltjava.forms.NewPromotionForm;

/**
 * Servlet implementation class CreationPromotion
 */
public class CreationPromotion extends HttpServlet {
	private static final long serialVersionUID = 1L;
      

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomMatiere[] =  request.getParameterValues("matiere");
		NewPromotionForm form = new NewPromotionForm();
		form.nouvellePromotion(request, nomMatiere);
		if(form.getErreurs().isEmpty())
			this.getServletContext().getRequestDispatcher("/admin").forward( request, response );
		else		
	        this.getServletContext().getRequestDispatcher("/NewPromotion").forward(request,response);
	}

}
