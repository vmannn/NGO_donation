package com.ngo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ngo.entities.Event;

public interface EventRepo extends JpaRepository<Event, Integer> {

}
