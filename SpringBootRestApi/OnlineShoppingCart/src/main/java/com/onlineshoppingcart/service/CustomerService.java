package com.onlineshoppingcart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineshoppingcart.model.Customer;
import com.onlineshoppingcart.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepo;
	
	public Customer insertCustomer(Customer customer) {
		return customerRepo.save(customer);
	}
	
	public Customer getCustomer(int id) {
		return customerRepo.findById(id).get();
	}
}
