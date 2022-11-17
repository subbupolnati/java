package com.inventorymanagementsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventorymanagementsystem.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer>{
	public List<Customer> findByCustomerid(int customerid);

	public Customer findByCustomerusernameAndCustomerpassword(String username, String password);
}
