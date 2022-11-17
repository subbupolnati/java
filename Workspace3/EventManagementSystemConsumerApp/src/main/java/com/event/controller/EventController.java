package com.event.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.event.ExceptionHandling.EventNotFoundException;
import com.event.model.Event;
import com.event.model.Venue;
import com.event.service.EventService;
import com.event.service.VenueService;

@Controller
public class EventController {

	@Autowired
	EventService eventService;
	@Autowired
	VenueService venueService;
	@RequestMapping("/home")
	public String home() {
		return "home";
	}
	@RequestMapping("/addEvent")
	public String addEvent(Model m) {
		m.addAttribute("event",new Event());
		List<Venue> venueList=venueService.getAllVenues();
		m.addAttribute("venueList",venueList);
		return "eventRegister";
	}
	@PostMapping("/saveEvent")
	public String saveEvent(@ModelAttribute("event") Event event,Model m) {
			eventService.addEvent(event);
			m.addAttribute("msg", "Adding successfully");
			return "eventRegister";
	}	
	@RequestMapping("/viewEvents")
	public String getAllEvents(Model m){
		try {
			List<Event> eventList=eventService.getAllEvents();
			if(eventList.isEmpty())
				throw new EventNotFoundException("No data Found");
			m.addAttribute("eventList",eventList);
			}
		catch(EventNotFoundException e) {
			m.addAttribute("message", e.getMessage());
		}
		return "viewEvent";
	}
	@RequestMapping("/searchEvent")
	public String searchEvent(@RequestParam("name")String name,Model m) {
		try {
		List<Event> eventList=eventService.searchEventBySearchParticipantName(name);
		if(eventList.isEmpty()) {
			throw new EventNotFoundException("No data Found");
		}
		m.addAttribute("eventList",eventList);
		}
		catch(EventNotFoundException e) {
			m.addAttribute("message", e.getMessage());
		}
		return "viewEvent";
	}
	@RequestMapping("/updateEvent/{id}")
	public String updateEvent(@PathVariable("id")int id,Model m) {
		m.addAttribute("event",eventService.updateEvent(id));
		List<Venue> venueList=venueService.getAllVenues();
		m.addAttribute("venueList",venueList);
		m.addAttribute("msg", "updated successfully");
		return "EventRegister";
	}
	@RequestMapping("/deleteEvent/{id}")
	public String deleteEvent(@PathVariable("id") int id,Model m) {
		eventService.deleteEvent(id);
		List<Event> eventList=eventService.getAllEvents();
		m.addAttribute("eventList",eventList);
		return "viewEvent";
	}
}
