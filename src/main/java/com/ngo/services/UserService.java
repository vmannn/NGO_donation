package com.ngo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ngo.entities.Event;
import com.ngo.entities.User;
import com.ngo.repos.UserRepo;

@Service
public class UserService {
	
	@Autowired 
	UserRepo userRepo;
	
	//function to add/edit user
	@Transactional
	public int addUser(User user) {
		
		userRepo.save(user);
		
		//used for testing
	    return userRepo.findAll().size();
	}
	
	
	//alternative function to add a user (used in testing)
	@Transactional
	public int addUser(String firstName, String lastName, long cmaNumber, String phoneNumber, String email, String password,
			String address1, String address2, String city, String state, int zip, String country, String urbanization,
			boolean admin){
	
		User user = new User(firstName, lastName, cmaNumber, phoneNumber, email, password,
			address1, address2, city, state, zip, country, urbanization,
			admin);
		
		userRepo.save(user);
		
		//used for testing
		return userRepo.findAll().size();
		
	}
	
	//function returns a list of all users
	@Transactional
	public ArrayList<User> returnUsers(){
		
		return (ArrayList<User>) userRepo.findAll();
		
	}
	
	//function deletes a user
	@Transactional
	public int deleteUser(User user) {
		
		userRepo.delete(user);
		
		//used for testing
		return userRepo.findAll().size();
		
	}
	
	//function get user object from a users email
	@Transactional
	public User getUserFromEmail(String email) {
		
		return userRepo.getUserFromEmail(email);
		
	}
	
	//function retrieves user by id
	@Transactional
	public User getUserFromId(int id) {
		
		return userRepo.getUserFromId(id);
		
	}
	
	
}
