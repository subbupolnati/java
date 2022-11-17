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

import com.airlinesproducer.exceptions.PassengerNotFoundException;
import com.airlinesproducer.model.Passenger;
import com.airlinesproducer.service.PassengerService;

@RestController
public class PassengerController {

	@Autowired
	PassengerService passengerService;//injecting airlineService dependency
	
	//This url is used to post passenger details
	@PostMapping("/passenger")
	public ResponseEntity<Passenger>insertNewPassenger(@RequestBody Passenger passenger){
		Passenger p=passengerService.insertNewPassenger(passenger);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{passenger_id}").buildAndExpand(p.getPassenger_id()).toUri();
		return ResponseEntity.created(location).build();
	}
	//This url is used to getting all passenger details
	@GetMapping("/passenger")
	public List<Passenger>getAllPassengers(){
		return passengerService.getAllPassenger();
	}
	//This url is used to getting passenger details by user id
	@GetMapping("/passenger/{id}")
	public Passenger getPassengerById(@PathVariable("id")int id){
			 return passengerService.getPassengerById(id);
	}
	//This url is used to update passenger details using id
	@PutMapping("/passenger/{id}")
	public Passenger updatePassengerById(@RequestBody Passenger passenger,@PathVariable("id")int id) {
		return passengerService.updatePassengerById(passenger, id);
	}
	//This url is used to delete passenger details by user id
	@DeleteMapping("/passenger/{id}")
	public void deletePassengerById(@PathVariable("id")int id) {
		passengerService.deletePassengerById(id);
	}
}
