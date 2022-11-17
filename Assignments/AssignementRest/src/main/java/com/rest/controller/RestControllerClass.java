package com.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.model.Posts;
import com.rest.model.Response;
import com.rest.service.RestService;

@RestController
public class RestControllerClass {

	@Autowired
	private RestService rest;
	
	
	/*
	 * @GetMapping("/users") public List<User> getAllUsers(){ return
	 * rest.getAllUsers(); }
	 */
	
	@GetMapping("/response")
	public List<Response> getresponse(){
		return rest.getResponse();
	}
	
	@GetMapping("/post")
	public List<Posts> getAllPosts(){
		return rest.getAllPosts();
	}
}

