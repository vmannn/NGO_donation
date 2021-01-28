package com.ngo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ngo.entities.Event;
import com.ngo.entities.User;
import com.ngo.entities.UserEvent;

@Controller
public class HomeController {

	//Autowire services here
	
	//Login page
	@RequestMapping("/")
	public String loginHome(Model model) {
		
		model.addAttribute("user", new User());
		
		return "index";
	}
	
	//on submit of login form
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("user") User user) {
		
		//Get submitted email and password from user object
		String email = user.getEmail();
		String password = user.getPassword();
		
		//Get user data from database w/ given email - return to login/notify of error if email not found
		//decrypt password of user (?)
		
		//compare submitted user password to password retrieved from database
		//if password is correct - redirect to appropriate user or admin page
		
		//TEMPORARY - setting user admin permission for testing
		user.setAdmin(true);
		
		//check if user is admin or regular user
		if(user.isAdmin()) {
			//admin user
			return "redirect:/users";
		} else {
			//regular user
			return "redirect:/donate";
		}
		
	}
	
	//Admin module - user management screen
	@RequestMapping("/users")
	public String userManagement(Model model) {
		
		//get list of users from database
		
		//TEMPORARY - creating empty list for UI testing
		List <User> users = new ArrayList<User>();
		//adding fake user entry to list for UI testing
		User usr1 = new User();
		usr1.setId(1);
		usr1.setFirstName("Fake");
		usr1.setLastName("User");
		usr1.setEmail("fakeuser@testing.com");
		usr1.setAdmin(true);
		
		users.add(usr1);
		
		model.addAttribute("users", users);
		
		return "users";
	}
	
	//Admin module - add new user screen
	@RequestMapping("/new_user")
	public String newUser(Model model) {
		model.addAttribute("user", new User());
		
		return "new_user";
	}
	
	//Admin module - add user to database upon new user form submission
	@RequestMapping(value="/add_user", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user")User user) {
		//insert user into user table of database
		
		//return to users page
		return "redirect:/users";
	}
	
	//Admin module - edit user screen
	
	//Admin module - delete user
	
	//Admin module - events page
	@RequestMapping("/events")
	public String eventManagement(Model model) {
		//get list of events from database
		
		//TEMPORARY - creating empty list for UI testing
		List <Event> events = new ArrayList<Event>();
		//adding fake event to list for UI testing
		Event event1 = new Event();
		event1.setEventName("Fake Testing Event");
		event1.setId(1);
		events.add(event1);
		
		//add events to model
		model.addAttribute("events", events);
		
		return "events";
	}
	
	//Admin module - donations page
	@RequestMapping("/donations")
	public String donations(Model model) {
		//get list of UserEvents from database
		
		//TEMPORARY - creating empty list for UI testing
		List <UserEvent> donos = new ArrayList<UserEvent>();
		
		//add UserEvents to model as attribute 'donos'
		model.addAttribute("donos", donos);
		return "donations";
	}
	
	//User module - Make a donation page
	@RequestMapping("/donate")
	public String donate(Model model) {
		
		//get list of events the user can donate to from database
		
		//TEMPORARY - creating empty list for UI testing
		List <Event> events = new ArrayList<Event>();
		//adding fake event to list for UI testing
		Event event1 = new Event();
		event1.setEventName("Fake Testing Event");
		event1.setId(1);
		events.add(event1);
		
		//add events to model
		model.addAttribute("events", events);
		
		return "donate";
	}
	
	//User module - Enter donation information screen
	
	//User module - shopping cart/checkout screen
}
