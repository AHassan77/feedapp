package com.bptn.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bptn.exceptions.InvalidPostException;
import com.bptn.exceptions.InvalidUserNameException;
import com.bptn.jpa.History;
import com.bptn.jpa.UserID;
import com.bptn.repository.FeedHistoryRepository;

@Service
public class FeedHistoryService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	UserService userService;
	
	@Autowired
	FeedPostService feedPostServive;
	
	
	@Autowired
	FeedHistoryRepository feedHistoryRepository;
	
	public List<History> getPostsByUsername(String username) throws InvalidUserNameException {
		this.userService.validateUserId(username);
		List<History>  historyOfPosts = this.feedHistoryRepository.findByUserId(new UserID(username));
		historyOfPosts = this.removeEmptyHistory(historyOfPosts);
		return historyOfPosts;
	}
	
	public Optional<History> getPostsByPostId(String postID) throws InvalidPostException { 
		this.validatePostId(postID);
		Optional<History> historyOfPosts = this.feedHistoryRepository.findById(postID);
		return historyOfPosts;
		
	}
	
	public List<History> getPostsByPostType(String postType) throws InvalidPostException {
		this.validatePostType(postType);
		List<History> historyOfPosts = this.feedHistoryRepository.findByPostType(postType);
		historyOfPosts = this.removeEmptyHistory(historyOfPosts);
		return historyOfPosts;
	}
	
	public String deleteHistoryByPostType(String postType) throws InvalidPostException {
		List<History> postHistory = getPostsByPostType(postType);
		if(postHistory.isEmpty()) {
			
			logger.debug("PostType: '{}'  does not exist", postType);
			
			return "Post doesn't exist";
		}
		
		this.feedHistoryRepository.deleteByPostType(postType);
		return "Deleted Successfully";
	}
	

	public List<History>removeEmptyHistory(List<History> historyOfPosts) {
		historyOfPosts.removeIf(h ->h.getPostType() == null || h.getPostType().isEmpty());
		return historyOfPosts;
	}
	
	public void validatePostId(String postID) throws InvalidPostException {
		
		String message = null;
		
		Optional<History> opt = this.feedHistoryRepository.findById(postID);
		
		if (opt.isEmpty()) {
			logger.error("PostID{} doesn't exist", postID);
			throw new InvalidPostException("This postID doesn't exist...");
		} else {
			logger.debug("PostID{} validated", postID);
		}
	}
		
		public void validatePostType(String postType) throws InvalidPostException {
			
		//	String message = null;
			
			List<History> opt = this.feedHistoryRepository.findByPostType(postType);
			
			if (opt.isEmpty()) {
				logger.error("PostType{} doesn't exist", postType);
				throw new InvalidPostException("This postType doesn't exist...");
			} else {
				logger.debug("PostType{} validated", postType);
		}
	}
}

	
	

