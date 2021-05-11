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
	
	private ArrayList<Matiere> AllMatiere = new ArrayList<Matiere>();
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
    
    //Verifie si au moins une matiere est cochée
    private void checkMatiere(String[] nomsMatiere) throws Exception
    {
    	if(nomsMatiere==null)
    		throw new Exception("Veuillez cocher au moins une matière");
    }
    public void nouvellePromotion(HttpServletRequest request, String[] nomsMatiere) 
    {	
    	boolean isEmpty=true;

        String nom = getChamp(request,CHAMP_NOMPROMOTION);

        try
        {
        	checkNomPromotion(nom);
        } catch(Exception e)
        {
            setErreur(CHAMP_NOMPROMOTION,e.getMessage());
        }

        try
        {
        	checkMatiere(nomsMatiere);
        }
        catch(Exception e)
        {
        	setErreur(CHAMP_NOMPROMOTION, e.getMessage());
        }
        
        if (erreurs.isEmpty()) //Si pas d'erreur on crée l'utilisateur
        {
            resultat = "Succès de la création."; 
        	
            ArrayList<Matiere> ListeMatieres= new ArrayList<Matiere>();
            
        	
        	for(String nomMat : nomsMatiere)
        	{
        		isEmpty=false;
        		ListeMatieres.add(Database.getMatiereByName(nomMat));
        	}
            
            ArrayList<HashMap<Matiere,ArrayList<Float>>> MapEtudiants = new ArrayList<HashMap<Matiere,ArrayList<Float>>>();
            
            HashMap<Matiere,ArrayList<Float>> MapEtudiant1 = new HashMap<Matiere,ArrayList<Float>>();
            HashMap<Matiere,ArrayList<Float>> MapEtudiant2 = new HashMap<Matiere,ArrayList<Float>>();
            HashMap<Matiere,ArrayList<Float>> MapEtudiant3 = new HashMap<Matiere,ArrayList<Float>>();
            
            MapEtudiants.add(MapEtudiant1);
            MapEtudiants.add(MapEtudiant2);
            MapEtudiants.add(MapEtudiant3);
            

            
            for(int j=0; j < 3; j++)
            {
	            for(int i=0; i < ListeMatieres.size();i++)
		    	{
			    	ArrayList<Float> NotesMatiere = new ArrayList<Float>();
			    	NotesMatiere.add((float)Math.round((Math.random()*20)*100)/100);
			    	NotesMatiere.add((float)Math.round((Math.random()*20)*100)/100);
			    
			    	MapEtudiants.get(j).put(ListeMatieres.get(i),NotesMatiere);
		    	}
	          
            }
	    		
            Etudiant Etudiant1 = new Etudiant("Etudiant "+(int)(Math.random()*100),MapEtudiants.get(0));   
            
            Etudiant Etudiant2 = new Etudiant("Etudiant "+(int)(Math.random()*100),MapEtudiants.get(1));  
       
            Etudiant Etudiant3 = new Etudiant("Etudiant "+(int)(Math.random()*100),MapEtudiants.get(2));  
    	   
    	    ArrayList<Etudiant> newListeEtudiant = new ArrayList<Etudiant>();

    	    newListeEtudiant.add(Etudiant1);
    	    newListeEtudiant.add(Etudiant2);
    	    newListeEtudiant.add(Etudiant3);
    	  
  
            Database.addPromotion(new Promotion(nom,newListeEtudiant,ListeMatieres));
        }
        else //Si des erreurs on return null
            resultat = "Échec de création.";
    }

	public ArrayList<String> getNameAllMatiere() 
	{
		ArrayList<String> nameAllMatiere=new ArrayList<String>();
		for(Matiere mat : AllMatiere)
		{
			nameAllMatiere.add(mat.getNomMatiere());
		}
		return nameAllMatiere;
	}

	public void setAllMatiere(ArrayList<Matiere> allMatiere) 
	{
		AllMatiere = allMatiere;
	}
	
	public void initializeMatiere()
	{
		for(Promotion prom : Database.getListePromotions())
		{
			for(Matiere mat : prom.getListeMat())
			{
				if(!AllMatiere.contains(mat))
					AllMatiere.add(mat);
			}
		}
	}
}
