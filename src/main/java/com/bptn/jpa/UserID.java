package com.bptn.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;


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
	Integer phoneNumber;
	
	@Column(name = "\"userPassword\"")
	String userPassword;
	
	// mapping relationship for post using userId
	
	@OneToMany(mappedBy="userId") // Why did he not use the primary key username?
	List<Post> posts;
	
	public UserID() {
		super();
		
	}
	
	public UserID(String username) {
		super();
		this.username = username;
	}

	public UserID(String username, String name, String emailId, Integer phoneNumber, String userPassword) {
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

	public Integer getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
		
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "UserID [username=" + username + ", name=" + name + ", emailId=" + emailId + ", phoneNumber="
				+ phoneNumber + ", userPassword=" + userPassword + "]";
	}	
	

}
