package com.booking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.model.Buses;

@Repository
public interface BusRepository extends JpaRepository<Buses,Integer>{
public List<Buses> findByToAndFrom(String to,String from);
}
