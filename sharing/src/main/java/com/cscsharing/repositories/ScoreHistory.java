package com.cscsharing.repositories;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The ScoreHistory used for scorehistory table in database
 * 
 * 
 * @author I312473
 *
 */
@Entity
@Table(name="scorehistory")
@NamedQueries({
	@NamedQuery(name="ScoreHistroy.findByLoginUserIdAndEventId", 
			query = "select sh from ScoreHistory sh where sh.loginUserId = ?1 and sh.eventId = ?2"),
	@NamedQuery(name="ScoreHistory.findByLoginUserIdAndEventIdAndMemberId",
			query="select sh from ScoreHistory sh where sh.loginUserId=?1 and sh.eventId=?2 and sh.memberId=?3")
})
public class ScoreHistory implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long scoreId;
	
	@Column(nullable=false, length=200)
	private String eventId;
	
	@Column(length=50)
	private String speakerId;
	
	@Column(length=50)
	private String memberId;
	
	private int attendPoints;
	
	@Column(nullable=false, length=50)
	private String loginUserId;
	
	private int objective;
	
	private int encouraged;
	
	private int easy;
	
	private int knowledgeable;
	
	private int preparation;

	private int honoredStudent;
	
	@Column(length=50)
	private Date createDate;

	public Long getScoreId() {
		return scoreId;
	}

	@Column(columnDefinition="int default 0",length = 1)
	public int getAttendPoints() {
		return attendPoints;
	}

	public void setAttendPoints(int attendPoints) {
		this.attendPoints = attendPoints;
	}

	@Column(columnDefinition="int default 0",length=1)
	public int getObjective() {
		return objective;
	}

	public void setObjective(int objective) {
		this.objective = objective;
	}

	@Column(columnDefinition="int default 0",length=1)
	public int getEncouraged() {
		return encouraged;
	}

	public void setEncouraged(int encouraged) {
		this.encouraged = encouraged;
	}
	
	@Column(columnDefinition="int default 0",length=1)
	public int getEasy() {
		return easy;
	}

	public void setEasy(int easy) {
		this.easy = easy;
	}

	@Column(columnDefinition="int default 0",length=1)
	public int getKnowledgeable() {
		return knowledgeable;
	}

	public void setKnowledgeable(int knowledgeable) {
		this.knowledgeable = knowledgeable;
	}

	@Column(columnDefinition="int default 0",length=1)
	public int getPreparation() {
		return preparation;
	}

	public void setPreparation(int preparation) {
		this.preparation = preparation;
	}

	@Column(columnDefinition="int default 0",length = 1)
	public int getHonoredStudent() {
		return honoredStudent;
	}

	public void setHonoredStudent(int honoredStudent) {
		this.honoredStudent = honoredStudent;
	}

	public void setScoreId(Long scoreId) {
		this.scoreId = scoreId;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getLoginUserId() {
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}

	public String getSpeakerId() {
		return speakerId;
	}

	public void setSpeakerId(String speakerId) {
		this.speakerId = speakerId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
