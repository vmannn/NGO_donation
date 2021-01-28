package com.ngo.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String firstName;
	String lastName;
	long cmaNumber;
	String phoneNumber;
	String email;
	String password;
	String address1;
	String address2;
	String city;
	String state;
	int zip;
	String country;
	String urbanization;
	boolean admin;
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List <UserEvent> userEvents;
	
	public User() {}

	public User(String firstName, String lastName, long cmaNumber, String phoneNumber, String email, String password,
			String address1, String address2, String city, String state, int zip, String country, String urbanization,
			boolean admin) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.cmaNumber = cmaNumber;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.password = password;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.country = country;
		this.urbanization = urbanization;
		this.admin = admin;
	}
	
	
	
}
