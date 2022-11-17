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
import com.inventory.model.Stock;
import com.inventory.model.Supplier;
import com.inventory.model.User;

@Service
public class SupplierService {
	RestTemplate template;
	@Autowired
	private UserService us;
	public SupplierService(RestTemplate template) {
		super();
		this.template = template;
	}
	public ResponseEntity<Supplier> addSupplier(Supplier supplier) {
		String url="http://localhost:8080/supplier";
		HttpHeaders headers=us.getHeaders();
		//System.out.println("Supplier"+UserController.token);
		headers.set("Authorization",UserController.getToken());
		HttpEntity<Supplier> entity= new HttpEntity<Supplier>(supplier,headers);
		ResponseEntity<Supplier> response=template.postForEntity(url,entity,Supplier.class);
		return response;
	}
	public Supplier validate(String username) {
		String url="http://localhost:8080/supplier/"+username;
		return template.getForObject(url,Supplier.class);
	}
	public List<Supplier> getAllSupplier() {
		String url="http://localhost:8080/suppliers";
		HttpHeaders headers=us.getHeaders();
		System.out.println(UserController.token);
		headers.set("Authorization",UserController.token);
		HttpEntity<Supplier> entity= new HttpEntity<Supplier>(null,headers);
		ResponseEntity<Supplier[]> response=template.exchange(url,HttpMethod.GET,entity,Supplier[].class);
		Supplier[] p=response.getBody();
		List<Supplier> sup=Arrays.asList(p);
		return sup;
	}
}
