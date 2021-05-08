package com.pltjava.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pltjava.beans.Utilisateur;

public class LogFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain arg2) throws IOException, ServletException
	{
		HttpSession session = ((HttpServletRequest) request).getSession();
		
		if((Utilisateur) session.getAttribute("connectedUser") == null)
        {
			((HttpServletResponse)response).sendRedirect("connexion.jsp");
	    }
	}

}
