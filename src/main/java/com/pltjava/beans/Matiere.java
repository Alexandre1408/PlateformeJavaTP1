package com.pltjava.beans;
public class Matiere {
	
	private String nomMatiere;
	private Float coeff;
	private static long cpt = 0;
	private long idMatiere;
	
	public Matiere(String nomMatiere,Float coeff) {
		setNomMatiere(nomMatiere);
		setCoeff(coeff);
		cpt++;
		idMatiere = cpt;
	}
	
	public String getNomMatiere() {
		return nomMatiere;
	}

	public void setNomMatiere(String nomMatiere) 
	{
		this.nomMatiere = nomMatiere;
	}

	public float getCoeff() 
	{
		return coeff;
	}

	public void setCoeff(float coeff) {
		this.coeff = coeff;
	}

	public long getIdMatiere() {
		return idMatiere;
	}

}