package com.onlineshoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.onlineshoppingcart.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	
}
