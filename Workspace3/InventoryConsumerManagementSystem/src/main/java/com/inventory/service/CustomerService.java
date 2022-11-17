package com.inventory.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.inventory.controller.UserController;
import com.inventory.model.Customer;
import com.inventory.model.Payment;
import com.inventory.model.Permission;
import com.inventory.model.Supplier;

@Service
public class CustomerService {

	RestTemplate template;
	@Autowired
	private UserService us;
	public CustomerService(RestTemplate template) {
		super();
		this.template = template;
	}
	
	public ResponseEntity<Customer> addCustomer(Customer customer) {
		String url="http://localhost:8080/customer";
		HttpHeaders headers=us.getHeaders();
		//System.out.println("Customer "+UserController.getToken());
		headers.set("Authorization",UserController.getToken());
		HttpEntity<Customer> entity= new HttpEntity<Customer>(customer,headers);
		ResponseEntity<Customer> response=template.postForEntity(url,entity,Customer.class);
		return response;
	}
	public Customer validate(String username) {
		String url="http://localhost:8080/customer"+username;
		return template.getForObject(url,Customer.class);
	}

	public List<Customer> getAllCustomers() {
		String url="http://localhost:8080/customers";
		HttpHeaders headers=us.getHeaders();
		System.out.println(UserController.token);
		headers.set("Authorization",UserController.token);
		HttpEntity<Customer> entity= new HttpEntity<Customer>(null,headers);
		ResponseEntity<Customer[]> response=template.exchange(url,HttpMethod.GET,entity,Customer[].class);
		Customer[] p=response.getBody();
		List<Customer> sup=Arrays.asList(p);
		return sup;
	}
	
}
