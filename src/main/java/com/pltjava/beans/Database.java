package com.pltjava.beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

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
		boolean flag = false;
		for(Utilisateur user : ListeUtilisateurs)
		{
			if(user.getUsername().equals(nom) && user.getPassword().equals(mdp))
			{
				flag = true;
				break;
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
	
	public static void deleteEtudiantByName(String nom)
	{
		for(Promotion promotionIterator : ListePromotions)
		{
			Iterator<Etudiant> iterator = promotionIterator.getListeEtu().iterator();
			
			while(iterator.hasNext())
			{
				String nomEtu = iterator.next().getNomEtu();
		    	if(nomEtu.equals(nom))
		    	{
		    		iterator.remove();
		    	}
		    }
		}
	}

	public static boolean etudiantExists(String nom)
    {
		boolean flag = false;
        for(Promotion promotionIterator : ListePromotions)
		{
	        for(Etudiant etu : promotionIterator.getListeEtu())
	        {
	            if(etu.getNomEtu().equals(nom))
	            {
	                flag=true;
					break;
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
	
	public static Matiere getMatiereByName(String nomMatiere)
	{
		for(Promotion prom : Database.getListePromotions())
		{
			for(Matiere mat : prom.getListeMat())
			{
				if(mat.getNomMatiere().equals(nomMatiere))
					return mat;
			}
		}
		return null;
	}

	public static void initializeData()
	{
		HashMap<Matiere,ArrayList<Float>> kaarisMap = new HashMap<Matiere,ArrayList<Float>>();
		HashMap<Matiere,ArrayList<Float>> boobaMap = new HashMap<Matiere,ArrayList<Float>>();
		HashMap<Matiere,ArrayList<Float>> pabloMap = new HashMap<Matiere,ArrayList<Float>>();
		HashMap<Matiere,ArrayList<Float>> popioMap = new HashMap<Matiere,ArrayList<Float>>();

		
		
		Matiere Anglais = new Matiere("Anglais", 3.0f);
		ArrayList<Float> NotesAnglaisEtudiant1 = new ArrayList<Float>();
		NotesAnglaisEtudiant1.add(5.0f);
		NotesAnglaisEtudiant1.add(5.0f);
		
		
		Matiere Maths = new Matiere("Maths", 9.0f);
		ArrayList<Float> NotesMathsEtudiant1 = new ArrayList<Float>();
		NotesMathsEtudiant1.add(15.0f);
		NotesMathsEtudiant1.add(15.0f);
		
		
		kaarisMap.put(Anglais, NotesAnglaisEtudiant1);
		kaarisMap.put(Maths, NotesMathsEtudiant1);
		
		boobaMap.put(Anglais,  new ArrayList<>(Arrays.asList(3.14f, 6.28f, 9.56f)));
		boobaMap.put(Maths,  new ArrayList<>(Arrays.asList(7.14f, 5.28f, 11.56f)));
		
		pabloMap.put(Anglais,  new ArrayList<>(Arrays.asList(15.14f)));
		pabloMap.put(Maths,  new ArrayList<>(Arrays.asList(18.14f)));
		
		popioMap.put(Anglais,  new ArrayList<>(Arrays.asList(4.14f)));
		popioMap.put(Maths,  new ArrayList<>(Arrays.asList(9.14f)));

	    Etudiant Kaaris = new Etudiant("Kaaris",kaarisMap);   
	    Etudiant Booba = new Etudiant("Booba", boobaMap);  
	    Etudiant Pablo = new Etudiant("Pablo", pabloMap);  
	    Etudiant Popio = new Etudiant("Popio", popioMap);

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
		
		HashMap<Matiere,ArrayList<Float>> jcMap = new HashMap<Matiere,ArrayList<Float>>();
		HashMap<Matiere,ArrayList<Float>> mertMap = new HashMap<Matiere,ArrayList<Float>>();
		HashMap<Matiere,ArrayList<Float>> acuteMap = new HashMap<Matiere,ArrayList<Float>>();

		
		jcMap.put(Francais, new ArrayList<>(Arrays.asList(3.14f, 9.56f)));
		mertMap.put(Physique, new ArrayList<>(Arrays.asList(3.14f, 6.28f, 9.56f)));
		acuteMap.put(Physique, new ArrayList<>(Arrays.asList(3.14f, 6.28f, 9.56f)));
		
	    ArrayList<Etudiant> ListeEtudiantDi3 = new ArrayList<Etudiant>();
	    Etudiant JeanCharles = new Etudiant("Jean Charles", jcMap );   
	    Etudiant Mert = new Etudiant("Mert", mertMap);  
	    Etudiant Acute = new Etudiant("Acute", acuteMap);  
	    ListeEtudiantDi3.add(JeanCharles);
	    ListeEtudiantDi3.add(Mert);
	    ListeEtudiantDi3.add(Acute);

	    
		Promotion Di3 = new Promotion("Di3",ListeEtudiantDi3, ListeMatiereDi3);
		Database.addPromotion(Di3);    	
		
		Database.addUtilisateur(new Utilisateur("tom","tom"));
	}
}