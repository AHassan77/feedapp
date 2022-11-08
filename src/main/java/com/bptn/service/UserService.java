package com.bptn.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bptn.dao.UserDao;
import com.bptn.exceptions.InvalidUserNameException;
import com.bptn.jpa.UserID;
import com.bptn.repository.UserRepository;

@Service
public class UserService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	UserRepository userRepository;
	
	public String validateUserId(String username) throws InvalidUserNameException {
		
		String message = null;
		
		Optional<UserID> option = this.userRepository.findById(username);
		
		if (option.isEmpty()) {
			logger.error("Username={} doesn't exist", username);
			throw new InvalidUserNameException("Invalid User Name...");
		} else {
			logger.debug("Username={} validated", username);

			/*
			 * if (option.isPresent()) { logger.error("Username={} doesn't exist",
			 * username); if (option.get().getUsername().equals(username)) { message =
			 * "username validated"; }else { throw new
			 * InvalidUserNameException("Invalid User Name..."); } }
			 */

			return message;

		}
	}
	
	public List<com.bptn.bean.UserID> listUsers(){

		List<com.bptn.bean.UserID> users = userDao.listUsers();

		users.forEach(u -> logger.debug("{}",u));

		return users;
	}

	public com.bptn.bean.UserID findUser(String username){
		
		com.bptn.bean.UserID user = userDao.findByUsername(username);

		logger.debug("{}",user);
		
		return user;
	}

	public void createUser(com.bptn.bean.UserID user){
		
		this.userDao.createUser(user);

		logger.debug("User Created: {}",user);		
	}
}



