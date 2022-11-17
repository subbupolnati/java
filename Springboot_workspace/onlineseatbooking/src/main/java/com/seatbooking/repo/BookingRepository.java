package com.seatbooking.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.seatbooking.model.Theater;



@Repository
public interface BookingRepository extends CrudRepository<Theater,Integer>{

}
