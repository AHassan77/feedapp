package com.bptn.service;

import java.util.Objects;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bptn.jpa.Post;
import com.bptn.jpa.UserID;
import com.bptn.repository.FeedPostRepository;
import com.bptn.request.FeedPostRequest;

@Service
public class FeedPostService {
	
	/*
	{ Fields we get from API when we query news service. We need object to receive data below.
	We are going to use that object from the controller. Need to create FeedPostRequest
	This object will have the parameters for the 3rd party api
		"fromDate": "2022-10-13",
		"toDate": "2022-11-07",
		"queryKeyword": "newyork",
		"username": "carlos"
		
	  
	 * 
	 */
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	// @Value is going to read from YML or application property file
	@Value("${api.key}")
	String apiKey;
	
	@Value("${api.base.url}")
	String apiBaseUrl;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	FeedPostRepository feedPostRepository;
	
	{ 
		// "from Date":"2022-10-13",
		// "toDate": "2022-11-07",
		// "queryKeyword": "newyork",
		// "username": "carlos"
	}
	
	public Post getPostFormNewsAndSavePost(FeedPostRequest request) {
		
		// Post feed = new Post();
		
		/*
		 * 1. Build the url of the request for newsAPI
		 * buildAPIUrl() Step 9 in coding room 8.2
		 */
		
		String url = this.buildAPIUrl(request);
		
		/*
		 * 2. Send the request to the newsapi and receive the response
		 *  Need to code getFeedFromNewsApi(String URL) Step 7 coding from 8.2
		 */
		
		String feedResult = getFeedFromNewsAPI(url);
		
		/*
		 * 3. Store the data received in step 2 in postgresl
		 *  Need to code storeFeed() Step 8 coding room 8.2
		 */		
				
		// To send request from our application. Spring provides us with an object
		// We need to make that object available to make the request
		
		Post feed = storeFeed(feedResult,request);
		return feed;
	}
	
	private String buildAPIUrl(FeedPostRequest request) {
		StringBuilder urlBuilder = new StringBuilder(); // Mutable - Not Thread Safe
		
		//integration sign and what comes next is parameters
		
		
		urlBuilder.append(apiBaseUrl)
				  .append("?q=")
				  .append(request.getQueryKeyword());
	    
				  if ( request.getFromDate() != null && !request.getFromDate().isEmpty()) {
					  urlBuilder.append("&from=").append(request.getFromDate());
					  
				  }
				  
				  if (request.getFromDate()!=null && !request.getToDate().isEmpty()) {
					  urlBuilder.append("&to=").append(request.getToDate());
				  }
				  
				  urlBuilder.append("&apiKey=").append(apiKey);
				  
				  return urlBuilder.toString();
				}
	
			private String getFeedFromNewsAPI(String url) {
				
				String result = this.restTemplate.getForObject(url, String.class);
				
				return result;
			}
			
			private Post storeFeed(String feedResult, FeedPostRequest request) {
				
				UserID userId = new UserID(request.getUsername() );
				Post feed = new Post();
				
				feed.setPostType(feedResult);
				
				feed.setUserId(userId);
				feed.setPostID(this.generatePostId(request));
				logger.debug("Feed to be stored: {}", feed);
				
				return this.feedPostRepository.save(feed);
			}
			
			private String generatePostId(FeedPostRequest request) {

				Random random = new Random(System.currentTimeMillis());

				StringBuilder postIdBuilder = new StringBuilder();

				postIdBuilder.append(random.nextInt());
				postIdBuilder.append(Objects.hashCode(request.getUsername() + " " + request.getQueryKeyword()));

				String postId = postIdBuilder.toString();
				if (postId.startsWith("-")) {
					postId = postId.substring(1);
				}

				return postId;
			}
		}