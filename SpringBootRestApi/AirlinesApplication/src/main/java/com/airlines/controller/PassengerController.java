package com.airlines.controller;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;

import com.airlines.model.Airlines;
import com.airlines.model.Passenger;
import com.airlines.service.AirlinesService;
import com.airlines.service.PassengerService;

@Controller
public class PassengerController {

	@Autowired
	PassengerService passengerService;
	@Autowired
	AirlinesService airlineService;
	@RequestMapping("/passenger")
	public String addNewPassenger(Model m) {
		//Passenger passenger=new Passenger();
		List<Airlines> airline=airlineService.showAllAirlines();
		m.addAttribute("airlineList", airline);
		m.addAttribute("passenger", new Passenger());
		m.addAttribute("message", "Passenger Succesfully added");
		return "registerPassenger";
	}
	/*@RequestMapping("/savePassenger")
	public String addNewPassenger(@RequestParam("passenger_id") String passenger_id,@RequestParam("name") String name,
			@RequestParam("trips") String trips,@RequestParam("airline") String id,Model m) throws URISyntaxException {
		Airlines airline=airlineService.getAirlinesById(id);
		//System.out.println(""+airline);
		Passenger passenger=new Passenger();
		passenger.setPassenger_id(passenger_id);
		passenger.setName(name);
		passenger.setTrips(trips);
		passenger.setAirline(airline);
		//System.out.println("pas"+passenger);
		ResponseEntity<Passenger> p=passengerService.addNewPassengers(passenger);
		m.addAttribute("msg", "successfully added");
		return "redirect:/";
	}*/
	@RequestMapping("/savePassenger")
	public String addNewPassenger(@ModelAttribute Passenger passenger,Model m) throws URISyntaxException {
		ResponseEntity<Passenger> p=passengerService.addNewPassengers(passenger);
		return "redirect:passengerList";
	}
	@RequestMapping(path="/passengerList",method=RequestMethod.GET)
	public String getPassengerList(Model m) {
		List<Passenger> passenger=passengerService.showAllPassengers();
		m.addAttribute("passenger",passenger);
		return "viewPassenger.html";
	}
	@RequestMapping(path="/searchPassenger",method=RequestMethod.POST)
	public String search(@RequestParam("id") int id,Model m) {
		try{
			Passenger passenger=passengerService.getPassengerById(id);
			m.addAttribute("passenger", passenger);
		}catch(HttpClientErrorException e) {
			m.addAttribute("message", "Passenger Not Found With Id: "+id);
		}
		return "viewPassenger.html";
	}
	@RequestMapping(path="/updatePassenger/{id}")
	public String updatePassenger(@PathVariable("id")int id,Model m) {
		Passenger passenger=passengerService.getPassengerById(id);
		List<Airlines> airline=airlineService.showAllAirlines();
		m.addAttribute("airlineList", airline);
		m.addAttribute("passenger", passenger);
		return "updatePassenger.html";
	}
	@RequestMapping(path="/deletePassenger/{id}")
	public String deletePassenger(@PathVariable("id")int id,Model m) throws URISyntaxException {
		ResponseEntity<Passenger> response=passengerService.DeletePassengerById(id);
		return "redirect:passengerList";
	}
	/*
	 * @GetMapping("/passenger") public ResponseEntity<TotalPassengers[]>
	 * getAllPassengers(){ return passengerService.showAllPassengers(); }
	 * 
	 * @GetMapping("/passenger/{id}") public ResponseEntity<Passenger>
	 * getPassengerById(@PathVariable("id")String passenger_id){ return
	 * passengerService.getPassengerById(passenger_id); }
	 * 
	 * @PostMapping("/passenger") public ResponseEntity<Passenger>
	 * createNewPassenger(@RequestBody Passenger passenger) throws
	 * URISyntaxException{ return passengerService.addNewPassengers(passenger); }
	 * 
	 * @PutMapping("/passenger/{id}") public ResponseEntity<Passenger>
	 * updatePassenger(@RequestBody Passenger passenger,@PathVariable("id") String
	 * id){ return passengerService.updatePassengerById(id, passenger); }
	 * 
	 * @DeleteMapping("/passenger/{id}") public
	 * ResponseEntity<Passenger>DeletePassenger(@PathVariable("id") String id)
	 * throws URISyntaxException{ return passengerService.DeletePassengerById(id); }
	 */
}
