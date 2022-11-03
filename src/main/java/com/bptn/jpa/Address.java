package com.bptn.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="\"Address\"")

public class Address {
	
	@Id
	@Column(name = "\"usernameKey\"")
	String usernameKey;
	
	@Column(name = "address")
	String address;
	
	@Column(name = "city")
	String city;
	
	@Column(name = "state")
	String state;
	
	@Column(name = "country")
	String country;
	
	@Column(name = "pincode")
	String pincode;

	public Address() {
		super();
		
	}

	public Address(String username, String address, String city, String state, String country, String pincode) {
		super();
		this.usernameKey = username;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
	}

	public String getUsername() {
		return usernameKey;
	}

	public void setUsername(String username) {
		this.usernameKey = username;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address [username=" + usernameKey + ", address=" + address + ", city=" + city + ", state=" + state
				+ ", country=" + country + ", pincode=" + pincode + "]";
	}
	
		

}
