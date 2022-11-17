package com.inventorymanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventorymanagementsystem.model.User;
import com.inventorymanagementsystem.repository.UserRepo;
@Service
public class UserService {
	@Autowired
	private UserRepo ur;

	public User addUser(User user) {
		return ur.save(user);
	}
	public List<User> getAllUser(){
		return ur.findAll();
	}
	public User editUser(int userid) {
		Optional<User> optional=ur.findById(userid);
		User user=null;
		if(optional.isPresent()) {
			user=optional.get();
			return user;
		}
		return user;
	}
	public void deleteUser(int userid) {
		ur.deleteById(userid);
	}
	public List<User> searchUser(int userid){
		return ur.findByUserid(userid);
	}


}
