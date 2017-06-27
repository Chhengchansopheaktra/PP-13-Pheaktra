package com.hrd.model;

import java.sql.Timestamp;

public class User {

	private int id;
	private String username;
	private String email;
	private String gender;
	private String phoneNumber;
	private String status;
	private String userHash;
	private Timestamp createdDate;
	
	public User() {
	}
	public User(String userHash){
		this.userHash = userHash;
	}

	public User(int id, String username, String email, String gender, String phoneNumber, String status,
			String userHash, Timestamp createdDate) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.status = status;
		this.userHash = userHash;
		this.createdDate = createdDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String stutus) {
		this.status = stutus;
	}

	public String getUserHash() {
		return userHash;
	}

	public void setUserHash(String userHash) {
		this.userHash = userHash;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", gender=" + gender
				+ ", phoneNumber=" + phoneNumber + ", stutus=" + status + ", userHash=" + userHash + ", createdDate="
				+ createdDate + ", signUpWith=" + "]";
	}
	
	
	
	
	
}
