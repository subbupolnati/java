package com.bloodbank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bloodbank.model.User;
import com.bloodbank.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User addUser(User user) {
		return userRepository.save(user);
	}
	public List<User> searchUser(int user_id) {
		return userRepository.findByUserid(user_id);
	}
	public void deleteUser(int user_id) {
		userRepository.deleteById(user_id);
	}
	public List<User> getAllUser(){
		return userRepository.findAll();
	}
	public User updateUser(int user_id) {
		Optional<User> optional=userRepository.findById(user_id);
		User user=null;
		if(optional.isPresent()) {
			user=optional.get();
			return user;
		}
		return user;
	}
}
