package com.cscsharing.jampojo;

import java.util.Date;

public class Events {
//	"Id": "DiTYTRylgLdnftFYUpgmeK",
//    "Name": "Event Share Session",
//    "Description": "Hold this event on today",
//    "DescriptionHtml": "<p>Hold this event on today</p>",
//    "CreatedAt": "/Date(1478747179000)/",
//    "LastModifiedAt": "/Date(1478747179000)/",
//    "StartAt": "/Date(1478764800000)/",
//    "EndAt": "/Date(1478851140000)/",
//    "AllDay": true,
//    "Location": "",
//    "Priority": "normal",
//    "Category": "training",
//    "Liked": false,
//    "LikesCount": 0,
//    "FeedCommentsCount": 0,
	private String id;
	private String name;
	private String description;
	private Date createdAt;
	private Date lastModifiedAt;
	private Date startAt;
	private Date endAt;
	private boolean allDay;
	private String location;
	private String priority;
	private String category;
	private boolean liked;
	private int likesCount;
	private int feedCommentsCount;
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
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date string) {
		this.createdAt = string;
	}
	public Date getLastModifiedAt() {
		return lastModifiedAt;
	}
	public void setLastModifiedAt(Date lastModifiedAt) {
		this.lastModifiedAt = lastModifiedAt;
	}
	public Date getEndAt() {
		return endAt;
	}
	public void setEndAt(Date endAt) {
		this.endAt = endAt;
	}
	public boolean isAllDay() {
		return allDay;
	}
	public void setAllDay(boolean allDay) {
		this.allDay = allDay;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public boolean isLiked() {
		return liked;
	}
	public void setLiked(boolean liked) {
		this.liked = liked;
	}
	public int getLikesCount() {
		return likesCount;
	}
	public void setLikesCount(int likesCount) {
		this.likesCount = likesCount;
	}
	public int getFeedCommentsCount() {
		return feedCommentsCount;
	}
	public void setFeedCommentsCount(int feedCommentsCount) {
		this.feedCommentsCount = feedCommentsCount;
	}
	public Date getStartAt() {
		return startAt;
	}
	public void setStartAt(Date startAt) {
		this.startAt = startAt;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
}
