package com.inventorymanagementsystem.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.inventorymanagementsystem.model.Customer;
import com.inventorymanagementsystem.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService cs;
	@Autowired
	private BCryptPasswordEncoder bPasswordEncoder;
	@PostMapping("/customer")
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer){
		customer.setCustomerpassword(this.bPasswordEncoder.encode(customer.getCustomerpassword()));
		Customer c=cs.addCustomer(customer);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{username}").buildAndExpand(c.getCustomerusername()).toUri();
		return ResponseEntity.created(location).build();
	}
	@GetMapping("/customers")
	public List<Customer> getAllCustomers() {
			return cs.getAllCustomer();	
	}
	@PostMapping("/Customer/{id}")
	public List<Customer> searchCustomer(@PathVariable("id") int id) {
			return cs.searchCustomer(id);
	}
	@PutMapping("/customer/{id}")
	public Customer updateCustomer(@RequestBody Customer customer, @PathVariable("id")int id) {
		return cs.editCustomer(customer,id);
	}
	@DeleteMapping("/customer/{id}")
	public void deleteCustomer(@PathVariable("id") int id) {
			cs.deleteCustomer(id);
	}
	@GetMapping("/customer/{username}")
	public Customer validateUser(@PathVariable("username")String username) {
		return cs.validateUser(username);
	}
}
