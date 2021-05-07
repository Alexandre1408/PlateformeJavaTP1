package com.pltjava.beans;

import java.util.ArrayList;

public class Database 
{
	private static ArrayList<Promotion> ListePromotions = new ArrayList<Promotion>();
	private static ArrayList<Utilisateur> ListeUtilisateurs = new ArrayList<Utilisateur>();

	private Database() {}
	
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
}