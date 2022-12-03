package com.bptn.jpa;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "\"Profile\"")
@NamedQuery(name="Profile.findAll", query="SELECT p FROM Profile p")
public class Profile implements Serializable {

    @Id
    @Column(name = "\"usernameKey\"", nullable = false)
    private String username;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "\"usernameKey\"", nullable = false)
    @JsonBackReference
    private UserID userID;
    
    @Column(name = "\"position\"", nullable = false)
    private String position;

    @Column(name = "company", nullable = false)
    private String company;

    @Column(name = "\"companyAddress\"", nullable = false)
    private String companyAddress;

    @Column(name = "interests", nullable = false)
    private String interests;

    @Column(name = "experience", nullable = false)
    private String experience;

    @Column(name = "education", nullable = false)
    private String education;

    @Column(name = "certification", nullable = false)
    private String certification;

    @Column(name = "skills", nullable = false)
    private String skills;

    @Column(name = "language", nullable = false)
    private String language;
    
    

    public Profile() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
	public Profile(String username, UserID userID, String position, String company, String companyAddress,
			String interests, String experience, String education, String certification, String skills,
			String language) {
		super();
		this.username = username;
		this.userID = userID;
		this.position = position;
		this.company = company;
		this.companyAddress = companyAddress;
		this.interests = interests;
		this.experience = experience;
		this.education = education;
		this.certification = certification;
		this.skills = skills;
		this.language = language;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public UserID getUserID() {
		return userID;
	}


	public void setUserID(UserID userID) {
		this.userID = userID;
	}


	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}


	public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
	}


	public String getCompanyAddress() {
		return companyAddress;
	}


	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}


	public String getInterests() {
		return interests;
	}


	public void setInterests(String interests) {
		this.interests = interests;
	}


	public String getExperience() {
		return experience;
	}


	public void setExperience(String experience) {
		this.experience = experience;
	}


	public String getEducation() {
		return education;
	}


	public void setEducation(String education) {
		this.education = education;
	}


	public String getCertification() {
		return certification;
	}


	public void setCertification(String certification) {
		this.certification = certification;
	}


	public String getSkills() {
		return skills;
	}


	public void setSkills(String skills) {
		this.skills = skills;
	}


	public String getLanguage() {
		return language;
	}


	public void setLanguage(String language) {
		this.language = language;
	}


	@Override
	public String toString() {
		return "Profile [username=" + username + ", userID=" + userID + ", position=" + position + ", company="
				+ company + ", companyAddress=" + companyAddress + ", interests=" + interests + ", experience="
				+ experience + ", education=" + education + ", certification=" + certification + ", skills=" + skills
				+ ", language=" + language + "]";
	}
	
	
}

	




	