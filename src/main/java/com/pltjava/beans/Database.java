package com.pltjava.beans;

import java.util.ArrayList;
import java.util.HashMap;

public class Database 
{
	private static ArrayList<Promotion> ListePromotions = new ArrayList<Promotion>();
	private static ArrayList<Utilisateur> ListeUtilisateurs = new ArrayList<Utilisateur>();

	public Database() {
		//initializeData();
	}
	
	public static boolean userExists(String nom)
	{
		for(Utilisateur user : ListeUtilisateurs)
		{
			if(user.getUsername().equals(nom))
			{
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean verifyPassword(String nom, String mdp)
	{
		boolean flag=false;
		for(Utilisateur user : ListeUtilisateurs)
		{
			if(user.getUsername().equals(nom) && user.getPassword().equals(mdp))
			{
				flag=true;
			}
		}
		return flag;
	}
	
	public static Utilisateur getUserByName(String nom)
	{
		for(Utilisateur user : ListeUtilisateurs)
		{
			if(user.getUsername().equals(nom))
			{
				return user;
			}
		}
		return null;
	}
	
	public static Etudiant getEtudiantByName(String nom)
    {
        for(Promotion promotionIterator : ListePromotions)
		{
	        for(Etudiant etu : promotionIterator.getListeEtu())
	        {
	            if(etu.getNomEtu().equals(nom))
	            {
	                return etu;
	            }
	        }
		}
        return null;
    }
	

	public static boolean etudiantExists(String nom)
    {
		boolean flag=false;
        for(Promotion promotionIterator : ListePromotions)
		{
	        for(Etudiant etu : promotionIterator.getListeEtu())
	        {
	            if(etu.getNomEtu().equals(nom))
	            {
	                flag=true;
	            }
	        }
		}
        return flag;
    }
	public static Promotion getPromotionByEtudiant(String nom) 
	{
        for(Promotion promotionIterator : ListePromotions)
		{
        	for(Etudiant etudiantIterator : promotionIterator.getListeEtu())
        	{
        		if(etudiantIterator.getNomEtu().equals(nom))
        		{
        			return promotionIterator;
        		}
        	}
		}
		return null;
	}
	
	public static boolean PromotionExists(String nom) 
	{
		boolean flag=false;
        for(Promotion promotionIterator : ListePromotions)
		{
            if(promotionIterator.getNomPromotion().equals(nom))
            {
                flag=true;
            }
		}
        return flag;
	}
	
	//Ajoute un etudiant dans la liste des etudiants
	public static void addUtilisateur(Utilisateur utilisateurToAdd)
	{
		ListeUtilisateurs.add(utilisateurToAdd);
	}
	
	//Enleve un etudiant dans la liste des etudiants
	public static void removeUtilisateur(Utilisateur utilisateurToRemove)
	{
		ListeUtilisateurs.remove(utilisateurToRemove);
	}


	
	//Ajoute une promotion dans la liste des promotions
	public static void addPromotion(Promotion promotionToAdd)
	{
		ListePromotions.add(promotionToAdd);
	}
	
	//Enleve une promotion dans la liste des promotion
	public static void removePromotion(Promotion promotionToRemove)
	{
		ListePromotions.remove(promotionToRemove);
	}
	
	public static ArrayList<Promotion> getListePromotions()
	{
		return ListePromotions;
	}

	public static void setListePromotions(ArrayList<Promotion> listePromotions) 
	{
		ListePromotions = listePromotions;
	}
	
	public static void initializeData()
	{
		HashMap<Matiere,ArrayList<Float>> test = new HashMap<Matiere,ArrayList<Float>>();
		
		Matiere Anglais = new Matiere("Anglais", 3.0f);
		ArrayList<Float> NotesAnglaisEtudiant1 = new ArrayList<Float>();
		NotesAnglaisEtudiant1.add(5.0f);
		NotesAnglaisEtudiant1.add(5.0f);
		
		Matiere Maths = new Matiere("Maths", 9.0f);
		ArrayList<Float> NotesMathsEtudiant1 = new ArrayList<Float>();
		NotesMathsEtudiant1.add(15.0f);
		NotesMathsEtudiant1.add(15.0f);
		
		test.put(Anglais, NotesAnglaisEtudiant1);
		test.put(Maths, NotesMathsEtudiant1);

	    Etudiant Kaaris = new Etudiant("Kaaris",test );   
	    Etudiant Booba = new Etudiant("Booba", 15);  
	    Etudiant Pablo = new Etudiant("Pablo", 7);  
	    Etudiant Popio = new Etudiant("Popio", 20);

	    ArrayList<Etudiant> ListeEtudiantDi4 = new ArrayList<Etudiant>();

	    ListeEtudiantDi4.add(Kaaris);
	    ListeEtudiantDi4.add(Booba);
	    ListeEtudiantDi4.add(Pablo);
	    ListeEtudiantDi4.add(Popio);
	    
	    ArrayList<Matiere> ListeMatiereDi4 = new ArrayList<Matiere>();
	    ListeMatiereDi4.add(Maths);
	    ListeMatiereDi4.add(Anglais);
	    
		Promotion Di4 = new Promotion("Di4",ListeEtudiantDi4, ListeMatiereDi4);
		Database.addPromotion(Di4);

		ArrayList<Matiere> ListeMatiereDi3 = new ArrayList<Matiere>();
		Matiere Francais = new Matiere("Francais", 6.0f);
		Matiere Physique = new Matiere("Physique", 8.0f);
		ListeMatiereDi3.add(Physique);
		ListeMatiereDi3.add(Francais);

	    ArrayList<Etudiant> ListeEtudiantDi3 = new ArrayList<Etudiant>();
	    Etudiant JeanCharles = new Etudiant("Jean Charles", 20 );   
	    Etudiant Mert = new Etudiant("Mert", 18);  
	    Etudiant Acute = new Etudiant("Acute", 19);  
	    ListeEtudiantDi3.add(JeanCharles);
	    ListeEtudiantDi3.add(Mert);
	    ListeEtudiantDi3.add(Acute);

	    
		Promotion Di3 = new Promotion("Di3",ListeEtudiantDi3, ListeMatiereDi3);
		Database.addPromotion(Di3);    	
	}
}