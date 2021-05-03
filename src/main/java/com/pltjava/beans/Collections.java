package com.pltjava.beans;

import java.util.ArrayList;

public class Collections 
{
	private ArrayList<Etudiant> ListeEtudiants;
	private ArrayList<Matiere> ListeMatieres;
	private ArrayList<Promotion> ListePromotions;
	private ArrayList<Utilisateur> ListeUtilisateurs;

	public Collections()
	{
		ListeEtudiants = new ArrayList<Etudiant>();	
		ListeMatieres = new ArrayList <Matiere>();
		ListePromotions = new ArrayList<Promotion>();
		ListeUtilisateurs = new ArrayList<Utilisateur>();
	}
	

	//Ajoute un etudiant dans la liste des etudiants
	public void addUtilisateur(Utilisateur utilisateurToAdd)
	{
		ListeUtilisateurs.add(utilisateurToAdd);
	}
	
	//Enleve un etudiant dans la liste des etudiants
	public void removeUtilisateur(Utilisateur utilisateurToRemove)
	{
		ListeUtilisateurs.remove(utilisateurToRemove);
	}


	//Ajoute un etudiant dans la liste des etudiants
	public void addEtudiant(Etudiant etuToAdd)
	{
		ListeEtudiants.add(etuToAdd);
	}
	
	//Enleve un etudiant dans la liste des etudiants
	public void removeEtudiant(Etudiant etuToRemove)
	{
		ListeEtudiants.remove(etuToRemove);
	}
	
	//Ajoute une matiere dans la liste des matieres
	public void addMatiere(Matiere matiereToAdd)
	{
		ListeMatieres.add(matiereToAdd);
	}
	
	//Enleve une matiere dans la liste des matieres
	public void removeMatiere(Matiere matiereToRemove)
	{
		ListeMatieres.remove(matiereToRemove);
	}
	
	//Ajoute une promotion dans la liste des promotions
	public void addPromotion(Promotion promotionToAdd)
	{
		ListePromotions.add(promotionToAdd);
	}
	
	//Enleve une promotion dans la liste des promotion
	public void removePromotion(Promotion promotionToRemove)
	{
		ListePromotions.remove(promotionToRemove);
	}
	
	public ArrayList<Etudiant> getListeEtudiants()
	{
		return ListeEtudiants;
	}
	
	public ArrayList<Utilisateur> getListeUtilisateurs() 
	{
		return ListeUtilisateurs;
	}
	

	public void setListeEtudiants(ArrayList<Etudiant> listeEtudiants) 
	{
		ListeEtudiants = listeEtudiants;
	}

	public ArrayList<Matiere> getListeMatieres() 
	{
		return ListeMatieres;
	}

	public void setListeMatieres(ArrayList<Matiere> listeMatieres)
	{
		ListeMatieres = listeMatieres;
	}

	public ArrayList<Promotion> getListePromotions()
	{
		return ListePromotions;
	}

	public void setListePromotions(ArrayList<Promotion> listePromotions) 
	{
		ListePromotions = listePromotions;
	}
	
	
}
