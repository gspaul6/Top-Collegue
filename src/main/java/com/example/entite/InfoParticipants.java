package com.example.entite;

public class InfoParticipants {
	private String nom;
	private String motPass;
	private String photoUrl;

	public InfoParticipants() {
		super();
	}

	public InfoParticipants(String nom, String motPass, String photoUrl) {
		super();
		this.nom = nom;
		this.motPass = motPass;
		this.photoUrl = photoUrl;
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
	 * @return the motPass
	 */
	public String getMotPass() {
		return motPass;
	}

	/**
	 * @param motPass
	 *            the motPass to set
	 */
	public void setMotPass(String motPass) {
		this.motPass = motPass;
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
