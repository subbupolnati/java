package com.booking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booking.model.Trains;

public interface TrainRepository extends JpaRepository<Trains, Integer> {

	public List<Trains> findByToAndFrom(String to,String from);
}
