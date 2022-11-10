package com.bptn.service;

import java.util.Objects;
import java.util.Optional;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bptn.jpa.ImageMetaData;
import com.bptn.jpa.Post;
import com.bptn.repository.FeedImageMetaDataRepository;

@Service
public class FeedMediaService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	FeedImageMetaDataRepository feedImageMetaDataRepository;
	
	public ImageMetaData getImageMediaByPostKey(String postID) {
		ImageMetaData imageMetaData = this.feedImageMetaDataRepository.findByPost(new Post(postID));
		return imageMetaData;
	}
	
	public Optional <ImageMetaData> getPostsImageMediaByImageId(String ImageID) {
		Optional<ImageMetaData> imageMetaData = this.feedImageMetaDataRepository.findById(ImageID);
		return imageMetaData;
		
	}
	
	public ImageMetaData createNewImage(ImageMetaData imageMetaData) {
		ImageMetaData newImage = new ImageMetaData();
		
		newImage.setImageName(imageMetaData.getImageName());
		
		return this.feedImageMetaDataRepository.save(newImage);
	}
	
	public ImageMetaData createNewImage(ImageMetaData imageMetaData, Post post) {
		
		ImageMetaData newImage = new ImageMetaData();
		
		newImage.setImageID(this.generateImageId(post));
		newImage.setImageName(imageMetaData.getImageName());
		newImage.setImageFormat(imageMetaData.getImageFormat());
		newImage.setImageSize(imageMetaData.getImageSize());
		newImage.setImageDate(imageMetaData.getImageDate());
		newImage.setResolution(imageMetaData.getResolution());
		newImage.setPost(post);
		
		return this.feedImageMetaDataRepository.save(newImage);
	}
	
	private String generateImageId(Post post) {
		
		Random random = new Random(System.currentTimeMillis());
		
		StringBuilder imageIdBuilder = new StringBuilder();
		
		imageIdBuilder.append(random.nextInt());
		imageIdBuilder.append(Objects.hashCode(post.getPostID()));
		
		String imageId = imageIdBuilder.toString();
		
		if (imageId.startsWith("-")) {
			imageId = imageId.substring(1);
		}
		
		logger.debug("Generated post ID: {} ", imageId);
		
		return imageId;
	}
	
}
