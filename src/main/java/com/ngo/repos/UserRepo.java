package com.ngo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ngo.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	
	
	
}
