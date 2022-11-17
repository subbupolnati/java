package com.airlines.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.airlines.exceptions.AirlineNotFoundException;
import com.airlines.model.Airlines;
import com.airlines.model.Passenger;

@Service
public class AirlinesService {

	RestTemplate restTemplate;

	public AirlinesService(RestTemplate restTemplate) {
		super();
		this.restTemplate = restTemplate;
	}
	//In this method add new airline 
	public ResponseEntity<Airlines> addNewAirlines(Airlines airlines) throws URISyntaxException {
		//URI uri=new URI("https://api.instantwebtools.net/v1/airlines");
		//String url="https://api.instantwebtools.net/v1/airlines";
		String url="http://localhost:8080/airlines";
		HttpEntity<Airlines> entity=new HttpEntity<Airlines>(airlines,null);
		ResponseEntity<Airlines> response=restTemplate.postForEntity(url,entity,Airlines.class);
		return response;
	}
	public List<Airlines> showAllAirlines(){
		//String url="https://api.instantwebtools.net/v1/airlines";
		String url="http://localhost:8080/airlines";
		HttpEntity<Airlines> entity=new HttpEntity<Airlines>(null,null);
		ResponseEntity<Airlines[]> response=restTemplate.exchange(url,HttpMethod.GET,entity,Airlines[].class);
		Airlines[] air=response.getBody();
		//List<Airlines> airline=;
		return Arrays.asList(air);
	}
	public Airlines getAirlinesById(int id){
			//String url="https://api.instantwebtools.net/v1/airlines/"+id;
			String url="http://localhost:8080/airlines/"+id;
			ResponseEntity<Airlines> entity=restTemplate.getForEntity(url,Airlines.class);
			//Airlines airline=entity.getBody();
			return entity.getBody();
	}
	public List<Passenger> getPassengerListByAirlineId(int id){
		String url="http://localhost:8080/airlines/"+id+"/passenger";
		ResponseEntity<Passenger[]> response=restTemplate.getForEntity(url,Passenger[].class);
		Passenger[] passenger=response.getBody();
		return Arrays.asList(passenger);
	}
}
