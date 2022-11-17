package com.onlineshoppingcart.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineshoppingcart.model.Payment;
import com.onlineshoppingcart.repository.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepo;
	Date date=new Date();
	public Payment insertPayment(Payment payment) {
		payment.setPaidDate(date);
		return paymentRepo.save(payment);
	}
	public Payment getPayment(int paymentid) {
		return paymentRepo.findById(paymentid).get();
	}
}
