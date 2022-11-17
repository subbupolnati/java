package com.airlinesproducer.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.airlinesproducer.exceptions.AirlineNotFoundException;
import com.airlinesproducer.model.Airlines;
import com.airlinesproducer.model.Passenger;
import com.airlinesproducer.service.AirlinesService;

@RestController
public class AirlinesController {

	@Autowired
	AirlinesService airlinesService;//injecting airlineService dependency
	
	//This url is used to post airline details
	@PostMapping("/airlines")
	public ResponseEntity<Airlines>insertNewAirline(@RequestBody Airlines airline){
		Airlines a=airlinesService.insertNewAirlines(airline);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(a.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	//This url is used to getting all airline details
	@GetMapping("/airlines")
	public List<Airlines>getAllAirlines(){
		return airlinesService.getAllAirlines();
	}
	//This url is used to getting airline details by airline id 
	@GetMapping("/airlines/{id}")
	public Airlines getAirlineById(@PathVariable("id")int id){
			 return airlinesService.getAirlineById(id);
	}
	//This url is used to update airline details by using id
	@PutMapping("/airlines/{id}")
	public Airlines updateAirlineById(@RequestBody Airlines airline,@PathVariable("id")int id) {
			return airlinesService.updateAirlineById(airline, id);
	}
	//This url is used to delete airline details
	@DeleteMapping("/airlines/{id}")
	public void deleteAirlineById(@PathVariable("id")int id) {
			airlinesService.deleteAirlineById(id);
	}
	@GetMapping("/airlines/{id}/passenger")
	public List<Passenger> passengerGetByAirlineId(@PathVariable("id") int id) {
		return airlinesService.getPassengerByAirlineId(id);
	}
}