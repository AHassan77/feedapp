package com.bptn.jpa;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
	
	@Column(name = "\"usernameKey\"")
	String usernameKey;

	public History() {
		super();
		
	}

	public History(String postID, Date date, String postType, String postUpload, String usernameKey) {
		super();
		this.postID = postID;
		this.date = date;
		this.postType = postType;
		this.postUpload = postUpload;
		this.usernameKey = usernameKey;
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

	public String getUsernameKey() {
		return usernameKey;
	}

	public void setUsernameKey(String usernameKey) {
		this.usernameKey = usernameKey;
	}

	@Override
	public String toString() {
		return "History [postID=" + postID + ", date=" + date + ", postType=" + postType + ", postUpload=" + postUpload
				+ ", usernameKey=" + usernameKey + "]";
	}
	
}
