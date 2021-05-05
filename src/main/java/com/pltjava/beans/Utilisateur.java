package com.pltjava.beans;

public class Utilisateur {
	private String username;
	private String password;
	private String name;
	private Etudiant etu;
	private boolean isAdmin;
	
	public Utilisateur()
	{
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
