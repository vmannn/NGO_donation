package com.ngo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ngo.entities.Event;
import com.ngo.repos.EventRepo;

@Service
public class EventService {
	
	@Autowired
	EventRepo eventRepo;

	//Function to add/update event
    @Transactional
	public int addEvent(Event event) {
		
		eventRepo.save(event);
		
		//used for testing 
		return eventRepo.findAll().size();
		
	}
    
    
    //function to return events
    @Transactional
    public ArrayList<Event> returnEvents(){
    	
    	return (ArrayList<Event>) eventRepo.findAll();
    	
    }
   
    //get event by id
    @Transactional
    public Event getEventById(int id) {
    	
    	return eventRepo.getEventFromId(id);	
    }
    
    //deletes an event
    @Transactional
    public void deleteEvent(Event event) {
    	
    	eventRepo.delete(event);
    	
    }
    
	
}
