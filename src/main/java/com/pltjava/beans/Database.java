package com.pltjava.beans;

import java.util.ArrayList;
import java.util.Collections;

public class Database 
{
	private static ArrayList<Etudiant> ListeEtudiants = new ArrayList<Etudiant>();
	private static ArrayList<Matiere> ListeMatieres = new ArrayList <Matiere>();
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
		for(Utilisateur user : ListeUtilisateurs)
		{
			if(user.getUsername().equals(nom) && user.getPassword().equals(mdp))
			{
				return true;
			}
		}
		
		return false;
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
	
	public ArrayList<Etudiant> getSortedEtudiantByMoyenne() 
	{         
		Collections.sort(ListeEtudiants);         
		return ListeEtudiants;     
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


	//Ajoute un etudiant dans la liste des etudiants
	public static void addEtudiant(Etudiant etuToAdd)
	{
		ListeEtudiants.add(etuToAdd);
	}
	
	//Enleve un etudiant dans la liste des etudiants
	public static void removeEtudiant(Etudiant etuToRemove)
	{
		ListeEtudiants.remove(etuToRemove);
	}
	
	//Ajoute une matiere dans la liste des matieres
	public static void addMatiere(Matiere matiereToAdd)
	{
		ListeMatieres.add(matiereToAdd);
	}
	
	//Enleve une matiere dans la liste des matieres
	public static void removeMatiere(Matiere matiereToRemove)
	{
		ListeMatieres.remove(matiereToRemove);
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
	
	public static ArrayList<Etudiant> getListeEtudiants()
	{
		return ListeEtudiants;
	}
	
	public static ArrayList<Utilisateur> getListeUtilisateurs() 
	{
		return ListeUtilisateurs;
	}

	public static void setListeEtudiants(ArrayList<Etudiant> listeEtudiants) 
	{
		ListeEtudiants = listeEtudiants;
	}

	public static ArrayList<Matiere> getListeMatieres() 
	{
		return ListeMatieres;
	}

	public static void setListeMatieres(ArrayList<Matiere> listeMatieres)
	{
		ListeMatieres = listeMatieres;
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