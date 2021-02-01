package com.ngo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ngo.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {


	@Query("from User where email = :email")
	User getUserFromEmail(@Param("email") String email);
	
	
	
}
