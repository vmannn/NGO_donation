package com.ngo.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngo.entities.UserEvent;
import com.ngo.repos.UserEventRepo;

@Service
public class UserEventService {

	
	
	@Autowired
	UserEventRepo userEventRepo;
	
	//returns all user events
	public ArrayList<UserEvent> getUserEvents(){
		
		
		return (ArrayList<UserEvent>) userEventRepo.findAll();
		
		
	}
	
	public void addUserEvent(UserEvent userEvent) {
		
		userEventRepo.save(userEvent);
		
		
	}
	
	
	
}
