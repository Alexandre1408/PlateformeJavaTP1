package com.pltjava.beans;

import java.util.HashMap;
import java.util.ArrayList;

public class Etudiant 
{
	private static long cpt = 0;
	private long idEtu;
	private String nomEtu;
	private HashMap<String,ArrayList<Float>> listeNotes= new HashMap<String,ArrayList<Float>>();
	
	public Etudiant(String nomEtu, HashMap<String, ArrayList<Float>> listesNotes) 
	{
		setNomEtu(nomEtu);
		setListeNotes(listeNotes);
		cpt++;
		idEtu = cpt;
	}
	
	public long getIdEtu() 
	{
		return idEtu;
	}

	public HashMap<String, ArrayList<Float>> getListeNotes() {
		return listeNotes;
	}

	public void setListeNotes(HashMap<String, ArrayList<Float>> listeNotes) {
		this.listeNotes = listeNotes;
	}

	public String getNomEtu() {
		return nomEtu;
	}

	public void setNomEtu(String nomEtu) {
		this.nomEtu = nomEtu;
	}
	
	public ArrayList<Float> getNotesByMatiere(String matiere){
		return listeNotes.get(matiere);
	}
	
	public void setNotesByMatiere(String matiere,ArrayList<Float> notes) {
		listeNotes.put(matiere, notes);
	}
}