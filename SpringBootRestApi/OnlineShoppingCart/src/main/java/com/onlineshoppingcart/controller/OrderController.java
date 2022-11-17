package com.onlineshoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.onlineshoppingcart.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;
}
