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

import com.event.ExceptionHandling.VenueNotFoundException;
import com.event.model.Venue;
import com.event.service.VenueService;

@Controller
public class VenueController {

	@Autowired
	VenueService venueService;
	
	@RequestMapping("/addVenue")
	public String addVenue(Model m) {
		m.addAttribute("venue",new Venue());
		return "venueRegister";
	}
	@PostMapping("/saveVenue")
	public String saveVenue(@ModelAttribute("venue") Venue venue,Model m) {
		venueService.addVenue(venue);
		m.addAttribute("msg", "Adding successfully");
		return "venueRegister";
	}
	@RequestMapping("/viewVenue")
	public String getAllVenue(Model m){
		try{
			List<Venue> venueList=venueService.getAllVenues();
			if(venueList.isEmpty())
				throw new VenueNotFoundException("No data Found ");
			else
				m.addAttribute("venueList", venueList);
		}
		catch(VenueNotFoundException e) {
			m.addAttribute("message",e.getMessage());
		}
		return "viewVenue";
	}
	@RequestMapping("/searchVenue")
	public String searchVenue(@RequestParam("name")String name,Model m) {
		try{
			List<Venue> venueList=venueService.searchVenue(name);
			if(venueList.isEmpty()) {
				throw new VenueNotFoundException("No Data Found");
			}
			m.addAttribute("venueList",venueList);
		}catch(VenueNotFoundException e) {
			m.addAttribute("message",e.getMessage());
		}
		return "viewVenue";
	}
	@RequestMapping("/updateVenue/{id}")
	public String updateVenue(@PathVariable("id")int id,Model m) {
		Venue venue=venueService.updateVenue(id);
		m.addAttribute("venue",venue);
		m.addAttribute("msg", "updated successfully");
		return "venueRegister";
	}
	@RequestMapping("/deleteVenue/{id}")
	public String deleteVenue(@PathVariable("id") int id,Model m) {
		venueService.deleteVenue(id);
		List<Venue> venueList=venueService.getAllVenues();
		m.addAttribute("venueList",venueList);
		return "viewVenue";
	}
}
