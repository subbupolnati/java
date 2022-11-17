package com.onlineshoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.onlineshoppingcart.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;
}
