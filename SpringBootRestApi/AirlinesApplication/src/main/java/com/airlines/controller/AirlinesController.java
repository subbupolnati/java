package com.airlines.controller;

import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.airlines.model.Airlines;
import com.airlines.model.Passenger;
import com.airlines.service.AirlinesService;
import com.airlines.service.PassengerService;

@Controller
public class AirlinesController {

	@Autowired
	AirlinesService airlinesService;//injecting the airlines service dependency
	
	@Autowired
	PassengerService passengerService;
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	@RequestMapping("/airline")
	public String airline(Model m) {
		Airlines airline=new Airlines(); 
		m.addAttribute("airline", airline);
		m.addAttribute("message", "Airline Succesfully added");
		return "registerAirline";
	}
	@RequestMapping("/saveAirline")
	public String addAirline(@ModelAttribute("airline") Airlines airline,Model m) throws URISyntaxException {
		ResponseEntity<Airlines> a=airlinesService.addNewAirlines(airline);
		return "redirect:airline";
	}
	@RequestMapping(path="/airlineList",method=RequestMethod.GET)
	public String getAirlineList(Model m) {
		List<Airlines> airline=airlinesService.showAllAirlines();
		m.addAttribute("airline",airline);
		return "viewAirlines.html";
	}
	@RequestMapping(path="/search",method=RequestMethod.POST)
	public String search(@RequestParam("id") int id,Model m) {
		try{
			Airlines airline=airlinesService.getAirlinesById(id);
			m.addAttribute("airline", airline);
		}catch(HttpClientErrorException e) {
			m.addAttribute("message", "Airline Not Found With Id: "+id);
		}
		
		return "viewAirlines.html";
	}
	@RequestMapping("/passengerByAirline")
	public String passegerlistAirlinewise(){
		return "passengerList";
	}
	@RequestMapping(path="/passengerListByAirlineId",method =RequestMethod.POST)
	public String passengerListByAirlineId(@RequestParam("id")int id,Model m) {
		//List<Passenger> passenger=airlinesService.getPassengerListByAirlineId(id);
		try{
			m.addAttribute("passenger", airlinesService.getPassengerListByAirlineId(id));
		}catch(HttpClientErrorException e) {
			m.addAttribute("message", "Airline Not Found With Id: "+id);
		}
		return "passengerList";
	}
	/*
	 * @RequestMapping(path="/deleteAirline",method=RequestMethod.DELETE) public
	 * String deleteAirline(){
	 * 
	 * }
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * //add new AirLines
	 * 
	 * @PostMapping("/Airlines") public ResponseEntity<Airlines>
	 * createNewAirlines(@RequestBody Airlines airlines) throws URISyntaxException{
	 * return airlinesService.addNewAirlines(airlines); } //get All Airlines
	 * 
	 * @GetMapping("/Airlines") public ResponseEntity<Airlines[]> getAllAirlines(){
	 * return airlinesService.showAllAirlines(); } //Getting particular airlines
	 * details based on airline id
	 * 
	 * @GetMapping("/Airlines/{id}") public ResponseEntity<Airlines>
	 * getAirlinesByID(@PathVariable("id") String id){ return
	 * airlinesService.getAirlinesById(id); }
	 */
}
