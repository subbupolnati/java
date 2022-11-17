package com.event.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.event.ExceptionHandling.VenueNotFoundException;
import com.event.model.Venue;
import com.event.service.VenueService;

@RestController
public class VenueController {

	@Autowired
	VenueService venueService;
	
	@PostMapping("/venue")
	public Venue saveVenue(@RequestBody Venue venue) {
		return venueService.addVenue(venue);
	}
	@GetMapping("/venues")
	public List<Venue> getAllVenue(Model m){
		return venueService.getAllVenues();
	}
	@GetMapping("/venue/{name}")
	public List<Venue>searchVenue(@PathVariable("name")String name) {
		return venueService.searchVenue(name);
	}
	@PutMapping("/venue/{id}")
	public Venue updateVenue(@RequestBody Venue venue,@PathVariable("id")int id) {
		return venueService.updateVenue(id);
	}
	@DeleteMapping("/venue/{id}")
	public void deleteVenue(@PathVariable("id") int id,Model m) {
		venueService.deleteVenue(id);
	}
}
