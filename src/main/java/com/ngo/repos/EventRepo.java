package com.ngo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ngo.entities.Event;

public interface EventRepo extends JpaRepository<Event, Integer> {

	@Query("from Event where id = :id")
	Event getEventFromId(@Param("id") int id);
	
	
}
