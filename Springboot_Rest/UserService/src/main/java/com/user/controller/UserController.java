package com.user.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.user.model.Posts;
import com.user.model.Response;
import com.user.model.User;
import com.user.service.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	RestTemplate template;
	private final static String USERCIRCUITBREAKER="UserService";
	@GetMapping("/user")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	@PostMapping("/user")
	public User insertUser(@RequestBody User user) {
		return userService.insertUsers(user);
	}
	@GetMapping("/user/{userId}")
	public User getPost(@PathVariable("userId") int userId) {
		return userService.getUser(userId);
	}
	@PutMapping("/user/{userId}")
	public User updateUser(@RequestBody User user,@PathVariable("userId") int userId) {
		return userService.updateUser(user, userId);
	}
	@DeleteMapping("/user/{userId}")
	public void deleteUser(@PathVariable("userId") int userId) {
		userService.deleteUser(userId);
	}
	@GetMapping("/user/{userId}/post")
	@CircuitBreaker(name=USERCIRCUITBREAKER,fallbackMethod = "showDefaultUser")
	public Response getUserByDeptId(@PathVariable("userId") int userId)
	{
	String uri="http://localhost:9001/post/user/"+userId;
	User u=userService.getUserById(userId);
	ResponseEntity<Posts[]> entity=template.getForEntity(uri, Posts[].class);
	Posts[] p=entity.getBody();
	Response r=new Response();
	r.setUser(u);
	r.setPost(Arrays.asList(p));
	return r;
	}
	public Response showDefaultUser(Exception e)
	{
	Response r=new Response();
	Posts p[]=new Posts[1];
	p[0]=new Posts();
	p[0].setId(0);
	p[0].setTitle("null");
	p[0].setBody("null");;
	p[0].setUserId(0);;
	User u=new User();
	u.setUserId(0);
	u.setName("Not found");
	u.setEmail("null");
	u.setPhone("null");
	r.setPost(Arrays.asList(p));
	r.setUser(u);
	return r;
	}
}
