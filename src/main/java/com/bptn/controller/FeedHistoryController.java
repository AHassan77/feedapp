package com.bptn.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bptn.exceptions.InvalidPostException;
import com.bptn.exceptions.InvalidUserNameException;
import com.bptn.jpa.History;
import com.bptn.service.FeedHistoryService;

@RestController
public class FeedHistoryController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	FeedHistoryService feedHistoryService;
	
	@GetMapping("/history/username/{username}")
	  public List<History> getPostsByUsername(@PathVariable("username") String username) throws InvalidUserNameException {
		logger.debug("Executing getPostsByUsernameAPI");
		List<History> histories = this.feedHistoryService.getPostsByUsername(username);
		return histories;
	}	
	
	@GetMapping("/history/postId/{postId}")
	public Optional<History> getPostsByPostId(@PathVariable("postId") String postId) throws InvalidPostException {
		logger.debug("Getting HistoryById API");
		Optional<History> histories = this.feedHistoryService.getPostsByPostId(postId);
		return histories;
	}
	
	@GetMapping("/history/postType/{postType}")
		List<History> getPostsByPostType(@PathVariable("postType") String postType) throws InvalidPostException {
		logger.debug("Getting HistoryByType API");
		List<History> history = this.feedHistoryService.getPostsByPostType(postType);
		return history;
	}
	
	@DeleteMapping("/historydel/postType/{postType}")
	public String deleteHistoryByPostType(@PathVariable("postType") String postType) throws InvalidPostException {
		logger.debug("Deleting HistoryByType API");
		String history = this.feedHistoryService.deleteHistoryByPostType(postType);
		return history;
	}
}
