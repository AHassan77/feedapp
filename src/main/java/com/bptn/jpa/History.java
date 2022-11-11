package com.bptn.jpa;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="\"History\"")
public class History {
	
	@Id
	@Column(name = "\"postID\"")
	String postID;
	
	@Column(name = "date")
	Date date;
	
	@Column(name = "\"postType\"")
	String postType;
	
	@Column(name = "\"postUpload\"")
	String postUpload;
	
	//@Column(name = "\"usernameKey\"")
	//String usernameKey;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="\"usernameKey\"") // Foreign key for post Table
	private UserID userId;

	public History() {
		super();
		
	}

	public History(String postID, Date date, String postType, String postUpload, UserID userId) {
		super();
		this.postID = postID;
		this.date = date;
		this.postType = postType;
		this.postUpload = postUpload;
		this.userId = userId;
	}

	public String getPostID() {
		return postID;
	}

	public void setPostID(String postID) {
		this.postID = postID;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPostType() {
		return postType;
	}

	public void setPostType(String postType) {
		this.postType = postType;
	}

	public String getPostUpload() {
		return postUpload;
	}

	public void setPostUpload(String postUpload) {
		this.postUpload = postUpload;
	}

	public UserID getUserId() {
		return userId;
	}

	public void setUserId(UserID userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "History [postID=" + postID + ", date=" + date + ", postType=" + postType + ", postUpload=" + postUpload
				+ ", userId=" + userId + "]";
	}	
	
}
