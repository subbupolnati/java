package com.event.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.event.model.Venue;
import com.event.repository.VenueRepo;

@Service
public class VenueService {

	@Autowired
	VenueRepo venueRepo;
	
	public Venue addVenue(Venue venue) {
		return venueRepo.save(venue);
	}
	public List<Venue> getAllVenues(){
		return venueRepo.findAll();
	}
	public Venue updateVenue(int venueid) {
		Optional<Venue> optional=venueRepo.findById(venueid);
		Venue venue=null;
		if(optional.isPresent()) {
			venue=optional.get();
			return venue;
		}
		return venue;
	}
	public void deleteVenue(int venueid) {
		venueRepo.deleteById(venueid);
	}
	public List<Venue> searchVenue(String venueName) {
		 return venueRepo.findByVenueName(venueName);
	}
}
