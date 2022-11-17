package com.onlineshoppingcart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineshoppingcart.model.Order;
import com.onlineshoppingcart.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepo;
	
	
	public Order insertOrder(Order order) {
		return orderRepo.save(order);
	}
	
	public List<Order> getAllOrders(){
		return orderRepo.findAll();
	}
	public Order getorder(int id) {
		return orderRepo.findById(id).get();
	}
}
