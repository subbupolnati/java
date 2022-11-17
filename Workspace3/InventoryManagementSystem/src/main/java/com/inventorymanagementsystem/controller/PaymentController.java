package com.inventorymanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.inventorymanagementsystem.model.Payment;
import com.inventorymanagementsystem.service.PaymentService;

@RestController
public class PaymentController {

	@Autowired
	PaymentService paymentService;
	@PostMapping("/payment")
	public Payment savePayment(@RequestBody Payment payment) {
		return paymentService.addPayment(payment);
	}
	@GetMapping("/payments")
	public List<Payment> getAllPayments(Model m) {
		return paymentService.getAllPayments();
	}
	@PostMapping("/payment/{id}")
	public List<Payment> searchPayment(@PathVariable("id") int id) {
		return paymentService.searchPayment(id);
	}
	@PutMapping("/payment/{id}")
	public Payment updatePayment(@RequestBody Payment payment, @PathVariable("id")int id) {
		return paymentService.editPayment(payment,id);
	}
	@DeleteMapping("/payment/{id}")
	public void deletePayment(@PathVariable("id") int id,Model m) {
		paymentService.deletePayment(id);
		
	}
}
