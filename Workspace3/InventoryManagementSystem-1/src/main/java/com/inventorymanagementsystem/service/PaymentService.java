package com.inventorymanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventorymanagementsystem.model.Payment;
import com.inventorymanagementsystem.repository.PaymentRepo;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepo paymentRepo;
	
	public Payment addPayment(Payment payment) {
		return paymentRepo.save(payment);
	}
	public List<Payment> getAllPayments(){
		return paymentRepo.findAll();
	}
	public Payment editPayment(int paymentid) {
		Optional<Payment> optional=paymentRepo.findById(paymentid);
		Payment payment=null;
		if(optional.isPresent()) {
			payment=optional.get();
			return payment;
		}
		return payment;
	}
	public void deletePayment(int paymentid) {
		paymentRepo.deleteById(paymentid);
	}
	public List<Payment> searchPayment(int paymentid){
		return paymentRepo.findByPaymentid(paymentid);
	}
}