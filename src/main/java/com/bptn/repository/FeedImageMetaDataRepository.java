package com.bptn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bptn.jpa.ImageMetaData;
import com.bptn.jpa.Post;

public interface FeedImageMetaDataRepository extends JpaRepository<ImageMetaData, String> {
	
	ImageMetaData findByPost(Post post);

}
