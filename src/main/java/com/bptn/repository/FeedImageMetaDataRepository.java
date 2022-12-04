package com.bptn.repository;

import com.bptn.jpa.ImageMetaData;
import com.bptn.jpa.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedImageMetaDataRepository extends JpaRepository<ImageMetaData, String> {
    
	ImageMetaData findById(long imageId);

    List<ImageMetaData> findAllByPostKey(Post post);
}