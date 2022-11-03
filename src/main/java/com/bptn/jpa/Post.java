package com.bptn.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="\"Post\"")
public class Post {
	
	@Id
	@Column(name = "postID")
	String postID;
	
	@Column(name = "postType")
	String postType;
	
	@Column(name = "usernameKey")
	String usernameKey;

	public Post() {
		super();
		
	}

	public Post(String postid, String posttype, String usernamekey) {
		super();
		this.postID = postid;
		this.postType = posttype;
		this.usernameKey = usernamekey;
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

	public String getUsernamekey() {
		return usernameKey;
	}

	public void setUsernamekey(String usernamekey) {
		this.usernameKey = usernamekey;
	}

	@Override
	public String toString() {
		return "Post [postid=" + postID + ", posttype=" + postType + ", usernamekey=" + usernameKey + "]";
	}
	
	

}
