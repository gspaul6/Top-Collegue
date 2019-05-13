package com.example.entite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Participants {

	@Id
	@Column(name = "id")
	private String matricule;

	@Column(name = "nom")
	private String nom;

	public Participants() {

	}

	public Participants(String matricule, String nom, String prenom, String photoUrl) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.photoUrl = photoUrl;
	}

	@Column(name = "prenom")
	private String prenom;

	@Column(name = "photoUrl")
	private String photoUrl;

	/**
	 * @return the matricule
	 */
	public String getMatricule() {
		return matricule;
	}

	/**
	 * @param matricule
	 *            the matricule to set
	 */
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom
	 *            the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the photoUrl
	 */
	public String getPhotoUrl() {
		return photoUrl;
	}

	/**
	 * @param photoUrl
	 *            the photoUrl to set
	 */
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

}
