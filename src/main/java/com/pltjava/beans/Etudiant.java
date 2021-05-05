package com.pltjava.beans;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.ArrayList;

public class Etudiant 
{
	private static long cpt = 0;
	private long idEtu;
	private String nomEtu;
	private HashMap<Matiere,ArrayList<Float>> listeNotes= new HashMap<Matiere,ArrayList<Float>>();
	
	public Etudiant(String nomEtu, HashMap<Matiere, ArrayList<Float>> listesNotes) 
	{
		setNomEtu(nomEtu);
		listeNotes = listesNotes;
		cpt++;
		idEtu = cpt;
	}
	
	
	public float moyenneNotes()
	{
		float sommeTotalNotes;
		float total = 0.0f;
		int sommeCoeff = 0;
		
		for (Entry<Matiere, ArrayList<Float>> entry : listeNotes.entrySet()) 
		{
			sommeTotalNotes = 0.0f;
			
		    Matiere Matiere = entry.getKey();
		    ArrayList<Float> listeNotesParMatiere = entry.getValue();
		    float coefficientMatiere = Matiere.getCoeff();
		    
			for(Float noteIterator : listeNotesParMatiere)
			{
				 sommeTotalNotes += noteIterator;
			}
			
		    total += coefficientMatiere*(sommeTotalNotes/listeNotesParMatiere.size());
		    sommeCoeff += coefficientMatiere;
		}
		return total/sommeCoeff;
	}
	
	public long getIdEtu() 
	{
		return idEtu;
	}



	public HashMap<Matiere, ArrayList<Float>> getListeNotes() 
	{
		return listeNotes;
	}

	public void setListeNotes(HashMap<Matiere, ArrayList<Float>> listeNotes) 
	{
		this.listeNotes = listeNotes;
	}


	public String getNomEtu()
	{
		return nomEtu;
	}

	public void setNomEtu(String nomEtu)
	{
		this.nomEtu = nomEtu;
	}
	
	public ArrayList<Float> getNotesByMatiere(Matiere matiere)
	{
		return listeNotes.get(matiere);
	}
	
	public void setNotesByMatiere(Matiere matiere,ArrayList<Float> notes)
	{
		listeNotes.put(matiere, notes);
	}
}