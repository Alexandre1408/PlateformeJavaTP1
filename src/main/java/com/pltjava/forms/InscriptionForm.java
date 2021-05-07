package com.pltjava.forms;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pltjava.beans.Database;
import com.pltjava.beans.Etudiant;
import com.pltjava.beans.Matiere;
import com.pltjava.beans.Promotion;
import com.pltjava.beans.Utilisateur;


public class InscriptionForm {
	private static final String CHAMP_USERNAME = "username";
	private static final String CHAMP_PASSWORD = "password";
    private static final String CHAMP_CONFIRMATION = "confirmation";
    private static final String CHAMP_NAME = "name";
    private static final String CHECKBOX_ISAMIN = "isadmin";
    private String resultat;
    private Map<String, String> erreurs = new HashMap<String, String>();

    public InscriptionForm()
    {
    	
    }
    
    public String getResultat() 
    {
        return resultat;
    }

    public Map<String, String> getErreurs() 
    {
        return erreurs;
    }
    
    //Retourne le contenu du champ sans espace
    private static String getChamp(HttpServletRequest request,String nomChamp) 
    {
        String valeur = request.getParameter(nomChamp);
        if(valeur == null || valeur.trim().length() == 0) 
            return null;
        else
            return valeur.trim();
    }
    
    //Verifie si le pseudo rentré est conforme
    private void checkUsername(String username) throws Exception 
    {
    	if(username ==null)
    		throw new Exception("Le nom d'utilisateur ne peut pas être nul");
    	if(username != null && username.length()<3) 
            throw new Exception("Le nom d'utilisateur doit contenir au moins 3 caractères.");
    	else if(Database.userExists(username))
    		throw new Exception("Ce nom d'utilisateur est déjà utilisé.");
    }

    //Vérifie si les deux mots de passe sont conformes
    private void checkPassword(String password,String confirmation) throws Exception 
    {
        if(password != null && confirmation != null) {
            if (!password.equals(confirmation)) 
                throw new Exception("Les mots de passe entrés sont différents, merci de les saisir à nouveau.");
            else if(password.length() < 3)
                throw new Exception("Les mots de passe doivent contenir au moins 3 caractères.");
        } else
            throw new Exception("Merci de saisir et confirmer votre mot de passe.");
    }

    //Verifie si le nom 
    private void checkName(String name,boolean isAdmin) throws Exception 
    {
        if (name==null && isAdmin==false)
            throw new Exception("Le nom de l'étudiant ne peut pas être vide.");
        else if (Database.etudiantExists(name)==false && isAdmin==false)
        	throw new Exception("L'étudiant n'existe pas.");
    }

    //Ajoute un message correspondant au champ spécifié à la map des erreurs
    private void setErreur(String champ,String message) {
        erreurs.put(champ,message);
    }
    
    public Utilisateur inscrireUtilisateur(HttpServletRequest request) 
    {	
        String username = getChamp(request,CHAMP_USERNAME);
        String password = getChamp(request,CHAMP_PASSWORD);
        String confirmation = getChamp(request,CHAMP_CONFIRMATION);
        String name = getChamp(request,CHAMP_NAME);
        boolean isAdmin = request.getParameter(CHECKBOX_ISAMIN) != null;

        try
        {
            checkUsername(username);
        } catch(Exception e)
        {
            setErreur(CHAMP_USERNAME,e.getMessage());
        }


        try 
        {
        	checkPassword(password,confirmation);
        } catch (Exception e) 
        {
            setErreur(CHAMP_PASSWORD,e.getMessage());
            setErreur(CHAMP_CONFIRMATION,e.getMessage());
        }

        try 
        {
        	checkName(name,isAdmin);
        } catch (Exception e) 
        {
            setErreur(CHAMP_NAME,e.getMessage());
        }
       
        
        if (erreurs.isEmpty()) //Si pas d'erreur on crée l'utilisateur
        {
            resultat = "Succès de l'inscription."; 
            Utilisateur user;
            
            if(isAdmin)
            	user = new Utilisateur(username,password);
            else
            	user = new Utilisateur(username,password,Database.getEtudiantByName(name));
        	
            Database.addUtilisateur(user);
            return user;
        }
        else //Si des erreurs on return null
            resultat = "Échec de l'inscription.";
        	return null;
    }

}
