package com.ngo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class UserEvent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int userEventId;
	double donationAmount;
	boolean monthly;
	@ManyToOne
	@JoinColumn(name = "userId")
	User user;
	@ManyToOne
	@JoinColumn(name = "eventId")
	Event event;
	
	public UserEvent() {}

}
