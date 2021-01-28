package com.ngo.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Event {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String eventName;
	@OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
	List <UserEvent> userEvents;

	public Event() {}

	public Event(String eventName) {
		this.eventName = eventName;
	}
	
	
	
}
