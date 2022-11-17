package com.employee.controller;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.employee.model.Department;
import com.employee.model.User;
import com.employee.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/userRegister")
	public ResponseEntity<User>addNewUser(@RequestBody User user) throws URISyntaxException{
		
		return userService.addNewUser(user);
	}
	
}
