package com.booking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booking.model.Flights;

public interface FlightRepository extends JpaRepository<Flights, Integer> {
	public List<Flights> findByToAndFrom(String to,String From);
}
