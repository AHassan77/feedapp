package com.bptn.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bptn.jpa.ImageMetaData;
import com.bptn.request.FeedMediaRequest;
import com.bptn.service.FeedMediaService;

@RestController
public class FeedMediaController {

	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	FeedMediaService feedMediaService;
	
	@GetMapping("/ImageMetaData/{postKey}")
	
	
	public ImageMetaData getImageMediaByPostKey (@PathVariable("postKey") String postKey) {
		
		logger.debug("Executing GetMediaByPostKey API");
		
		ImageMetaData imageMetaData =  this.feedMediaService.getImageMediaByPostKey(postKey);
				
		return imageMetaData;
	}
		
		@GetMapping("/ImageMetaData2/{imageID}")
		public Optional <ImageMetaData> getPostsImageMediaByImageId(@PathVariable("imageID")String imageID) {
			
			logger.debug("Executing getPostsImageMediaByImageId API");
			Optional <ImageMetaData> imageMetaData = this.feedMediaService.getPostsImageMediaByImageId(imageID);
			
			return imageMetaData;
		}
		
		@PostMapping("/imageMetaData2/createimage")
		public ImageMetaData createNewImage(@RequestBody FeedMediaRequest request) {
			logger.debug("Executing createNewimage API");
			ImageMetaData imageMetaData = this.feedMediaService.createNewImage(request);
			return imageMetaData;}
	}	


