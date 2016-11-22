package com.cscsharing.repositories;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="personalscore")
public class PersonalScore {
	private UserEventPrimaryKey id;
	private double score;
	private boolean isValid;
	private double extraBonus;
	
	public PersonalScore() {

	}
	
	public PersonalScore(UserEventPrimaryKey id){
		this.id = id;
	}
	
	public PersonalScore(String userId, 
			String eventId,
			double score,
			double extraBonus,
			boolean isValid) {
		this.id = new UserEventPrimaryKey(userId, eventId);
		this.score = score;
		this.extraBonus = extraBonus;
		this.isValid = isValid;
	}
	
	@EmbeddedId
	public UserEventPrimaryKey getId() {
		return id;
	}

	public void setId(UserEventPrimaryKey id) {
		this.id = id;
	}
	
	@Column(name="score", precision = 5, scale = 2)
	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}
	
	@Column(name="isValid")
	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	
	@Column(name="extrabonus", precision = 5, scale = 2)
	public double getExtraBonus() {
		return extraBonus;
	}

	public void setExtraBonus(double extraBonus) {
		this.extraBonus = extraBonus;
	}
	
}
