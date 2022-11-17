package com.booking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.model.User;
import com.booking.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public User addNewUser(User user) {
		return userRepository.save(user);
	}
	public User validate(String username, String password, String usertype) {
		User u=userRepository.findByUsernameAndPasswordAndUsertype(username, password, usertype);
		return u;
	}
}
