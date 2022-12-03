/* package com.bptn.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bptn.jpa.Post;
import com.bptn.jpa.UserID;
import com.bptn.repository.LoginRepository;

//Login service will use login repository and we want spring to inject login depository using @Autowird
// That is how you connect service with repository

@Service
public class LoginService {
	
	// Dependency Injection
	@Autowired // This is going to inject the login repository. We refer to that login repository using this
	LoginRepository loginRepository;
	
	public String ValidateuserCredentials(UserID userParam) { // This method will use UserID and we use this just to transfer data. 
		                                          //Will have info about user
									  
		String message = null;
		
		Optional<UserID> opt = this.loginRepository.findById(userParam.getUsername()); // calling login repository which does not have any methods. Methods are provided by CRUD Repository
		// Find by ID returns optional. Hibernate will find by ID
		// Optional is just a wrapper in order to get userID entity have to do .orElse
		// If there is nothing there return null that what orElse(null)
		// Optional is a wrapper and inside optional we have UserID
		// if userid is found java is going to put userid in optional
		
		if (opt.isPresent() ) { // If something is found here We unwrapped using getmethod below and compare passwords
		
			if (opt.get().getUserPassword().equals(userParam.getUserPassword())){ // Comparing parameters I send with user found in database and have to match
				message = "Login Successful";
			} else {
				message = "Password Incorrect";
			}
		} else {
			message = "User Doesn't exist";
		}		
		
		return message;
	}
	
    public List<Post> getPostsByUsername(String username) {
    	
    	Optional<UserID> opt = this.loginRepository.findById(username);
    	
        return opt.orElse(null).getPosts();  
        // if you do get for an if you use or else you can just
	}
}
// Completed the second part the service. Now need a controller.
 * 
 * 
 */


