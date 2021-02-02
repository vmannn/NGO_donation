package com.ngo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.ngo.entities.Event;
import com.ngo.entities.User;
import com.ngo.entities.UserEvent;
import com.ngo.services.EventService;
import com.ngo.services.UserEventService;
import com.ngo.services.UserService;

@Controller
public class HomeController {

	//Autowire services here
	@Autowired
	UserService userService;
	
	@Autowired
	EventService eventService;
	
	@Autowired
	UserEventService userEventService;
	
	//Login page
	@RequestMapping("/")
	public String loginHome(Model model) {
		
		model.addAttribute("user", new User());
		
		return "index";
	}
	
	//on submit of login form
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public RedirectView login(@ModelAttribute("user") User user, RedirectAttributes redirectAttrs) {
		
		//Get submitted email and password from user object
		String email = user.getEmail();
		String password = user.getPassword();
		
		// Get user data from database w/ given email - return to login/notify of error if email not found
		user = userService.getUserFromEmail(email);
		
		if(user == null) {
			RedirectView redirView = new RedirectView();
			redirView.setContextRelative(true);
			redirView.setUrl("/");
			return redirView;
		}
		
		System.out.println("USER RETRIEVED: " + user.toString());
		
		//TODO - decrypt password of user (?)
		
		//TODO - compare submitted user password to password retrieved from database
		//if password is correct - redirect to appropriate user or admin page
		
		/*
		//TEMPORARY - setting user admin permission and ID for UI testing
		user.setAdmin(true);
		user.setId(1);
		model.addAttribute("user", user); */
		
		//check password
		if(user.getEmail().equalsIgnoreCase(email) && user.getPassword().equals(password)) {
			//correct login information
			//model.addAttribute("user", user);
			RedirectView redirView = new RedirectView();
			redirView.setContextRelative(true);
			redirectAttrs.addFlashAttribute("user", user);
			if(user.isAdmin()) {
				//admin user
				redirView.setUrl("/users");
				return redirView;
			} else {
				//regular user
				redirView.setUrl("/donate");
				return redirView;
			}
		} else {
			//incorrect login information, return to login
			RedirectView redirView = new RedirectView();
			redirView.setUrl("/");
			return redirView;
		}
	}
	
	//Admin module - user management screen
	@RequestMapping("/users")
	public String userManagement(@ModelAttribute("user")User user, Model model) {
		
		//get list of users from database
		List <User> users = userService.returnUsers();
		
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
		userService.addUser(user);
		
		//return to users page
		return "redirect:/users";
	}
	
	//Admin module - edit user screen
	@RequestMapping("/edit_user/{id}")
	public String editUser(Model model, @PathVariable(name="id") int id) {
		
		//get user by ID from database
		User usr = userService.getUserFromId(id);
		
		//add user to model as attribute 'user' so their data can be pre-loaded into the fields
		model.addAttribute("user", usr);
		
		return "edit_user";
	}
	
	//Admin module - update user data upon edit user form submission
	@RequestMapping(value="/update_user", method = RequestMethod.POST)
	public String updateUser(@ModelAttribute("user") User user) {
		// update user entry in database
		userService.addUser(user);
		
		//return to users page
		return "redirect:/users";
	}
	
	//Admin module - delete user
	@RequestMapping("/delete_user/{id}")
	public String deleteUser(Model model, @PathVariable(name="id")int id) {
		
		// get user by ID from database
		User usr = userService.getUserFromId(id);
		
		//add user to model as attribute 'user' so their data can be displayed on confirmation screen
		model.addAttribute("user", usr);
		
		return "delete_user";
	}
	
	//Admin module - delete user entity from database
	@RequestMapping("/del_user")
	public String removeUser(@ModelAttribute("user") User user) {
		
		//delete user from database
		userService.deleteUser(user);
		
		//return to users page
		return "redirect:/users";
	}
	
	
	//Admin module - events page
	@RequestMapping("/events")
	public String eventManagement(Model model) {
		// get list of events from database
		List <Event> events = eventService.returnEvents();
		
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
		//insert event into event table of database
		eventService.addEvent(event);
		//return to users page
		return "redirect:/events";
	}
	
	//Admin module - edit event page
	@RequestMapping("/edit_event/{id}")
	public String editEvent(Model model, @PathVariable(name="id") int id) {
		
		//get event by ID from database
		Event event = eventService.getEventById(id);
		
		//add event to model as attribute 'event' so the data can be pre-loaded into the fields
		model.addAttribute("event", event);
		
		return "edit_event";
	}
	
	//Admin module - update event in DB
	@RequestMapping(value="/update_event", method = RequestMethod.POST)
	public String updateUser(@ModelAttribute("event") Event event) {
		// update event entry in database
		eventService.addEvent(event);
		
		//return to events page
		return "redirect:/events";
	}
	
	//Admin module - delete event page
	@RequestMapping("/delete_event/{id}")
	public String deleteEvent(@PathVariable(name="id") int id, Model model) {
		//get event by ID from database
		Event event = eventService.getEventById(id);
		
		//add event to model as attribute 'event'
		model.addAttribute("event", event);
		
		return "delete_event";
	}
	
	//Admin module - delete event from DB
	@RequestMapping("/del_event")
	public String removeEvent(@ModelAttribute("event")Event event) {
		//delete event from database
		eventService.deleteEvent(event);
		//return to events page
		return "redirect:/events";
	}
	
	
	//Admin module - donations page
	@RequestMapping("/donations")
	public String donations(Model model) {
		// get list of UserEvents from database
		List <UserEvent> donos = userEventService.getUserEvents();
		
		//add UserEvents to model as attribute 'donos'
		model.addAttribute("donos", donos);
		return "donations";
	}
	
	//User module - Make a donation page
	@RequestMapping("/donate")
	public String donate(Model model, RedirectAttributes redirectAttrs) {
		//get user from model
		User user = (User) model.asMap().get("user");
		
		//get list of events the user can donate to from database
		List <Event> events = eventService.returnEvents();
		
		//add events to model
		model.addAttribute("events", events);
		model.addAttribute(user);
		
		return "donate";
	}
	
	//User module - Enter donation information screen
	@RequestMapping("/new_donation/{id}-{uid}")
	public String new_donation(@PathVariable("uid")int userId, @PathVariable("id")int eventId, Model model) {
		
		// get event by id
		Event event = eventService.getEventById(eventId);
		//get user by id
		User user = userService.getUserFromId(userId);
		
		//create new UserEvent
		UserEvent dono = new UserEvent();
		//set user and event fields of UserEvent
		dono.setUser(user);
		dono.setEvent(event);
		
		
		
		//add UserEvent to model
		model.addAttribute("dono", dono);
	
		return "new_donation";
	}
	
	//User module - shopping cart/checkout screen
	@RequestMapping("/checkout")
	public String checkout(@ModelAttribute("dono") UserEvent dono, Model model) {
		
		//get user
		User user = dono.getUser();
		//get event
		Event event = dono.getEvent();
		
		//update user events list with dono
		List <UserEvent> usrEvents = user.getUserEvents();
		if(usrEvents == null) {
			usrEvents = new ArrayList<UserEvent>();
		}
		usrEvents.add(dono);
		user.setUserEvents(usrEvents);
		
		//update event's userEvent list with dono
		List<UserEvent> events = event.getUserEvents();
		if(events == null) {
			events = new ArrayList<UserEvent>();
		}
		events.add(dono);
		event.setUserEvents(events);
		//update user to save donation
		userService.addUser(user);
		
		//add user and dono to model
		model.addAttribute("dono", dono);
		model.addAttribute("user", user);

		
		return "checkout";
	}
	
	//User module - confirm donation
	@RequestMapping("/add_dono/{id}")
	public RedirectView add_donation(@PathVariable("id")int userId, RedirectAttributes redirectAttrs) {
		
		//get user by id
		User user = userService.getUserFromId(userId);
		
		RedirectView redirView = new RedirectView();
		redirectAttrs.addFlashAttribute("user", user);
		
		//set to return to donation page
		redirView.setContextRelative(true);
		redirView.setUrl("/donate");
		
		//return to donate page
		return redirView;
	}
	
	@RequestMapping("/cancel_dono/{id}/{uid}")
	public RedirectView cancel_donation(@PathVariable("id")int donoId, @PathVariable("uid")int userId, RedirectAttributes redirectAttrs) {
	
		//delete dono from database
		UserEvent event = userEventService.getUserEvent(donoId);
		userEventService.deleteUserEvent(event);
	
		//get user by id
		User user = userService.getUserFromId(userId);
		
		RedirectView redirView = new RedirectView();
		redirectAttrs.addFlashAttribute("user", user);
		
		//set to return to donation page
		redirView.setContextRelative(true);
		redirView.setUrl("/donate");
		
		//return to donate page
		return redirView;
	}
}
