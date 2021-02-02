package com.ngo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ngo.entities.User;
import com.ngo.repos.EventRepo;
import com.ngo.repos.UserRepo;
import com.ngo.services.EventService;
import com.ngo.services.UserService;

@SpringBootTest
public class ServiceTest {

	@Test
	void contextLoads() {}
	
	
	
	@Mock
	UserRepo userRepo;

	@Autowired
	@InjectMocks
	UserService userService;
	
    @Mock 
    EventRepo eventRepo;
    
    @Autowired
    @InjectMocks
    EventService eventService;
	
	/*
	@Test
	void addUserTest() {
		
		Assertions.assertEquals(1, userService.addUser("Jerry", "Perkings", 32323322, "5039229251", "JPerk@gmail.com", "thisismypassword",
				"4343 derry rd", "2353 hallway ave", "Vancouver", "Washington", 95433, "United States", "super urban",
				false));
		
		
	}
	
	@Test
	void addEventTest() {
		
		//Assertions.assertEquals(1, eventService.addEvent("Run for the arts"));
		
		
	}
	
	@Test
	void returnEventsTest() {
		
		//eventService.addEvent("Run for the arts");
		//Assertions.assertEquals(1, eventService.returnEvents().size());
		
	}
	
	
	@Test
	void returnUsersTest() {
		
		userService.addUser("Jerry", "Perkings", 32323322, "5039229251", "JPerk@gmail.com", "thisismypassword",
				"4343 derry rd", "2353 hallway ave", "Vancouver", "Washington", 95433, "United States", "super urban",
				false);
		
		Assertions.assertEquals(1, userService.returnUsers().size());
		
	}
	
	@Test
	void deleteUserTest() {
		
		User user = new User("Jerry", "Perkings", 32323322, "5039229251", "JPerk@gmail.com", "thisismypassword",
				"4343 derry rd", "2353 hallway ave", "Vancouver", "Washington", 95433, "United States", "super urban",
				false);
		
		Assertions.assertEquals(1, userService.addUser(user));
		Assertions.assertEquals(0, userService.deleteUser(user));

	
		
	}
	*/
}
