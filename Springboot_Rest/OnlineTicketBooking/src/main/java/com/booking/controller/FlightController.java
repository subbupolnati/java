package com.booking.controller;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.booking.model.Flights;
import com.booking.model.Trains;
import com.booking.service.FlightService;
@Controller
public class FlightController {

	@Autowired
	FlightService flightService;
	@RequestMapping("/flightpage")
	public String trainpage(Model m){
		Flights flight=new Flights();
		m.addAttribute("flight",flight);
		return "flightBooking";
	}
	@RequestMapping("/addFlight")
	public String addNewFlight(Model m) {
		Flights flight=new Flights();
		m.addAttribute("flight", flight);
		return "flightRegister";
	}
	@RequestMapping("/saveFlight")
	public String inserFlight(@ModelAttribute("flight") Flights flight) throws IOException {
        Flights f= flightService.insertFlight(flight);
		return "redirect:flighthome";
	}
	@RequestMapping("/flighthome")
	public String flightHome(Model m) {
		List<Flights> flight=flightService.getflight();
		m.addAttribute("flight",flight);
		return "viewAllFlights";
	}
	@RequestMapping("/updateflight/{flightId}")
	public String updateFlight(@PathVariable(value = "flightId")int flightId, Model m) {
		Flights f=flightService.updateFlight(flightId);
        m.addAttribute("flight", f);
        return "updateFlight";
    }
	
	@RequestMapping("/deleteflight/{flightId}")
	public String deleteFlight(@PathVariable(value="flightId")int flightId)
	{
		flightService.deleteFlight(flightId);
		return "redirect:flighthome";
	}
	@RequestMapping("/flight/booking")
	public String bookingFlight(@ModelAttribute("flight") Flights flight,Model m) {
		List<Flights> f=flightService.searchFlight(flight.getTo(),flight.getFrom());
		m.addAttribute("flight",f);
		return "viewFlights.html";
	}
	
	@RequestMapping("/viewflights")
	public String viewAll() {
		List<Flights> flight=flightService.getflight();
		return "viewFlights";
	}
}
