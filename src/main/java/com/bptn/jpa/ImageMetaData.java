package com.bptn.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="\"ImageMetaData\"")
public class ImageMetaData {
	
	@Id
	@Column(name = "\"imageID\"")
	String imageID;
	
	@Column(name = "\"imageName\"")
	String imageName;
	
	@Column(name = "\"imageSize\"")
	String imageSize;
	
	@Column(name = "\"imageFormat\"")
	String imageFormat;
	
	@Column(name = "\"imageDate\"")
	String imageDate;
	
	@Column(name = "resolution")
	String resolution;
	
	@Column(name = "\"postKey\"")
	String postKey;

	public ImageMetaData() {
		super();
		
	}

	public ImageMetaData(String imageid, String imagename, String imagesize, String imageformat, String imagedate,
			String resolution, String postKey) {
		super();
		this.imageID = imageid;
		this.imageName = imagename;
		this.imageSize = imagesize;
		this.imageFormat = imageformat;
		this.imageDate = imagedate;
		this.resolution = resolution;
		this.postKey = postKey;
	}

	public String getImageid() {
		return imageID;
	}

	public void setImageid(String imageid) {
		this.imageID = imageid;
	}

	public String getImagename() {
		return imageName;
	}

	public void setImagename(String imagename) {
		this.imageName = imagename;
	}

	public String getImagesize() {
		return imageSize;
	}

	public void setImagesize(String imagesize) {
		this.imageSize = imagesize;
	}

	public String getImageformat() {
		return imageFormat;
	}

	public void setImageformat(String imageformat) {
		this.imageFormat = imageformat;
	}

	public String getImagedate() {
		return imageDate;
	}

	public void setImagedate(String imagedate) {
		this.imageDate = imagedate;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public String getPostKey() {
		return postKey;
	}

	public void setPostKey(String postKey) {
		this.postKey = postKey;
	}

	@Override
	public String toString() {
		return "ImageMetaData [imageid=" + imageID + ", imagename=" + imageName + ", imagesize=" + imageSize
				+ ", imageformat=" + imageFormat + ", imagedate=" + imageDate + ", resolution=" + resolution
				+ ", postKey=" + postKey + "]";
	}
	
	
	

}
