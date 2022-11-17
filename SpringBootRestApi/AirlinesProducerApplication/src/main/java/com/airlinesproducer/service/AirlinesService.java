package com.airlinesproducer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airlinesproducer.exceptions.AirlineNotFoundException;
import com.airlinesproducer.model.Airlines;
import com.airlinesproducer.model.Passenger;
import com.airlinesproducer.repository.AirlinesRepository;

@Service
public class AirlinesService {

	@Autowired
	AirlinesRepository airlinesRepository;//injecting airlinesRepostiory dependency
	
	//This method insert the airlines details
	public Airlines insertNewAirlines(Airlines airline)
	{
		return airlinesRepository.save(airline);
	}
	//This method List Airlines details
	public List<Airlines> getAllAirlines(){
		return airlinesRepository.findAll();
	}
	//This method get Airline details using Id
	public Airlines getAirlineById(int id) {
		Optional<Airlines> optional=airlinesRepository.findById(id);
		Airlines airline=null;
		if(optional.isPresent()) {
			airline=optional.get();
			return airline;
		}
		else
			throw new AirlineNotFoundException("airlines is not found by id "+id);
	}
	//This method update Airline details using Id
	public Airlines updateAirlineById(Airlines airline,int id) {
		Optional<Airlines> optional=airlinesRepository.findById(id);
		if(optional.isPresent()) {
			airline.setId(id);
			return airlinesRepository.save(airline);
		}else {
			throw new AirlineNotFoundException("airlines is not found by id "+id);
		}
	}
	//This method delete Airlines details By Id
	public void deleteAirlineById(int id) {
		try {
			airlinesRepository.deleteById(id);
		}
		catch(Exception e){
			throw new AirlineNotFoundException("airlines is not found by id "+id);
		}
	}
	public List<Passenger>getPassengerByAirlineId(int id){
		Optional<Airlines> optional=airlinesRepository.findById(id);
		if(!optional.isPresent()) {
			throw new AirlineNotFoundException("Airline Not found "+id);
		}
		return optional.get().getPassenger();
	}
}
