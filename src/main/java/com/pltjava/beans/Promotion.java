package com.pltjava.beans;

import java.util.ArrayList;

public class Promotion 
{
	private ArrayList<Etudiant> listeEtu=new ArrayList<Etudiant>();
	private ArrayList<Matiere> listeMat=new ArrayList<Matiere>();
	private static long cpt = 0;
	private long idPromotion;
	
	public Promotion(ArrayList<Etudiant> listeEtu, ArrayList<Matiere> listeMat) {
		setListeEtu(listeEtu);
		setListeMat(listeMat);
		cpt++;
		idPromotion = cpt;
	}
	
	public long getIdPromotion() 
	{
		return idPromotion;
	}

	public ArrayList<Etudiant> getListeEtu() 
	{
		return listeEtu;
	}
	
	public void setListeEtu(ArrayList<Etudiant> listeEtu) 
	{
		this.listeEtu = listeEtu;
	}
	
	public ArrayList<Matiere> getListeMat()
	{
		return listeMat;
	}
	
	public void setListeMat(ArrayList<Matiere> listeMat)
	{
		this.listeMat = listeMat;
	}
	
	
}