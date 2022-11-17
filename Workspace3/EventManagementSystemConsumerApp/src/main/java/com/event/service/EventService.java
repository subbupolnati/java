package com.event.service;



import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.event.controller.UserController;
import com.event.model.Event;



@Service
public class EventService {

	@Autowired
	RestTemplate template;
	@Autowired
	private UserService us;
	
	public EventService(RestTemplate template) {
		super();
		this.template = template;
	}
	public ResponseEntity<Event> addEvent(Event event) {
		String url="http://localhost:8080/event";
		HttpHeaders headers=us.getHeaders();
		//System.out.println(""+UserService.getToken());
		headers.set("Authorization",UserService.getToken());
		HttpEntity<Event> entity= new HttpEntity<Event>(event,headers);
		ResponseEntity<Event> response=template.postForEntity(url,entity,Event.class);
		return response;
	}
	public List<Event> getAllEvents() {
		String url="http://localhost:8080/events";
		HttpHeaders headers=us.getHeaders();
		//System.out.println(UserController.token);
		headers.set("Authorization",UserController.token);
		HttpEntity<Event> entity= new HttpEntity<Event>(null,headers);
		ResponseEntity<Event[]> response=template.exchange(url,HttpMethod.GET,entity,Event[].class);
		Event[] e=response.getBody();
		return Arrays.asList(e);
	}
	public List<Event> searchEventBySearchParticipantName(String name) {
		String url="http://localhost:8080/event/"+name;
		HttpHeaders headers=us.getHeaders();
		//System.out.println(UserController.token);
		headers.set("Authorization",UserController.token);
		HttpEntity<Event> entity= new HttpEntity<Event>(null,headers);
		ResponseEntity<Event[]> response=template.exchange(url,HttpMethod.GET,entity,Event[].class);
		Event[] e=response.getBody();
		return Arrays.asList(e);
	}
	public Event updateEvent(int id) {
		String url="http://localhost:8080/event/"+id;
		HttpHeaders headers=us.getHeaders();
		Event event=new Event();
		//System.out.println(UserController.token);
		headers.set("Authorization",UserController.token);
		HttpEntity<Event> entity= new HttpEntity<Event>(event,headers);
		ResponseEntity<Event> response=template.exchange(url,HttpMethod.PUT,entity,Event.class);
		return entity.getBody();
	}
	public void deleteEvent(int id) {
		String url="http://localhost:8080/event/"+id;
		HttpHeaders headers=us.getHeaders();
		//System.out.println(UserController.token);
		headers.set("Authorization",UserController.token);
		HttpEntity<Event> entity= new HttpEntity<Event>(null,headers);
		ResponseEntity<Event> response=template.exchange(url,HttpMethod.DELETE,entity,Event.class);
	}
}
