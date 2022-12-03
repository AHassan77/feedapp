package com.bptn.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
	
	@Column(name = "post")
	String post;
	
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="\"usernameKey\"") // Foreign key for post Table
	private UserID userId;
	
	@OneToOne(mappedBy="post")
	private ImageMetaData imageMetaData;
		
	public Post() {
		super();
	
	}

	
	public Post(String postID) {
		super();
		this.postID = postID;
	}
	
	

	

	public Post(String postID, String postType, String post, UserID userId, ImageMetaData imageMetaData) {
		super();
		this.postID = postID;
		this.postType = postType;
		this.post = post;
		this.userId = userId;
		this.imageMetaData = imageMetaData;
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


	public String getPost() {
		return post;
	}


	public void setPost(String post) {
		this.post = post;
	}


	public UserID getUserId() {
		return userId;
	}


	public void setUserId(UserID userId) {
		this.userId = userId;
	}


	public ImageMetaData getImageMetaData() {
		return imageMetaData;
	}


	public void setImageMetaData(ImageMetaData imageMetaData) {
		this.imageMetaData = imageMetaData;
	}


	@Override
	public String toString() {
		return "Post [postID=" + postID + ", postType=" + postType + ", post=" + post + ", userId=" + userId
				+ ", imageMetaData=" + imageMetaData + "]";
	}
	
} 	// Have an object of user // mapp back to username


