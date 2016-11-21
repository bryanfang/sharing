package com.cscsharing.repositories;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class ScoreHistory implements Serializable{

	/**
	 * scoreId - the primary key of this table
	 * eventId - the event id which comes from JAM
	 * loginUserId - current login user id, this is get from Single Sign On
	 * speakerId - the sharing holder id
	 * workImportance - the importance to our daily work
	 * PPT - the professional of power point of the sharing
	 * expression - the speaker's expression skills
	 * timeSpeaker - the speaker's time management
	 * QASpeaker - the Question and Answer performance from Speaker
	 * memberId - the member id which is judging
	 * timeMember - member's time management
	 * QAMemeber - member's performance on Question and Answer procedure
	 * comments - comment score for the member
	 * createDate - the creation date of this record
	 * bestAnswer - the score when proposed as a best answer in JAM
	 * newQuestion - the score when raise an open question in JAM
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long scoreId;
	
	@Column(nullable=false, length=200)
	private String eventId;
	
	@Column(nullable=false, length=50)
	private String loginUserId;
	
	@Column(length=50)
	private String speakerId;
	
	@Column(columnDefinition="int default 0",length=1)
	private int workImportance;
	
	@Column(columnDefinition="int default 0",length=1)
	private int PPT;
	
	@Column(columnDefinition="int default 0",length=1)
	private int expression;
	
	@Column(columnDefinition="int default 0",length=1)
	private int timeSpeaker;
	
	@Column(columnDefinition="int default 0",length=1)
	private int QASpeaker;
	
	@Column(length=50)
	private String memberId;
	
	@Column(columnDefinition="int default 0",length=1)
	private int timeMember;
	
	@Column(columnDefinition="int default 0",length=1)
	private int QAMember;
	
	@Column(columnDefinition="int default 0",length=1)
	private int comments;
	
	@Column(length=50)
	private Date createDate;
	
	@Column(columnDefinition="int default 0",length = 1)
	private int bestAnswer;
	
	@Column(columnDefinition="int default 0",length = 1)
	private int newQuestion;

	//session time standard
	@Column(columnDefinition="int default 0", length = 1)
	private int sessionTime;
	
	@Column(columnDefinition="float default 1.0", length = 1)
	private float sessionRate;
	
	public int getSessionTime() {
		return sessionTime;
	}

	public void setSessionTime(int sessionTime) {
		this.sessionTime = sessionTime;
	}

	public float getSessionRate() {
		return sessionRate;
	}

	public void setSessionRate(float sessionRate) {
		this.sessionRate = sessionRate;
	}

	public Long getScoreId() {
		return scoreId;
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

	public int getWorkImportance() {
		return workImportance;
	}

	public void setWorkImportance(int workImportance) {
		this.workImportance = workImportance;
	}

	public int getPPT() {
		return PPT;
	}

	public void setPPT(int pPT) {
		PPT = pPT;
	}

	public int getExpression() {
		return expression;
	}

	public void setExpression(int expression) {
		this.expression = expression;
	}

	public int getTimeSpeaker() {
		return timeSpeaker;
	}

	public void setTimeSpeaker(int timeSpeaker) {
		this.timeSpeaker = timeSpeaker;
	}

	public int getQASpeaker() {
		return QASpeaker;
	}

	public void setQASpeaker(int qASpeaker) {
		QASpeaker = qASpeaker;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getTimeMember() {
		return timeMember;
	}

	public void setTimeMember(int timeMember) {
		this.timeMember = timeMember;
	}

	public int getQAMember() {
		return QAMember;
	}

	public void setQAMember(int qAMember) {
		QAMember = qAMember;
	}

	public int getComments() {
		return comments;
	}

	public void setComments(int comments) {
		this.comments = comments;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getBestAnswer() {
		return bestAnswer;
	}

	public void setBestAnswer(int bestAnswer) {
		this.bestAnswer = bestAnswer;
	}

	public int getNewQuestion() {
		return newQuestion;
	}

	public void setNewQuestion(int newQuestion) {
		this.newQuestion = newQuestion;
	}
}
