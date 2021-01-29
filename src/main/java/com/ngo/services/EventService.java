package com.ngo.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ngo.entities.Event;
import com.ngo.repos.EventRepo;

@Service
public class EventService {
	
	@Autowired
	EventRepo eventRepo;

	//Function to add an event
    @Transactional
	public int addEvent(String eventName) {
		
		Event event = new Event(eventName);
		eventRepo.save(event);
		
		//used for testing 
		return eventRepo.findAll().size();
		
	}
    
    @Transactional
    public ArrayList<Event> returnEvents(){
    	
    	return (ArrayList<Event>) eventRepo.findAll();
    	
    }
	
}
