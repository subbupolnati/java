package com.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.User;
import com.employee.service.CustomUserDetailService;

@RestController
public class UserController {
	
	@Autowired
	private CustomUserDetailService customUserDetailService;
	
	@Autowired
	private BCryptPasswordEncoder bPasswordEncoder;
		
	public CustomUserDetailService getCustomUserDetailService() {
		return customUserDetailService;
	}

	public void setCustomUserDetailService(CustomUserDetailService customUserDetailService) {
		this.customUserDetailService = customUserDetailService;
	}

	public BCryptPasswordEncoder getbPasswordEncoder() {
		return bPasswordEncoder;
	}

	public void setbPasswordEncoder(BCryptPasswordEncoder bPasswordEncoder) {
		this.bPasswordEncoder = bPasswordEncoder;
	}

	@PostMapping("/userregister")
	public User addNewUser(@RequestBody User user) {
		user.setPassword(this.bPasswordEncoder.encode(user.getPassword()));
		return customUserDetailService.insertUser(user);
		}

}
