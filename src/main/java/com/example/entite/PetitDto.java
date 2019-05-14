package com.example.entite;

public class PetitDto {
	private String matricule;

	private Integer like;

	public PetitDto() {
		super();
	}

	public PetitDto(String matricule, Integer like) {
		super();
		this.matricule = matricule;
		this.like = like;
	}

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
	 * @return the like
	 */
	public Integer getLike() {
		return like;
	}

	/**
	 * @param like
	 *            the like to set
	 */
	public void setLike(Integer like) {
		this.like = like;
	}

}
