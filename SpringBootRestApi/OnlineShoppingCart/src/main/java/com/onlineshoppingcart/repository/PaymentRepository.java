package com.onlineshoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineshoppingcart.model.Payment;
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer>{

}
