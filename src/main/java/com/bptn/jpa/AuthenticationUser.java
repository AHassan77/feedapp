package com.bptn.jpa;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "\"AuthenticationUser\"")
@NamedQuery(name="AuthenticationUser.findAll", query="SELECT a FROM AuthenticationUser a")
public class AuthenticationUser implements Serializable {
	private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "\"usernameKey\"", nullable = false)
    private String id;

    @MapsId
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "\"usernameKey\"", nullable = false)
    private UserID userID;

    @Column(name = "\"userPassword\"", nullable = false)
    private String userPassword;

    @Column(name = "\"phoneNumber\"", nullable = false)
    private Integer phoneNumber;

    @Column(name = "\"securityQuestion1\"", nullable = false)
    private String securityQuestion1;

    @Column(name = "\"securityQuestion2\"", nullable = false)
    private String securityQuestion2;

    @Column(name = "\"securityQuestion3\"", nullable = false)
    private String securityQuestion3;

    @Column(name = "\"securityAnswer1\"", nullable = false)
    private String securityAnswer1;

    @Column(name = "\"securityAnswer2\"", nullable = false)
    private String securityAnswer2;

    @Column(name = "\"securityAnswer3\"", nullable = false)
    private String securityAnswer3;
    
    

    public AuthenticationUser() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
	public AuthenticationUser(String id, UserID userID, String userPassword, Integer phoneNumber,
			String securityQuestion1, String securityQuestion2, String securityQuestion3, String securityAnswer1,
			String securityAnswer2, String securityAnswer3) {
		super();
		this.id = id;
		this.userID = userID;
		this.userPassword = userPassword;
		this.phoneNumber = phoneNumber;
		this.securityQuestion1 = securityQuestion1;
		this.securityQuestion2 = securityQuestion2;
		this.securityQuestion3 = securityQuestion3;
		this.securityAnswer1 = securityAnswer1;
		this.securityAnswer2 = securityAnswer2;
		this.securityAnswer3 = securityAnswer3;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public UserID getUserID() {
		return userID;
	}


	public void setUserID(UserID userID) {
		this.userID = userID;
	}


	public String getUserPassword() {
		return userPassword;
	}


	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}


	public Integer getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getSecurityQuestion1() {
		return securityQuestion1;
	}


	public void setSecurityQuestion1(String securityQuestion1) {
		this.securityQuestion1 = securityQuestion1;
	}


	public String getSecurityQuestion2() {
		return securityQuestion2;
	}


	public void setSecurityQuestion2(String securityQuestion2) {
		this.securityQuestion2 = securityQuestion2;
	}


	public String getSecurityQuestion3() {
		return securityQuestion3;
	}


	public void setSecurityQuestion3(String securityQuestion3) {
		this.securityQuestion3 = securityQuestion3;
	}


	public String getSecurityAnswer1() {
		return securityAnswer1;
	}


	public void setSecurityAnswer1(String securityAnswer1) {
		this.securityAnswer1 = securityAnswer1;
	}


	public String getSecurityAnswer2() {
		return securityAnswer2;
	}


	public void setSecurityAnswer2(String securityAnswer2) {
		this.securityAnswer2 = securityAnswer2;
	}


	public String getSecurityAnswer3() {
		return securityAnswer3;
	}


	public void setSecurityAnswer3(String securityAnswer3) {
		this.securityAnswer3 = securityAnswer3;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "AuthenticationUser [id=" + id + ", userID=" + userID + ", userPassword=" + userPassword
				+ ", phoneNumber=" + phoneNumber + ", securityQuestion1=" + securityQuestion1 + ", securityQuestion2="
				+ securityQuestion2 + ", securityQuestion3=" + securityQuestion3 + ", securityAnswer1="
				+ securityAnswer1 + ", securityAnswer2=" + securityAnswer2 + ", securityAnswer3=" + securityAnswer3
				+ "]";
	}

}