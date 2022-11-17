package com.bloodbank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bloodbank.model.Order;
import com.bloodbank.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepo;
	
	public Order addOrder(Order order) {
		return orderRepo.save(order);
	}
	public List<Order> getAllOrders(){
		return orderRepo.findAll();
	}
	public List<Order> searchOrder(int orderid) {
		return orderRepo.findByOrderid(orderid);
	}
	public Order updateOrder(int orderid) {
		Optional<Order> optional=orderRepo.findById(orderid);
		Order order=null;
		if(optional.isPresent()) {
			order=optional.get();
			return order;
		}
		return order;
	}
	public void deletOrder(int orderid) {
		orderRepo.deleteById(orderid);
	}
}
