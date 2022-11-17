package com.employee.service;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.employee.model.Employee;
import com.employee.model.JwtResponse;
import com.employee.model.User;

@Service
public class UserService {
	RestTemplate template;

	public UserService(RestTemplate template) {
		super();
		this.template = template;
	}
	
	public ResponseEntity<User>addNewUser(User user) throws URISyntaxException{
		URI uri=new URI("http://localhost:8080/userregister");
		HttpEntity<User> entity=new HttpEntity<User>(user,null);
		ResponseEntity<User> response=template.exchange(uri,HttpMethod.POST,entity,User.class);
		return response;
	}
	
	public ResponseEntity<?> login(User user){
		String loginurl="http://localhost:8080/login";
		HttpHeaders headers = new HttpHeaders();
		HttpEntity request=new HttpEntity(headers);
		ResponseEntity<JwtResponse>authenticationResponse = template.exchange(loginurl,HttpMethod.POST, request, JwtResponse.class);
		return authenticationResponse;
		
	}
}
