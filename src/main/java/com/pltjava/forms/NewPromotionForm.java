package com.pltjava.forms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pltjava.beans.Database;
import com.pltjava.beans.Etudiant;
import com.pltjava.beans.Matiere;
import com.pltjava.beans.Promotion;

public class NewPromotionForm {
	private static final String CHAMP_NOMPROMOTION = "nompromotion";
    //private static final String CHAMP_NAME = "name";
    
    private String resultat;
    private Map<String, String> erreurs = new HashMap<String, String>();

    public NewPromotionForm()
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
    
    //Verifie si la nom de la promotion rentré est conforme
    private void checkNomPromotion(String nom) throws Exception 
    {
    	if(nom ==null)
    		throw new Exception("Le nom de la promotion ne peut pas être nul");
    	else if(Database.PromotionExists(nom))
    		throw new Exception("Ce nom de promotion est déjà utilisé.");
    }



    //Ajoute un message correspondant au champ spécifié à la map des erreurs
    private void setErreur(String champ,String message) {
        erreurs.put(champ,message);
    }
    
    public void nouvellePromotion(HttpServletRequest request) 
    {	
        String nom = getChamp(request,CHAMP_NOMPROMOTION);

        try
        {
        	checkNomPromotion(nom);
        } catch(Exception e)
        {
            setErreur(CHAMP_NOMPROMOTION,e.getMessage());
        }

        
        if (erreurs.isEmpty()) //Si pas d'erreur on crée l'utilisateur
        {
            resultat = "Succès de la création."; 
        	
            Etudiant Etudiant1 = new Etudiant("Etudiant "+(int)(Math.random()*100),(float)Math.round((Math.random()*20)*100)/100);   
    	    Etudiant Etudiant2 = new Etudiant("Etudiant "+(int)(Math.random()*100),(float)Math.round((Math.random()*20)*100)/100);  
    	    Etudiant Etudiant3 = new Etudiant("Etudiant "+(int)(Math.random()*100),(float)Math.round((Math.random()*20)*100)/100);  
    	   
    	    ArrayList<Etudiant> newListeEtudiant = new ArrayList<Etudiant>();

    	    newListeEtudiant.add(Etudiant1);
    	    newListeEtudiant.add(Etudiant2);
    	    newListeEtudiant.add(Etudiant3);
    	    
    	    Matiere Matiere1 = new Matiere("Anglais",(float)Math.round(Math.random()*10));
    		ArrayList<Float> NotesAnglaisEtudiant1 = new ArrayList<Float>();
    		NotesAnglaisEtudiant1.add(5.0f);
    		NotesAnglaisEtudiant1.add(5.0f);
    		
    		Matiere Matiere2 = new Matiere("Maths",(float)Math.round(Math.random()*10));
    		ArrayList<Float> NotesMathsEtudiant1 = new ArrayList<Float>();
    		NotesMathsEtudiant1.add(15.0f);
    		NotesMathsEtudiant1.add(15.0f);
    	    
    	    ArrayList<Matiere> ListeMatiereNewPromotion = new ArrayList<Matiere>();
    	    ListeMatiereNewPromotion.add(Matiere2);
    	    ListeMatiereNewPromotion.add(Matiere1);
            Database.addPromotion(new Promotion(nom,newListeEtudiant,ListeMatiereNewPromotion));
        }
        else //Si des erreurs on return null
            resultat = "Échec de création.";
    }
}
