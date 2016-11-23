package com.cscsharing.jampojo;

import java.util.Date;

public class Group {
	private String id;
	private String name;
	private String description;
	private boolean isActive;
	private boolean autoSubscribe;
	private String announcement;
	private boolean overviewAsLanding;
	private String participation;
	private String invitePolicy;
	private String uploadPolicy;
	private boolean moderationPolicy;
	private String groupType;
	private Date createdAt;
	private Date lastModifiedAt;
	private Date lastActivityAt;
	private int membersCount;
	private boolean autoGroup;
	private boolean disableAtNotify;
	private String WebURL;
	private boolean isAdmin;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public boolean isAutoSubscribe() {
		return autoSubscribe;
	}
	public void setAutoSubscribe(boolean autoSubscribe) {
		this.autoSubscribe = autoSubscribe;
	}
	public String getAnnouncement() {
		return announcement;
	}
	public void setAnnouncement(String announcement) {
		this.announcement = announcement;
	}
	public boolean isOverviewAsLanding() {
		return overviewAsLanding;
	}
	public void setOverviewAsLanding(boolean overviewAsLanding) {
		this.overviewAsLanding = overviewAsLanding;
	}
	public String getParticipation() {
		return participation;
	}
	public void setParticipation(String participation) {
		this.participation = participation;
	}
	public String getInvitePolicy() {
		return invitePolicy;
	}
	public void setInvitePolicy(String invitePolicy) {
		this.invitePolicy = invitePolicy;
	}
	public String getUploadPolicy() {
		return uploadPolicy;
	}
	public void setUploadPolicy(String uploadPolicy) {
		this.uploadPolicy = uploadPolicy;
	}
	public boolean isModerationPolicy() {
		return moderationPolicy;
	}
	public void setModerationPolicy(boolean moderationPolicy) {
		this.moderationPolicy = moderationPolicy;
	}
	public String getGroupType() {
		return groupType;
	}
	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getLastModifiedAt() {
		return lastModifiedAt;
	}
	public void setLastModifiedAt(Date lastModifiedAt) {
		this.lastModifiedAt = lastModifiedAt;
	}
	public Date getLastActivityAt() {
		return lastActivityAt;
	}
	public void setLastActivityAt(Date lastActivityAt) {
		this.lastActivityAt = lastActivityAt;
	}
	public int getMembersCount() {
		return membersCount;
	}
	public void setMembersCount(int membersCount) {
		this.membersCount = membersCount;
	}
	public boolean isAutoGroup() {
		return autoGroup;
	}
	public void setAutoGroup(boolean autoGroup) {
		this.autoGroup = autoGroup;
	}
	public boolean isDisableAtNotify() {
		return disableAtNotify;
	}
	public void setDisableAtNotify(boolean disableAtNotify) {
		this.disableAtNotify = disableAtNotify;
	}
	public String getWebURL() {
		return WebURL;
	}
	public void setWebURL(String webURL) {
		WebURL = webURL;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	
}
