package com.cscsharing.jampojo;

public class Member {
//	"Id": "97W0Q5QkHFWxZpGhamv1oK",
//    "FirstName": "Bryan",
//    "LastName": "Fang",
//    "Nickname": null,
//    "Title": "",
//    "Email": "bryan.fang@sap.com",
//    "FullName": "Bryan Fang",
//    "Role": "company",
//    "IsFollowing": false,
//    "WebURL": "https://developer.sapjam.com/profile/wall/97W0Q5QkHFWxZpGhamv1oK",
//    "IsAway": false,
	private String id;
	private String firstName;
	private String lastName;
	private Object nickname;
	private String title;
	private String email;
	private String fullName;
	private String role;
	private boolean isFollowing;
	private String WebURL;
	private boolean isAway;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Object getNickname() {
		return nickname;
	}
	public void setNickname(Object object) {
		this.nickname = object;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isFollowing() {
		return isFollowing;
	}
	public void setFollowing(boolean isFollowing) {
		this.isFollowing = isFollowing;
	}
	public String getWebURL() {
		return WebURL;
	}
	public void setWebURL(String webURL) {
		WebURL = webURL;
	}
	public boolean getIsAway() {
		return isAway;
	}
	public void setIsAway(boolean b) {
		this.isAway = b;
	}
	
}
