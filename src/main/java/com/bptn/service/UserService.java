package com.bptn.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bptn.exceptions.InvalidUserNameException;
import com.bptn.jpa.UserID;
import com.bptn.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public String validateUserId(String username) throws InvalidUserNameException {
		
		String message = null;
		
		Optional<UserID> option = this.userRepository.findById(username);
		
		if (option.isPresent()) {
			if (option.get().getUsername().equals(username)) {
				message = "username validated";
			}else {
				throw new InvalidUserNameException("Invalid User Name...");
			}
		}
		
		return message;
		
	}
	

}
