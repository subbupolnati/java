package com.airlines.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.airlines.model.Airlines;
import com.airlines.model.Passenger;

@Service
public class PassengerService {

	RestTemplate restTemplate;

	public PassengerService(RestTemplate restTemplate) {
		super();
		this.restTemplate = restTemplate;
	}
	
	public ResponseEntity<Passenger> addNewPassengers(Passenger passenger) throws URISyntaxException{
			//URI uri=new URI("https://api.instantwebtools.net/v1/passenger");
			URI uri=new URI("http://localhost:8080/passenger");
			HttpEntity<Passenger> entity=new HttpEntity<Passenger>(passenger,null);
			ResponseEntity<Passenger> response=restTemplate.postForEntity(uri,entity,Passenger.class);
			return response;
		}
		public List<Passenger> showAllPassengers(){
			String url="http://localhost:8080/passenger";
			HttpEntity<Passenger> entity=new HttpEntity<Passenger>(null,null);
			ResponseEntity<Passenger[]> response=restTemplate.exchange(url,HttpMethod.GET,entity,Passenger[].class);
			Passenger[] pass=response.getBody();
			List<Passenger> passenger=Arrays.asList(pass);
			return passenger;
		}
		public Passenger getPassengerById(int passenger_id){
				String url="http://localhost:8080/passenger/"+passenger_id;
				ResponseEntity<Passenger> entity=restTemplate.getForEntity(url,Passenger.class);
				Passenger passenger=entity.getBody();
				return passenger;
		}
		
		//This method updated the existing post using postId
		public ResponseEntity<Passenger> updatePassengerById(int id){
			String url="http://localhost:8080/passenger/"+id;
			Passenger passenger=null;
			HttpEntity<Passenger> entity=new HttpEntity<Passenger>(passenger,null);
			ResponseEntity<Passenger> response=restTemplate.exchange(url,HttpMethod.PUT,entity,Passenger.class);
			return response;
		}
		//This method delete the existing post using postId
		public ResponseEntity<Passenger> DeletePassengerById(int id) throws URISyntaxException{
			URI uri=new URI("http://localhost:8080/passenger/"+id);
			HttpEntity<Passenger> entity=new HttpEntity<Passenger>(null,null);
			ResponseEntity<Passenger> response=restTemplate.exchange(uri,HttpMethod.DELETE,entity,Passenger.class);
			return response;
		}
}
