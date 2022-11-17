package com.event.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.event.model.Venue;

@Repository
public interface VenueRepo extends JpaRepository<Venue, Integer>{
	public List<Venue> findByVenueName(String venueName);
}
