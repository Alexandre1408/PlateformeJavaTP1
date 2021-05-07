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
		System.out.println(Database.getListePromotions().size());
		
		if(Database.getListePromotions().size() > 0 )
		{
			System.out.println(Database.getListePromotions().size());
		}
		else
		{
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
