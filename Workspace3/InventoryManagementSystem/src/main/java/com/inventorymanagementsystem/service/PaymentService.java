package com.inventorymanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventorymanagementsystem.exception.PaymentNotFoundException;
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
		try {
			return paymentRepo.findAll();
		}catch (PaymentNotFoundException e) {
			throw new PaymentNotFoundException("payment not found");
		}
	}
	public Payment editPayment(Payment payment, int paymentid) {
		Optional<Payment> optional=paymentRepo.findById(paymentid);
		if(optional.isPresent()) {
			payment=optional.get();
			return paymentRepo.save(payment);
		}
		else
			throw new PaymentNotFoundException("payment not found"+paymentid);
	}
	public void deletePayment(int paymentid) {
		try{
			paymentRepo.deleteById(paymentid);
		}catch(PaymentNotFoundException pe) {
			pe.getMessage();
		}
	}
	public List<Payment> searchPayment(int paymentid){
		try{
			return paymentRepo.findByPaymentid(paymentid);
		}
		catch (PaymentNotFoundException e) {
			throw new PaymentNotFoundException("payment not found"+paymentid);
		}
	}
}