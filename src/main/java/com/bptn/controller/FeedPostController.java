package com.bptn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bptn.exceptions.InvalidRequestException;
import com.bptn.exceptions.InvalidUserNameException;
import com.bptn.jpa.Post;
import com.bptn.request.FeedPostRequest;
import com.bptn.service.FeedPostService;
import com.bptn.service.UserService;

@RestController
public class FeedPostController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	FeedPostService feedPostService;
	
	@Autowired
	UserService userService;
	
	 @PostMapping("/posts/feed/create")  //<?> --> integration signs means you can past anytype
	public ResponseEntity<?> saveFeed(@RequestBody FeedPostRequest request) {
		
		logger.debug("Executing saveFeed API");
		
		try {
			this.validateRequest(request);
			
			this.userService.validateUserId(request.getUsername());
			
			Post feed = this.feedPostService.getPostFromNewsAndSavePost(request);
			
			logger.debug("Post saved Successfully");
			
			return new ResponseEntity<> (feed,HttpStatus.OK);
			
		} catch (InvalidRequestException | InvalidUserNameException ex) {
			
			// logger.error(Arrays.toString(ex.getStackTrace()));
			
			logger.error(ex.getMessage(),ex); // Logger will print stack trace & logger
			
			// ex.printStackTrace(); This will print straight to the console
			
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
				
	} 
	
	@PostMapping("/posts/feed/create2")  //<?> --> integration signs means you can past anytype
	public Post saveFeed2(@RequestBody FeedPostRequest request) 
		throws InvalidRequestException, InvalidUserNameException {
		
		logger.debug("Executing saveFeed API");
				
			this.validateRequest(request);
			
			this.userService.validateUserId(request.getUsername());
			
			Post feed = this.feedPostService.getPostFromNewsAndSavePost(request);
			
			logger.debug("Post saved Successfully");
			
			return feed;
		
	}
				
		private void validateRequest(FeedPostRequest request) throws InvalidRequestException {
		
		if ( !StringUtils.hasText(request.getFromDate()) ||
			 !StringUtils.hasText(request.getToDate())) {
		throw new InvalidRequestException("Invalid request: FromDate and ToDate Required");
		
		/*
		 * Another way to write this
		 * 
		 */
		/* private void validateRequest2(FeedPostRequest request) throws InvalidRequestException {
		if (request.getFromDate()!null && request.getFromDate().trim().isBlank() ||
		   (request.getToDate()!=null && request.getToDate().trim().isBlank()) {
			throw new InvalidRequestException("Invalid request: FromDate and ToDateRequired");
		*/
			
		}
	}
		
		private void validateRequest2(FeedPostRequest request) throws InvalidRequestException {
			
			if ( !StringUtils.hasText(request.getFromDate()) ||
				 !StringUtils.hasText(request.getToDate())) {
			throw new InvalidRequestException("Invalid request: FromDate and ToDate Required");
		}
	}

}