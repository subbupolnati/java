package com.event.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.event.model.JwtResponse;
import com.event.model.User;


@Service
public class UserService {

	@Autowired
	RestTemplate template;
	
	public UserService(RestTemplate template) {
		super();
		this.template = template;
	}
	private static String token;
	
	public static String getToken() {
		return token;
	}
	public static void setToken(String token) {
		UserService.token = token;
	}
	public ResponseEntity<User> addUser(User user) {
		String url="http://localhost:8080/user";
		HttpEntity<User> entity=new HttpEntity<User>(user,null);
		ResponseEntity<User> response=template.postForEntity(url,entity,User.class);
		return response;
	}
	//Validate credentials
	public User validate(String username) {
		String url="http://localhost:8080/user/"+username;
		return template.getForObject(url,User.class);
	}
	public List<User> getAllUsers(){
		String url="http://localhost:8080/users";
		HttpHeaders headers=getHeaders();
		headers.set("Authorization",token);
		HttpEntity<User> entity= new HttpEntity<User>(null,headers);
		ResponseEntity<User[]> response=template.exchange(url,HttpMethod.GET,entity,User[].class);
		User[] emp=response.getBody();
		List<User> user=Arrays.asList(emp);
		return user;
	}
	//Authentication
	public ResponseEntity<JwtResponse> getToken(User user){
		String url="http://localhost:8080/login";
		//HttpHeaders headers = getHeaders();
		HttpEntity<User> entity=new HttpEntity<User>(user);
		ResponseEntity<JwtResponse> response=template.exchange(url,HttpMethod.POST,entity,JwtResponse.class);
		return response;
	
	}
	//Token generation
	public String getTokenResponse(User user) {
		ResponseEntity<JwtResponse> jwtToken=this.getToken(user);
		//System.out.println(jwtToken.getBody().getToken());
		token="Bearer "+jwtToken.getBody().getToken();
		//System.out.println("after appending"+token);
		this.setToken(token);
		return token;
	}
	public HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        return headers;
    }
	
}
