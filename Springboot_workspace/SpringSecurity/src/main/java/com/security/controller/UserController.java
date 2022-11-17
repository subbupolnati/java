package com.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.model.User;
import com.security.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService us;


	@GetMapping("/")
	public String home() {
		return "this is firt security app";
	}
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return us.getAllUsers();
	}
}
