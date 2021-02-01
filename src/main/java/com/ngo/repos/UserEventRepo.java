package com.ngo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ngo.entities.User;
import com.ngo.entities.UserEvent;

public interface UserEventRepo extends JpaRepository<UserEvent, Integer> {
	
	@Query("from UserEvent where id = :id")
	UserEvent getUserEventFromId(@Param("id") int id);

}
