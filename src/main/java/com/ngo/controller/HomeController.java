package com.ngo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView login(@ModelAttribute("user") User user, ModelMap model) {
		
		//Get submitted email and password from user object
		String email = user.getEmail();
		String password = user.getPassword();
		
		//TODO - Get user data from database w/ given email - return to login/notify of error if email not found
		//TODO - decrypt password of user (?)
		
		//TODO - compare submitted user password to password retrieved from database
		//if password is correct - redirect to appropriate user or admin page
		
		//TEMPORARY - setting user admin permission and ID for UI testing
		user.setAdmin(false);
		user.setId(1);
		model.addAttribute("user", user);
		
		//check if user is admin or regular user
		if(user.isAdmin()) {
			//admin user
			return new ModelAndView("redirect:/users", model);
		} else {
			//regular user
			return new ModelAndView("redirect:/donate", model);
		}
		
	}
	
	//Admin module - user management screen
	@RequestMapping("/users")
	public String userManagement(@ModelAttribute("user")User user, Model model) {
		
		//TODO - get list of users from database
		
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
		//TODO - insert user into user table of database
		
		//return to users page
		return "redirect:/users";
	}
	
	//Admin module - edit user screen
	@RequestMapping("/edit_user/{id}")
	public String editUser(Model model, @PathVariable(name="id") int id) {
		
		//TODO - get user by ID from database
		//i.e - User usr = userService.getUserById(id);
		
		//add user to model as attribute 'user' so their data can be pre-loaded into the fields
		//model.addAttribute("user", usr);
		
		return "edit_user";
	}
	
	//Admin module - update user data upon edit user form submission
	@RequestMapping(value="/update_user", method = RequestMethod.POST)
	public String updateUser(@ModelAttribute("user") User user) {
		//TODO - update user entry in database
		//userService.updateUser(user);
		
		//return to users page
		return "redirect:/users";
	}
	
	//Admin module - delete user
	@RequestMapping("/delete_user/{id}")
	public String deleteUser(Model model, @PathVariable(name="id")int id) {
		
		//TODO - get user by ID from database
		// i.e - User usr = userService.getUserById(id);
		
		//TEMPORARY - fake user for testing purposes
		User usr1 = new User();
		usr1.setId(1);
		usr1.setFirstName("Fake");
		usr1.setLastName("User");
		usr1.setEmail("fakeuser@testing.com");
		usr1.setAdmin(true);
		
		
		//add user to model as attribute 'user' so their data can be displayed on confirmation screen
		model.addAttribute("user", usr1);
		
		return "delete_user";
	}
	
	//Admin module - delete user entity from database
	@RequestMapping("/del_user")
	public String removeUser(@ModelAttribute("user") User user) {
		
		//TODO - delete user from database
		//userService.deleteUser(user);
		
		//return to users page
		return "redirect:/users";
	}
	
	
	//Admin module - events page
	@RequestMapping("/events")
	public String eventManagement(Model model) {
		//TODO - get list of events from database
		
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
	
	//Admin module - create new event page
	@RequestMapping("/new_event")
	public String newEvent(Model model) {
		model.addAttribute("event", new Event());
		
		return "new_event";
	}
	//Admin module - add event to DB
	@RequestMapping(value="/add_event", method = RequestMethod.POST)
	public String addEvent(@ModelAttribute("event")Event event) {
		//TODO - insert event into event table of database
		
		//return to users page
		return "redirect:/events";
	}
	
	//Admin module - edit event page
	@RequestMapping("/edit_event/{id}")
	public String editEvent(Model model, @PathVariable(name="id") int id) {
		
		//TODO - get event by ID from database

		//add event to model as attribute 'event' so the data can be pre-loaded into the fields
		//model.addAttribute("event", event);
		
		return "edit_event";
	}
	
	//Admin module - update event in DB
	@RequestMapping(value="/update_event", method = RequestMethod.POST)
	public String updateUser(@ModelAttribute("event") Event event) {
		//TODO - update event entry in database
		
		//return to events page
		return "redirect:/events";
	}
	
	//Admin module - delete event page
	@RequestMapping("/delete_event/{id}")
	public String deleteEvent(@PathVariable(name="id") int id, Model model) {
		//TODO - get event by ID from DB
		
		//TEMPORARY - creating fake event for UI testing
		Event event1 = new Event();
		event1.setEventName("Fake Testing Event");
		event1.setId(1);
		
		//add event to model as attribute 'event'
		model.addAttribute("event", event1);
		
		return "delete_event";
	}
	
	//Admin module - delete event from DB
	@RequestMapping("/del_event")
	public String removeEvent(@ModelAttribute("event")Event event) {
		//TODO - delete event from database
		
		//return to events page
		return "redirect:/events";
	}
	
	
	//Admin module - donations page
	@RequestMapping("/donations")
	public String donations(Model model) {
		//TODO - get list of UserEvents from database
		
		//TEMPORARY - creating empty list for UI testing
		List <UserEvent> donos = new ArrayList<UserEvent>();
		
		//add UserEvents to model as attribute 'donos'
		model.addAttribute("donos", donos);
		return "donations";
	}
	
	//User module - Make a donation page
	@RequestMapping("/donate")
	public String donate(@ModelAttribute("user")User user, Model model) {
		
		//TODO - get list of events the user can donate to from database
		
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
	@RequestMapping("/new_donation/{id}")
	public String new_donation(@ModelAttribute("user") User user, @PathVariable("id")int eventId, Model model) {
		
		//TODO - get event by id
		
		//TEMPORARY - creating fake event for UI testing
		Event event1 = new Event();
		event1.setEventName("Fake Testing Event");
		event1.setId(1);
		
		//create new UserEvent
		UserEvent dono = new UserEvent();
		//set user and event fields of UserEvent
		dono.setUser(user);
		dono.setEvent(event1);
		
		//add UserEvent to model
		model.addAttribute("dono", dono);
	
		return "new_donation";
	}
	
	//User module - shopping cart/checkout screen
	@RequestMapping("/checkout")
	public String checkout(@ModelAttribute("dono") UserEvent dono, Model model) {
		
		
		//get user
		User user = dono.getUser();
		
		//add user and dono to model

		
		return "checkout";
	}
	
	//User module - add donation/UserEvent to database
	@RequestMapping("/add_dono")
	public ModelAndView add_donation(@ModelAttribute("dono")UserEvent dono, ModelMap model) {
		
		//TODO - save dono to database
		
		User usr = dono.getUser();
		model.addAttribute("user", usr);
		
		//return to donate page
		return new ModelAndView("redirect:/donate", model);
	}
}
