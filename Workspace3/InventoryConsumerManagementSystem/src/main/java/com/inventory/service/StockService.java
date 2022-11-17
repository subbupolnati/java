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
import com.inventory.model.Permission;
import com.inventory.model.Stock;

@Service
public class StockService {
	RestTemplate template;
	@Autowired
	private UserService us;
	public StockService(RestTemplate template) {
		super();
		this.template = template;
	}
	
	public ResponseEntity<Stock> addStock(Stock stock) {
		String url="http://localhost:8080/stock";
		HttpHeaders headers=us.getHeaders();
		//System.out.println(UserController.token);
		headers.set("Authorization",UserController.getToken());
		HttpEntity<Stock> entity= new HttpEntity<Stock>(stock,headers);
		ResponseEntity<Stock> response=template.postForEntity(url,entity,Stock.class);
		return response;
	}

	public List<Stock> getAllStock() {
		String url="http://localhost:8080/stocks";
		HttpHeaders headers=us.getHeaders();
		//System.out.println(UserController.token);
		headers.set("Authorization",UserController.getToken());
		HttpEntity<Stock> entity= new HttpEntity<Stock>(null,headers);
		ResponseEntity<Stock[]> response=template.exchange(url,HttpMethod.GET,entity,Stock[].class);
		Stock[] p=response.getBody();
		List<Stock> stock=Arrays.asList(p);
		return stock;
	}
}
