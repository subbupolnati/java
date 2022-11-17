package com.event.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.event.ExceptionHandling.EventNotFoundException;
import com.event.model.Event;
import com.event.model.User;
import com.event.model.Venue;
import com.event.service.EventService;
import com.event.service.VenueService;

@RestController
public class EventController {

	@Autowired
	EventService eventService;
	
	@PostMapping("/event")
	public Event saveEvent(@RequestBody Event event) {
		//Event e=eventService.findByDate(event.getEndTime());
		//if(e==null) {
			return eventService.bookEvent(event);
		//}
		//return e;	
	}
	@GetMapping("/events")
	public List<Event> getAllEvents(){
			return eventService.getALLEvents();
	}
	@GetMapping("/event/{name}")
	public List<Event> searchEvent(@PathVariable("name")String name) {
		return eventService.searchEventBySearchParticipantName(name);
	}
	@PutMapping("/event/{id}")
	public Event updateEvent(@RequestBody Event event,@PathVariable("id")int id,Model m) {
		return eventService.updateEvent(id);
	}
	@DeleteMapping("/event/{id}")
	public void deleteEvent(@PathVariable("id") int id,Model m) {
		eventService.deleteEvent(id);
	}
}
