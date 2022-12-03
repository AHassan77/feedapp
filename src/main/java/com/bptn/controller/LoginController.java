/* package com.bptn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bptn.jpa.Post;
import com.bptn.jpa.UserID;
import com.bptn.service.LoginService;
import java.util.List;

@RestController 

// First loginControlelr is going to use loginservice
// We have dependency injection so use Autowired
// Spring will create objects in IOC container just by usign the annotation
public class LoginController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	LoginService loginService;
	
	// Make public so it can be accessed from anywhere
	
	// Passing user credentials to see if it matches
	
	@PostMapping("login")
	public String valdiateUsercredentials(@RequestBody UserID userID) { // Need special annotation so we use RequestBody
		// RequestBody populate all the feilds with the example provided
		// UserID has 5 attributes but we just want to send username and userpasswrd
		// Spring will handle these automatically
		
		String response = this.loginService.ValidateuserCredentials(userID);
		
		return response;
	}
	
	@GetMapping(value = "/users/posts/username/{username}")
    public List<Post> getPostsByUsername(@PathVariable("username") String username) {
        
    	logger.debug("Executing getPostsByUsername API");
        
    	List<Post> posts = this.loginService.getPostsByUsername(username);
        return posts;
	}

} 
*/
