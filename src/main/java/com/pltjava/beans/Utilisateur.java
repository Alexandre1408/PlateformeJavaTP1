package com.pltjava.beans;

public class Utilisateur {
	private String username;
	private String password;
	private Etudiant etu;
	private boolean isAdmin;
	
	public Utilisateur(String username, String password) //Constructeur pour compte 
	{
		setUsername(username);
		setPassword(password);
		setAdmin(true);
		setEtudiant(null);
	}
	
	public Utilisateur() 
	{
		// TODO Auto-generated constructor stub
	}

	
	public Utilisateur(String username, String password, Etudiant etu) //Constructeur pour compte étudiant
	{
		setUsername(username);
		setPassword(password);
		setAdmin(false);
		setEtudiant(etu);
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String mdp) {
		this.password = mdp;
	}

	public Etudiant getEtudiant() {
		return etu;
	}

	public void setEtudiant(Etudiant etu) {
		this.etu = etu;
	}

	public boolean getAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	
	

}