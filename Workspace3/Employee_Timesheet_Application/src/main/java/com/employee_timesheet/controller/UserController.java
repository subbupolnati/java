package com.employee_timesheet.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.employee_timesheet.model.Users;
import com.employee_timesheet.service.CustomUserDetailService;
//This class acts like User Controller checking urls
@RestController
@RequestMapping("/v1/timesheet")
public class UserController {
	//this Autowired annotations inject CustomUserDetailService dependencies
	@Autowired
	private CustomUserDetailService customUserDetailService;
	//this Autowired annotations inject BCryptPasswordEncoder dependencies using password encrypt
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	//this url and method store user details in database based n restapi data
	@PostMapping("/user")
	public ResponseEntity<Users> saveUser(@RequestBody Users user) {
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));
		Users u=customUserDetailService.insertUser(user);
		//System.out.println(u);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{officialMail}").buildAndExpand(u.getOfficialMail()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	//this url and method getting all user details in database based n restapi data
	@GetMapping("/users")
	public List<Users> getAllUsers() {
		return customUserDetailService.getAllUsers();
	}
	
	//In this url and method getting particular user based on official mail
	@GetMapping("/user/{officialMail}")
	public Users getUserByOfficialMail(@PathVariable("officialMail") String OfficialMail) {
		return customUserDetailService.getuserByOfficialMail(OfficialMail);
	}
	
	//In this url and method update particular user based on userid
	@PutMapping("/user/{userid}")
	public Users updateUserById(@PathVariable("userid")int userId,@RequestBody Users user) {
		return customUserDetailService.updateUser(user, userId);
	}
	
	//In this url and method delete particular user based on userid
	@DeleteMapping("/user/{userid}")
	public void deleteUserById(@PathVariable("userid")int userId,@RequestBody Users user) {
		customUserDetailService.deleteUser(userId);
	}
}
