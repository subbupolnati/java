package com.booking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.booking.model.Buses;
import com.booking.repository.BusRepository;

@Service
public class BusService {

	@Autowired
	BusRepository busRepository;
	
	public Buses insertBus(Buses bus)
	{
		return busRepository.save(bus);
	}
	public Buses update(int busId) {
		Optional<Buses> optional = busRepository.findById(busId);
        Buses bus= null;
        if (optional.isPresent())
            bus = optional.get();
        else
            throw new RuntimeException(
                "Food not found for id : " + busId);
        return bus;
	}
	public void delete(int busId) {
		busRepository.deleteById(busId);
	}
	public List<Buses> getBus(){
		List<Buses> b=busRepository.findAll();
		return b;
	}
	
	public List<Buses> searchBuses(String to,String from){
		return busRepository.findByToAndFrom(to, from);
	}
	/*
	 * public List<Bus>search(String busName){ return
	 * busRepository.findByBusName(busName); }
	 */
}