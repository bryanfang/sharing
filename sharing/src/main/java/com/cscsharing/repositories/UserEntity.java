package com.cscsharing.repositories;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQueries({
	@NamedQuery(name="User.findByUserId", query = "select u from UserEntity u where u.userId = ?1"),
	@NamedQuery(name="User.findByUserIdAndPassword", query = "select u from UserEntity u where u.userId = ?1 and u.password = ?2")
})
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=45)
	private String email;

	@Column(length=45)
	private String firstname;

	@Column(length=45)
	private String lastname;

	@Column(nullable=false, length=500)
	private String password;

	@Column(length=45)
	private String telephone;

	@Column(nullable=false, length=45)
	private String userId;

	public UserEntity() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}