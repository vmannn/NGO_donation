package com.ngo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ngo.entities.UserEvent;

public interface UserEventRepo extends JpaRepository<UserEvent, Integer> {
	

}
