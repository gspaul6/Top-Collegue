package com.example.entite;

public class CollegueAuth {

	private String nom;

	public CollegueAuth() {
		super();
	}

	public CollegueAuth(String nom, String motPass) {
		super();
		this.nom = nom;
		this.motPass = motPass;
	}

	private String motPass;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getMotPass() {
		return motPass;
	}

	public void setMotPass(String motPass) {
		this.motPass = motPass;
	}

}
