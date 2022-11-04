package com.bptn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bptn.jpa.UserID;

@Repository
public interface UserRepository extends JpaRepository<UserID,String> {

}
