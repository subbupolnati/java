package com.seatbooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seatbooking.model.User;
import com.seatbooking.repo.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository ur;

	public UserRepository getUr() {
		return ur;
	}

	public void setUr(UserRepository ur) {
		this.ur = ur;
	}
	public void insertUser(User user) {
		ur.save(user);
		
	}
}
