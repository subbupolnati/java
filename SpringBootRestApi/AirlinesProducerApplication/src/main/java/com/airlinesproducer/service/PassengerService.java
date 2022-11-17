package com.airlinesproducer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airlinesproducer.exceptions.PassengerNotFoundException;
import com.airlinesproducer.model.Passenger;
import com.airlinesproducer.repository.PassengerRepository;

@Service
public class PassengerService {

	@Autowired
	PassengerRepository passengerRepository;//injecting passengerRepostiory dependency
	
	
	public PassengerService() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PassengerService(PassengerRepository passengerRepository) {
		super();
		this.passengerRepository = passengerRepository;
	}
	//This method is used to insert new passenger
	public Passenger insertNewPassenger(Passenger passenger) {
		return passengerRepository.save(passenger);
	}
	//This method is used to getting All passenger List
	public List<Passenger> getAllPassenger(){
		return passengerRepository.findAll();
	}
	//This method is used to getting passenger using by id
	public Passenger getPassengerById(int passenger_id) {
		Optional<Passenger> optional=passengerRepository.findById(passenger_id);
		Passenger passenger=null;
		if(optional.isPresent()) {
			passenger=optional.get();
			return passenger;
		}else
			throw new PassengerNotFoundException("Passenger not found given id"+passenger_id);
	}
	//This method is used to update passenger list using by passengerId
	public Passenger updatePassengerById(Passenger passenger,int passenger_id) {
		Optional<Passenger> optional=passengerRepository.findById(passenger_id);
		if(optional.isPresent()) {
			passenger.setPassenger_id(passenger_id);
			return passengerRepository.save(passenger);
		}else
			throw new PassengerNotFoundException("Passenger not found given id"+passenger_id);
	}
	//This method is used to delete passenger byId
	public void deletePassengerById(int passenger_id) {
		try {
			passengerRepository.deleteById(passenger_id);
		}
		catch(Exception e) {
			throw new PassengerNotFoundException("Passenger not found given id"+passenger_id);
		}
	}
}
