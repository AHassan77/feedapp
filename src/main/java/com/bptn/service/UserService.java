package com.bptn.service;

import com.bptn.exceptions.InvalidUserNameException;
import com.bptn.jpa.UserID;
import com.bptn.repository.UserRepository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserRepository userRepository;

    public void validateUserId(String username) throws InvalidUserNameException {
        UserID userID = userRepository.findByUsername(username);
        if (userID == null) {
            LOGGER.error("Username={} doesn't exist", username);
            throw new InvalidUserNameException("Username doesn't exist");
        } else {
            LOGGER.debug("Username={} validated", username);
        }
    }

	public List<com.bptn.bean.UserID> listUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	public com.bptn.bean.UserID findUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public void createUser(com.bptn.bean.UserID user) {
		// TODO Auto-generated method stub
		
	}
}