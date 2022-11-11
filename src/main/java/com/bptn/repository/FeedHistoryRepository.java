package com.bptn.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bptn.jpa.History;
import com.bptn.jpa.UserID;

@Repository
public interface FeedHistoryRepository extends JpaRepository<History, String> {
	
	List<History> findByUserId(UserID userId);
	
	List<History> findByPostType(String postType);
	
	@Transactional
    void deleteByPostType(String postType);
		
}
