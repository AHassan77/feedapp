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
	
	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name="\"usernameKey\"") // Foreign key for post Table
	private UserID userId; // Have an object of user

	public Post() {
		super();
		
	}

	public Post(String postid, String posttype, String usernamekey) {
		super();
		this.postID = postid;
		this.postType = posttype;
	
	}

	public String getPostid() {
		return postID;
	}

	public void setPostid(String postid) {
		this.postID = postid;
	}
	
	

	public String getPosttype() {
		return postType;
	}

	public void setPosttype(String posttype) {
		this.postType = posttype;
	}

	
	@Override
	public String toString() {
		return "Post [postid=" + postID + ", posttype=" + postType + ", usernamekey=" + "]";
	}
	
	

}
