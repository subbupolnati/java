package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.User;
import com.example.rep.UserRepository;

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
