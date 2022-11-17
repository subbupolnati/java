package com.event.controller;

import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.event.model.User;
import com.event.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@PostMapping("/user")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));
		User u=userService.addUser(user);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{username}").buildAndExpand(u.getUsername()).toUri();
		return ResponseEntity.created(location).build();
	}
	@GetMapping("/user/{username}")
	public User getUserById(@PathVariable("username") String username) {
		return userService.validate(username);
	}
}
