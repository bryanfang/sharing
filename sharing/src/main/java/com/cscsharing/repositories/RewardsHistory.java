package com.cscsharing.repositories;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rewardshistory")
public class RewardsHistory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private Long rewardsId;

	@Column(nullable = false)
	private String userId;

	@Column(length = 10)
	private String rewardsType;

	@Column(length = 20)
	private String rewards;

	@Column(length = 20)
	private Date rewardsDate;

	@Column(length = 20)
	private String rewardsByWho;

	public Long getRewardsId() {
		return rewardsId;
	}

	public void setRewardsId(Long rewardsId) {
		this.rewardsId = rewardsId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRewardsType() {
		return rewardsType;
	}

	public void setRewardsType(String rewardsType) {
		this.rewardsType = rewardsType;
	}

	public String getRewards() {
		return rewards;
	}

	public void setRewards(String rewards) {
		this.rewards = rewards;
	}

	public Date getRewardsDate() {
		return rewardsDate;
	}

	public void setRewardsDate(Date rewardsDate) {
		this.rewardsDate = rewardsDate;
	}

	public String getRewardsByWho() {
		return rewardsByWho;
	}

	public void setRewardsByWho(String rewardsByWho) {
		this.rewardsByWho = rewardsByWho;
	}

}
