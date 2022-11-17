package com.inventorymanagementsystem.controller;

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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.inventorymanagementsystem.model.User;
import com.inventorymanagementsystem.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService us;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@PostMapping("/user")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));
		User u=us.addUser(user);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{username}").buildAndExpand(u.getUsername()).toUri();
		return ResponseEntity.created(location).build();
	}
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return us.getAllUser();
	}
	/*@PostMapping("/user/{username}")
	public List<User> searchUser(@PathVariable("username") String username) {
		 return us.searchUser(username);
	}*/
	@PutMapping("/user/{id}")
	public User updateUser(@RequestBody User user,@PathVariable("id")String username) {
		return us.editUser(user,username);
	}
	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable("id") String username) {
		us.deleteUser(username);
	}
	@GetMapping("/user/{username}")
	public User getUserById(@PathVariable("username") String username) {
		return us.validate(username);
	}

}
