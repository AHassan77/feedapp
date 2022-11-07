package com.bptn.request;

public class FeedPostRequest {
	
	/* 
	 * "fromDate": "2022-10-13",
	 
	"toDate": "2022-11-07",
	"queryKeyword": "newyork",
	"username": "carlos"
		*/
	
	/*
	 * Note IF you change the name from getters a
	 * If you want to change name of the properties. From uppercase to lowercase
	 You have to delete the old getter and setter and set new ones
	 Dont change method manually always use source to generate
	 */
	
		String fromDate;	
		String toDate;		
		String queryKeyword;
		String username;
		public String getFromDate() {
			return fromDate;
		}
		public void setFromDate(String fromDate) {
			this.fromDate = fromDate;
		}
		public String getToDate() {
			return toDate;
		}
		public void setToDate(String toDate) {
			this.toDate = toDate;
		}
		public String getQueryKeyword() {
			return queryKeyword;
		}
		public void setQueryKeyword(String queryKeyword) {
			this.queryKeyword = queryKeyword;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		
		
	

}
