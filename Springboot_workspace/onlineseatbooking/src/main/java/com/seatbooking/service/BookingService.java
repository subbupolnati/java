package com.seatbooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seatbooking.model.Theater;
import com.seatbooking.repo.BookingRepository;

@Service
public class BookingService {

	@Autowired
	private BookingRepository br;

	public BookingRepository getBr() {
		return br;
	}

	public void setBr(BookingRepository br) {
		this.br = br;
	}
	public void insertTheater(Theater theater) {
		br.save(theater);
	}
	public List<Theater> viewAll(){
		return(List<Theater>)br.findAll();
	}
}
