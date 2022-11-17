package com.booking.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.booking.model.Flights;
import com.booking.repository.FlightRepository;



@Service
public class FlightService {

	@Autowired
	private FlightRepository flightRepository;

	public FlightRepository getFlightRepository() {
		return flightRepository;
	}

	public void setFlightRepository(FlightRepository flightRepository) {
		this.flightRepository = flightRepository;
	}
	public Flights insertFlight(Flights flight)
	{
		return flightRepository.save(flight);
	}
	public Flights updateFlight(int flightId) {
		Optional<Flights> optional = flightRepository.findById(flightId);
		Flights flight= null;
        if (optional.isPresent())
            flight = optional.get();
        else
            throw new RuntimeException(
                "flight not found for id : " + flightId);
        return flight;
	}
	public void deleteFlight(int flightId) {
		flightRepository.deleteById(flightId);
	}
	public List<Flights> getflight(){
		List<Flights> b=flightRepository.findAll();
		return b;
	}
	
	public List<Flights> searchFlight(String to,String from){
		return flightRepository.findByToAndFrom(to, from);
	}
}
