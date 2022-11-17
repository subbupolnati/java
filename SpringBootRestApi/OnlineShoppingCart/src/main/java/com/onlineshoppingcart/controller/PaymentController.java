package com.onlineshoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.onlineshoppingcart.service.PaymentService;

@Controller
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
}
