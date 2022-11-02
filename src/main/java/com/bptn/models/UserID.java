package com.bptn.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="\"UserID\"") // In postgress use double quotes but in Java have to escape using forward slash

public class UserID {
	
	@Id
	@Column(name = "username")	
	String username;
	
	@Column(name = "name")
	String name;
	
	@Column(name = "\"emailID\"") // Since emailID has capital have to escape with double quotes	
	String emailId;
	
	@Column(name = "\"phoneNumber\"")	
	String phoneNumber;
	
	@Column(name = "\"userPassword\"")
	String userPassword;
	
	
	public UserID() {
		super();
		
	}

	public UserID(String username, String name, String emailId, String phoneNumber, String userPassword) {
		super();
		this.username = username;
		this.name = name;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
		this.userPassword = userPassword;
		
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
		
		
	}

	@Override
	public String toString() {
		return "UserID [username=" + username + ", name=" + name + ", emailId=" + emailId + ", phoneNumber="
				+ phoneNumber + ", userPassword=" + userPassword + "]";
	}	
	

}
