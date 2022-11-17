package com.inventorymanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventorymanagementsystem.model.Customer;
import com.inventorymanagementsystem.repository.CustomerRepo;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepo customerRepo;
	
	public Customer addCustomer(Customer customer) {
		return customerRepo.save(customer);
	}
	public List<Customer> getAllCustomer(){
		return customerRepo.findAll();
	}
	public Customer editCustomer(int customerid) {
		Optional<Customer> optional=customerRepo.findById(customerid);
		Customer customer=null;
		if(optional.isPresent()) {
			customer=optional.get();
			return customer;
		}
		return customer;
	}
	public void deleteCustomer(int customerid) {
		customerRepo.deleteById(customerid);
	}
	public List<Customer> searchCustomer(int customerid){
		
			return customerRepo.findByCustomerid(customerid);
		
	}
	public Customer validate(String username,String password) {
		return customerRepo.findByCustomerusernameAndCustomerpassword(username, password);
	}
}
