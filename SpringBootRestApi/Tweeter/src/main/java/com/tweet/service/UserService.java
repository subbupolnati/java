package com.tweet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweet.model.User;
import com.tweet.repository.UserRepository;

@Service
//UserService class
public class UserService {

	@Autowired
	private UserRepository userRepository;//Injecting credential Repository dependencies

	
	//insert new Credentilas
	public User insert(User user) {
		return userRepository.save(user);
	}
	//Validate credentials
	public User validate(String username,String password) {
		return userRepository.findByUserName(username);
		}
	public User getUser(String username) {
		return userRepository.findByUserName(username);
	}
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
}
