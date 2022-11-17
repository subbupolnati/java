package com.onlineshoppingcart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineshoppingcart.model.User;
import com.onlineshoppingcart.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	public User insertUser(User user) {
		return userRepo.save(user);
	}
	public User getUser(String userid) {
		return userRepo.findById(userid).get();
	}
	public User validate(String userid, String password, String role) {
	
		return userRepo.findByUseridAndPasswordAndRole(userid, password, role);
	}
}
