package com.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.user.model.User;
import com.user.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public User insertUsers(User user) {
		return userRepository.save(user);
	}
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	public User getUser(int userId) {
		Optional<User> optional=userRepository.findById(userId);
		User user=null;
		if(optional.isPresent()) {
			user=optional.get();
		}
		return user;
	}
	public User updateUser(User user,int userId) {
		Optional<User> optional=userRepository.findById(userId);
		if(optional.isPresent()) {
			user.setUserId(userId);;
		}
		return userRepository.save(user);
	}
	public void deleteUser(int userId) {
		userRepository.deleteById(userId);
	}
	public User getUserById(int userId) {
		return userRepository.findById(userId).get();
	}
}
