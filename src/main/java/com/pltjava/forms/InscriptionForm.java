package com.pltjava.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pltjava.beans.Utilisateur;


public class InscriptionForm {
	private static final String CHAMP_USERNAME = "username";
	private static final String CHAMP_PASSWORD = "password";
    private static final String CHAMP_CONFIRMATION = "confirmation";
    private static final String CHAMP_NAME = "name";
    
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
    	if(username != null && username.length()<3) 
            throw new Exception("Le nom d'utilisateur doit contenir au moins 3 caractères.");
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
    private void checkName(String name) throws Exception 
    {
        if (name==null)
            throw new Exception( "Le nom de l'étudiant ne peut pas être vide." );
    }

    //Ajoute un message correspondant au champ spécifié à la map des erreurs
    private void setErreur(String champ,String message) {
        erreurs.put( champ, message );
    }
    
    public Utilisateur inscrireUtilisateur(HttpServletRequest request) 
    {
        String username = getChamp(request,CHAMP_USERNAME);
        String password = getChamp(request,CHAMP_PASSWORD);
        String confirmation = getChamp(request,CHAMP_CONFIRMATION);
        String name = getChamp(request,CHAMP_NAME);

        Utilisateur user = new Utilisateur();

        try
        {
            checkUsername(username);
        } catch(Exception e)
        {
            setErreur(CHAMP_USERNAME,e.getMessage());
        }
        user.setUsername(username);

        try 
        {
        	checkPassword(password,confirmation);
        } catch (Exception e) 
        {
            setErreur(CHAMP_PASSWORD,e.getMessage());
            setErreur(CHAMP_CONFIRMATION,e.getMessage());
        }
        user.setPassword(password);

        try 
        {
        	checkName(name);
        } catch (Exception e) 
        {
            setErreur(CHAMP_NAME,e.getMessage());
        }
        user.setName(name);

        if (erreurs.isEmpty())
            resultat = "Succès de l'inscription.";
        else
            resultat = "Échec de l'inscription.";

        return user;
    }

}
