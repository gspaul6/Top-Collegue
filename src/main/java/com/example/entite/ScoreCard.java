package com.example.entite;

import javax.persistence.Embeddable;

@Embeddable
public class ScoreCard {

	private Integer likes = 0;
	private Integer disLikes = 0;
	private Integer score = 0;

	public ScoreCard() {
		super();
	}

	public ScoreCard(Integer likes, Integer disLikes, Integer score) {
		super();
		this.likes = likes;
		this.disLikes = disLikes;
		this.score = score;
	}

	/**
	 * @return the likes
	 */
	public Integer getLikes() {
		return likes;
	}

	/**
	 * @param likes
	 *            the likes to set
	 */
	public void setLikes(Integer likes) {
		this.likes = likes;
	}

	/**
	 * @return the disLikes
	 */
	public Integer getDisLikes() {
		return disLikes;
	}

	/**
	 * @param disLikes
	 *            the disLikes to set
	 */
	public void setDisLikes(Integer disLikes) {
		this.disLikes = disLikes;
	}

	/**
	 * @return the score
	 */
	public Integer getScore() {
		return score;
	}

	/**
	 * @param score
	 *            the score to set
	 */
	public void setScore(Integer score) {
		this.score = score;
	}
}
