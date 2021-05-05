package com.pltjava.forms;

import java.util.ArrayList;
import java.util.HashMap;

import com.pltjava.beans.*;

public class AdminForm 
{	
	public ArrayList<Etudiant> orderedList()
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

	    Etudiant Etudiant1 = new Etudiant("Kaaris",test );         
	    System.out.println(Etudiant1.getMoyenneGeneral());
		
		return null;
	}
}
