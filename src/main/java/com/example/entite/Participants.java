package com.example.entite;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Participants {

	@Id
	@Column(name = "id")
	private String matricule;

	@Column(name = "nom")
	private String nom;

	@Embedded
	private ScoreCard scoreCard;

	public Participants() {

	}

	public Participants(String matricule, String nom, String prenom, String email, String photoUrl,
			ScoreCard scoreCard) {
		
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.photoUrl = photoUrl;
		this.scoreCard = scoreCard;
	}

	public Participants(String matricule, String nom, String prenom, String photoUrl) {
		
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.photoUrl = photoUrl;
	}

	/**
	 * @return the scoreCard
	 */
	public ScoreCard getScoreCard() {
		return scoreCard;
	}

	/**
	 * @param scoreCard
	 *            the scoreCard to set
	 */
	public void setScoreCard(ScoreCard scoreCard) {
		this.scoreCard = scoreCard;
	}

	@Column(name = "prenom")
	private String prenom;

	public Participants(String matricule, String nom, String prenom, String email, String photoUrl) {
		
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.photoUrl = photoUrl;
	}

	@Column(name = "email")
	private String email;

	@Column(name = "photoUrl")
	private String photoUrl = "";

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
