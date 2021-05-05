package com.pltjava.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.pltjava.beans.*;

public final class ConnexionForm {
	
	private Map<String, String> errors = new HashMap<>();
	
	public Map<String, String> getErrors()
	{
		return errors;
	}

    public Utilisateur connecterUtilisateur(HttpServletRequest request) {
        
    	Collections.addUtilisateur(new Utilisateur("banane", "banane", null));
    	Collections.addUtilisateur(new Utilisateur("pomme", "pomme"));
    	
    	Utilisateur user = null;
    	
        String nom = request.getParameter("id");
        String mdp = request.getParameter("mdp");

        if(verifNom(nom))
        {
        	if(Collections.userExists(nom))
        	{
        		if(verifMdp(mdp))
            	{
            		if(Collections.verifyPassword(nom, mdp))
            		{
            			user = Collections.getUserByName(nom);
            			
            	    	HttpSession session = request.getSession();
            	    	session.setAttribute("nom", user.getUsername());
            			
            			if(user.getAdmin())
            			{
            				//FENETRE ADMIN
            			}
            			else
            			{
            				//FENETRE NORMAL
            			}
            		}
            		else
            		{
                    	errors.put("mdp", "Mot de passe invalide");
            		}
            	}
        		else
        		{
                	errors.put("mdp", "Mot de passe invalide");
        		}
        	}
        	else
        	{
            	errors.put("nom", "Ce nom d'utilisateur n'existe pas");
        	}
        }
        else
        {
        	errors.put("nom", "Nom invalide");
        }

        return user;
    }

    
    private boolean verifNom(String nom){
    	if( nom == null || nom.trim().length() == 0 )
    	{
    		return false;
    	}
        return true;
    }


    private boolean verifMdp(String mdp){
    	if( mdp == null || mdp.trim().length() == 0 )
    	{
    		return false;
    	}
        return true;
    }
}
