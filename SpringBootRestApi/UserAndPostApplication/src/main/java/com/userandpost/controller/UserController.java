package com.userandpost.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.userandpost.model.Posts;
import com.userandpost.model.Response;
import com.userandpost.model.Users;
import com.userandpost.service.UsersService;
//This class Perform Controller
@RestController
public class UserController {
	
	@Autowired
	private UsersService userService;//Injecting the UserService dependency 
	//This Url insert and getting userList
	@GetMapping("/users")
	public Users[] usersList(){
		return userService.insertUsers();
	}
	//This Url insert and getting post details
	@GetMapping("/posts")
	public List<Posts> postList(){
		return userService.insertPosts();
	}
	//This Url getting the userdetails by company name
	@GetMapping("/users/{companyName}")
	public List<Users> getUserByCompanyName(@PathVariable("companyName")String comapanyname){
		return userService.getUsersByPosts(comapanyname);
	}
	//This url getting the userdatails with post count
	@GetMapping("/users/postcount")
	public List<Response> getResponse(){
		return userService.getPostCount();
	}
}
