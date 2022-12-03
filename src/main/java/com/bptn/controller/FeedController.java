package com.bptn.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bptn.jpa.Post;
import com.bptn.service.FeedService;

@RestController
public class FeedController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	FeedService feedService;
	
	@GetMapping("/posts/username/{username}")
	public List<Post> getPostsByUsername(@PathVariable("username") String username){
	
		logger.debug("Executing getPostsByUsername API");
		
		List<Post> posts = this.feedService.getPostsbyUsername(username);
		
        return posts;
	}
	
	@GetMapping("/posts/postId/{postId}")
	public Optional<Post> getPostsById(@PathVariable("postId") String postId) {
		logger.debug("Getting PostsById API");
		Optional<Post> posts = this.feedService.getPostsByPostID(postId);
				return posts;
				
				// postID is a primary so if you reply it you get 1 record. posttype you can more
				// then more so you want to store in a list	
	}
	
	@GetMapping("/posts/postType/{postType}")
	
	public List<Post> getPostsByPostType(@PathVariable("postType") String postType) {
		logger.debug("Getting PostByType API");
		List<Post> posts = this.feedService.getPostsByPostType(postType);
		return posts;
	}
} 
