package com.bptn.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="\"Post\"")
public class Post {
	
	@Id
	@Column(name = "\"postID\"")
	String postID;
	
	@Column(name = "\"postType\"")
	String postType;	
	
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="\"usernameKey\"") // Foreign key for post Table
	private UserID userId;


	public Post() {
		super();
		
	}


	public Post(String postID, String postType, UserID userId) {
		super();
		this.postID = postID;
		this.postType = postType;
		this.userId = userId;
	}


	public String getPostID() {
		return postID;
	}


	public void setPostID(String postID) {
		this.postID = postID;
	}


	public String getPostType() {
		return postType;
	}


	public void setPostType(String postType) {
		this.postType = postType;
	}


	public UserID getUserId() {
		return userId;
	}


	public void setUserId(UserID userId) {
		this.userId = userId;
	}


	@Override
	public String toString() {
		return "Post [postID=" + postID + ", postType=" + postType + ", userId=" + userId + "]";
	} // Have an object of user // mapp back to username

}
