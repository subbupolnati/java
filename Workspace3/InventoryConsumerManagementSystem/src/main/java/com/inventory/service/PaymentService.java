package com.inventory.service;

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

import com.inventory.controller.UserController;
import com.inventory.model.JwtResponse;
import com.inventory.model.Payment;
import com.inventory.model.Supplier;

@Service
public class PaymentService {

	RestTemplate template;
	@Autowired
	private UserService us;
	public PaymentService(RestTemplate template) {
		super();
		this.template = template;
	}
	public ResponseEntity<Payment> addPayment(Payment payment) {
		String url="http://localhost:8080/payment";
		HttpHeaders headers=us.getHeaders();
		//System.out.println(UserController.token);
		headers.set("Authorization",UserService.token);
		HttpEntity<Payment> entity= new HttpEntity<Payment>(payment,headers);
		ResponseEntity<Payment> response=template.postForEntity(url,entity,Payment.class);
		return response;
	}
	public List<Payment> getAllPayments() {
		String url="http://localhost:8080/payments";
		HttpHeaders headers=us.getHeaders();
		//System.out.println(UserController.token);
		headers.set("Authorization",UserController.getToken());
		HttpEntity<Payment> entity= new HttpEntity<Payment>(null,headers);
		ResponseEntity<Payment[]> response=template.exchange(url,HttpMethod.GET,entity,Payment[].class);
		Payment[] p=response.getBody();
		List<Payment> sup=Arrays.asList(p);
		return sup;
	}

}