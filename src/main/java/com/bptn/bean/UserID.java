package com.bptn.bean;

// Dao package is similiar to repository

import java.util.List;

import com.bptn.jpa.Post;

public class UserID {

		String username;

		String name;

		String emailID;
		
		Integer phoneNumber;
		
		String userPassword;
		
		List<Post> posts;

		public UserID() {
			super();
			
		}

		public UserID(String username, String name, String emailID, Integer phoneNumber, String userPassword,
				List<Post> posts) {
			super();
			this.username = username;
			this.name = name;
			this.emailID = emailID;
			this.phoneNumber = phoneNumber;
			this.userPassword = userPassword;
			this.posts = posts;
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

		public String getEmailID() {
			return emailID;
		}

		public void setEmailID(String emailID) {
			this.emailID = emailID;
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
			return "UserID [username=" + username + ", name=" + name + ", emailID=" + emailID + ", phoneNumber="
					+ phoneNumber + ", userPassword=" + userPassword + ", posts=" + posts + "]";
		}
		
				
}
