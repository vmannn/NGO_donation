package com.ngo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ngo.entities.Event;
import com.ngo.entities.User;
import com.ngo.repos.EventRepo;
import com.ngo.repos.UserRepo;

@SpringBootTest
public class RepoTest {

	
	@Test
	void contextLoads() {};
	
	@Autowired
	UserRepo userRepo;
	@Autowired
	EventRepo eventRepo;
	
	@Test
	void addUser() {
		
		User user = new User("Jerry", "Perkings", 32323322, "5039229251", "JPerk@gmail.com", "thisismypassword",
				"4343 derry rd", "2353 hallway ave", "Vancouver", "Washington", 95433, "United States", "super urban",
				false);
		
		userRepo.save(user);
		
	}
	
	@Test
	void addEvent() {
	   
		Event event = new Event("Puppy fundraiser");
		eventRepo.save(event);
		
	}
	
}
