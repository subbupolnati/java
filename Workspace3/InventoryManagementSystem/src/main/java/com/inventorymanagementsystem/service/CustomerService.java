package com.inventorymanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventorymanagementsystem.exception.CustomerNotFoundException;
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
		try {
			return customerRepo.findAll();
		}catch(CustomerNotFoundException e) {
			throw new CustomerNotFoundException("customer not found");
		}
	}
	public Customer editCustomer(Customer customer,int customerid) {
		Optional<Customer> optional=customerRepo.findById(customerid);
		if(optional.isPresent()) {
			customer=optional.get();
			return customerRepo.save(customer);
		}
		else
			throw new CustomerNotFoundException("customer not found"+customerid);
	}
	public void deleteCustomer(int customerid) {
		try {
			customerRepo.deleteById(customerid);
		}
		catch(CustomerNotFoundException e) {
			throw new CustomerNotFoundException("customer not found"+customerid);
		}
	}
	public List<Customer> searchCustomer(int customerid){
		try {
			return customerRepo.findByCustomerid(customerid);
		}
		catch(CustomerNotFoundException e) {
			throw new CustomerNotFoundException("customer not found"+customerid);
		}
	}
	public Customer validate(String username,String password) {
		return customerRepo.findByCustomerusernameAndCustomerpassword(username, password);
	}
	public Customer validateUser(String username) {
		return customerRepo.findByCustomerusername(username);
	}
}
