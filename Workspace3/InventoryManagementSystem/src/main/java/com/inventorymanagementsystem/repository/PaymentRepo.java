package com.inventorymanagementsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventorymanagementsystem.model.Payment;

@Repository
public interface PaymentRepo extends JpaRepository<Payment, Integer>{

	public List<Payment> findByPaymentid(int paymentid);
}
