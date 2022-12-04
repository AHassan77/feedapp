package com.bptn.jpa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "\"UserID\"")
@NamedQuery(name="UserID.findAll", query="SELECT u FROM UserID u")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class UserID implements Serializable {

	private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "\"emailID\"", nullable = false)
    private String emailID;

    @Column(name = "\"phoneNumber\"", nullable = false)
    private Integer phoneNumber;

    @OneToMany(mappedBy = "usernameKey", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Role> roles = new LinkedHashSet<>();

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "userID")
    @JsonManagedReference
    private Profile profile;

    @OneToMany(mappedBy = "usernameKey", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Address> addresses = new LinkedHashSet<>();

    public UserID(String username2) {
		// TODO Auto-generated constructor stub
	}

	public UserID() {
		// TODO Auto-generated constructor stub
	}

	public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer integer) {
        this.phoneNumber = integer;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String id) {
        this.username = id;
    }

	@Override
	public String toString() {
		return "UserID [username=" + username + ", name=" + name + ", emailID=" + emailID + ", phoneNumber="
				+ phoneNumber + ", roles=" + roles + ", profile=" + profile + ", addresses=" + addresses + "]";
	}
    
 }