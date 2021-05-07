package com.pltjava.forms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import com.pltjava.beans.*;

public class AdminForm 
{	
	private HashMap<Promotion,ArrayList<Etudiant>> listeEtuParPromo = new HashMap<Promotion,ArrayList<Etudiant>>();

	
	public void orderedEtudiantList()
	{	
		if(Database.getListePromotions().size() > 0 )
		{
			System.out.println(Database.getListePromotions().size());
		}
		else
		{
			/*HashMap<Matiere,ArrayList<Float>> test = new HashMap<Matiere,ArrayList<Float>>();
			
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

		    Etudiant Etudiant1 = new Etudiant("Kaaris",test );   
		    Etudiant Booba = new Etudiant("Booba", 15);  
		    Etudiant Pablo = new Etudiant("Pablo", 7);  
		    Etudiant Popio = new Etudiant("Popio", 20);

		    ArrayList<Etudiant> ListeEtudiantDi4 = new ArrayList<Etudiant>();
		    ListeEtudiantDi4.add(Etudiant1);
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
			Database.addPromotion(Di3);*/

		    
			for(Promotion promotionIterator : Database.getListePromotions())
			{
				promotionIterator.getSortedEtudiantByMoyenne();
			}
		}
	}
	
	
	public void remplirlisteEtuParPromo()
	{
		for(Promotion promotionIterator : Database.getListePromotions())
		{
			listeEtuParPromo.put(promotionIterator, promotionIterator.getListeEtu());
		}
	}
	


	public HashMap<Promotion, ArrayList<Etudiant>> getListeEtuParPromo() {
		return listeEtuParPromo;
	}

	public void setListeEtuParPromo(HashMap<Promotion, ArrayList<Etudiant>> listeEtuParPromo) {
		this.listeEtuParPromo = listeEtuParPromo;
	}

}
