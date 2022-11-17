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
import com.inventory.model.Customer;
import com.inventory.model.Inventory;
import com.inventory.model.Stock;
import com.inventory.model.User;

@Service
public class InventoryService {
	@Autowired
	RestTemplate template;
	@Autowired
	private UserService us;
	public InventoryService(RestTemplate template) {
		super();
		this.template = template;
	}
	public ResponseEntity<Inventory> addInventory(Inventory inventory) {
		String url="http://localhost:8080/inventory";
		HttpHeaders headers=us.getHeaders();
		//System.out.println(UserController.getToken());
		headers.set("Authorization",UserController.getToken());
		HttpEntity<Inventory> entity= new HttpEntity<Inventory>(inventory,headers);
		ResponseEntity<Inventory> response=template.postForEntity(url,entity,Inventory.class);
		return response;
	}
	public List<Inventory> getAllInventory() {
		String url="http://localhost:8080/inventorys";
		HttpHeaders headers=us.getHeaders();
		System.out.println(UserController.token);
		headers.set("Authorization",UserController.token);
		HttpEntity<Inventory> entity= new HttpEntity<Inventory>(null,headers);
		ResponseEntity<Inventory[]> response=template.exchange(url,HttpMethod.GET,entity,Inventory[].class);
		Inventory[] p=response.getBody();
		List<Inventory> inv=Arrays.asList(p);
		return inv;
	}
}
