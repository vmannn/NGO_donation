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

<<<<<<< HEAD
	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", cmaNumber=" + cmaNumber + ", phoneNumber="
				+ phoneNumber + ", email=" + email + ", password=" + password + ", address1=" + address1 + ", address2="
				+ address2 + ", city=" + city + ", state=" + state + ", zip=" + zip + ", country=" + country
				+ ", urbanization=" + urbanization + ", admin=" + admin + "]";
=======
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getCmaNumber() {
		return cmaNumber;
	}

	public void setCmaNumber(long cmaNumber) {
		this.cmaNumber = cmaNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
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

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getUrbanization() {
		return urbanization;
	}

	public void setUrbanization(String urbanization) {
		this.urbanization = urbanization;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public List<UserEvent> getUserEvents() {
		return userEvents;
	}

	public void setUserEvents(List<UserEvent> userEvents) {
		this.userEvents = userEvents;
>>>>>>> NGO_donation/develop
	}
	
	
	
}
