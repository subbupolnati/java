package com.onlineshoppingcart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineshoppingcart.model.Product;
import com.onlineshoppingcart.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepo;
	
	public Product insertProduct(Product product) {
		return productRepo.save(product);
	}
	public List<Product>getAllProducts(){
		return productRepo.findAll();
	}
	public Product getProduct(int productid) {
		return productRepo.findById(productid).get();
	}
}
