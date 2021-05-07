package com.pltjava.beans;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.ArrayList;

public class Etudiant implements Comparable<Etudiant> 
{
	private static long cpt = 0;
	private long idEtu;
	private String nomEtu;
	private float moyenneGeneral;
	private HashMap<Matiere,ArrayList<Float>> listeNotes= new HashMap<Matiere,ArrayList<Float>>();
	
	public Etudiant(String nomEtu, HashMap<Matiere, ArrayList<Float>> listesNotes) 
	{
		setNomEtu(nomEtu);
		listeNotes = listesNotes;
		cpt++;
		idEtu = cpt;
		moyenneGeneral = moyenneNotes();
	}
	
	public Etudiant(String nom,float moyenneGenerale)
	{
		nomEtu = nom;
		cpt++;
		idEtu = cpt;
		moyenneGeneral = moyenneGenerale;
	}
	
	public float moyenneNotes()
	{
		float sommeTotalNotes;
		float total = 0.0f;
		int sommeCoeff = 0;
		
		for (Entry<Matiere, ArrayList<Float>> entry : listeNotes.entrySet()) 
		{
		    Matiere Matiere = entry.getKey();
		    ArrayList<Float> listeNotesParMatiere = entry.getValue();
		    float coefficientMatiere = Matiere.getCoeff();
			sommeTotalNotes = 0.0f;

		    if(listeNotesParMatiere.isEmpty())
		    {}
		    else
		    {
				for(Float noteIterator : listeNotesParMatiere)
				{
					 sommeTotalNotes += noteIterator;
				}
				
			    total += coefficientMatiere*(sommeTotalNotes/listeNotesParMatiere.size());
			    sommeCoeff += coefficientMatiere;
		    }
		}
		return total/sommeCoeff;
	}
	
	@Override
	public int compareTo(Etudiant etudiant) 
	{
	    return (this.getMoyenneGeneral() < etudiant.getMoyenneGeneral() ? 1 : 
            (this.getMoyenneGeneral() == etudiant.getMoyenneGeneral() ? 0 : -1));
	}
	
	public float getMoyenneGeneral() 
	{
		return moyenneGeneral;
	}


	public void setMoyenneGeneral(float moyenneGeneral) 
	{
		this.moyenneGeneral = moyenneGeneral;
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