package com.event.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.event.controller.UserController;

import com.event.model.Venue;

@Service
public class VenueService {

	@Autowired
	RestTemplate template;
	@Autowired
	private UserService us;
	
	public VenueService(RestTemplate template) {
		super();
		this.template = template;
	}
	public ResponseEntity<Venue> addVenue(Venue venue) {
		String url="http://localhost:8080/venue";
		HttpHeaders headers=us.getHeaders();
		System.out.println("Supplier"+UserController.token);
		headers.set("Authorization",UserController.getToken());
		HttpEntity<Venue> entity= new HttpEntity<Venue>(venue,headers);
		ResponseEntity<Venue> response=template.postForEntity(url,entity,Venue.class);
		return response;
	}
	public List<Venue> getAllVenues() {
		String url="http://localhost:8080/venues";
		HttpHeaders headers=us.getHeaders();
		//System.out.println(UserController.token);
		headers.set("Authorization",UserController.token);
		HttpEntity<Venue> entity= new HttpEntity<Venue>(null,headers);
		ResponseEntity<Venue[]> response=template.exchange(url,HttpMethod.GET,entity,Venue[].class);
		Venue[] e=response.getBody();
		return Arrays.asList(e);
	}
	public List<Venue> searchVenue(String name) {
		String url="http://localhost:8080/venue/"+name;
		HttpHeaders headers=us.getHeaders();
		//System.out.println(UserController.token);
		headers.set("Authorization",UserController.token);
		HttpEntity<Venue> entity= new HttpEntity<Venue>(null,headers);
		ResponseEntity<Venue[]> response=template.exchange(url,HttpMethod.GET,entity,Venue[].class);
		Venue[] e=response.getBody();
		return Arrays.asList(e);
	}
	public Venue updateVenue(int id) {
		String url="http://localhost:8080/venue/"+id;
		HttpHeaders headers=us.getHeaders();
		Venue venue=new Venue();
		//System.out.println(UserController.token);
		headers.set("Authorization",UserController.token);
		HttpEntity<Venue> entity= new HttpEntity<Venue>(venue,headers);
		ResponseEntity<Venue> response=template.exchange(url,HttpMethod.PUT,entity,Venue.class);
		return entity.getBody();
	}
	public void deleteVenue(int id) {
		String url="http://localhost:8080/venue/"+id;
		HttpHeaders headers=us.getHeaders();
		//System.out.println(UserController.token);
		headers.set("Authorization",UserController.token);
		HttpEntity<Venue> entity= new HttpEntity<Venue>(null,headers);
		ResponseEntity<Venue> response=template.exchange(url,HttpMethod.DELETE,entity,Venue.class);
	}
}
