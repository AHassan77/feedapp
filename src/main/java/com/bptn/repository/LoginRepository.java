package com.bptn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bptn.jpa.UserID;

@Repository
public interface LoginRepository extends JpaRepository<UserID, String> { // Have to put name of entity first which is user id and then datatype
	// which is type of key for JPA entity which is String
	// Look at userID @ID is spring
	// In login repository dont add any methods
	//The methods will be implemented by hibernate
	//just create interface and hibernate will take care of the next
	// By doing this we have all the methods in the CRUD repository

}