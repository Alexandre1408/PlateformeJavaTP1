package com.pltjava.forms;

import java.util.ArrayList;

import com.pltjava.beans.*;

public class AdminForm 
{
	Collections c = new Collections();
	
	public ArrayList<Etudiant> orderedList()
	{
		float moyenneEtudiant = 0.0f;
		for(Etudiant etudiantIterator : c.getListeEtudiants())
		{
			moyenneEtudiant = etudiantIterator.moyenneNotes();
		}
		
		return null;
	}
}
