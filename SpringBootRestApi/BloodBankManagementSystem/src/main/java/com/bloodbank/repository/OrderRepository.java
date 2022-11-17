package com.bloodbank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bloodbank.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
	public List<Order> findByOrderid(int id); 
}
