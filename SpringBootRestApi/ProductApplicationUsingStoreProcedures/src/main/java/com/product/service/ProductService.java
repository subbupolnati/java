package com.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.model.Product;
import com.product.repository.ProductRepo;

@Service
public class ProductService {

	@Autowired
	ProductRepo productRepo;
	 public void addNewProduct(Product product) {
		 productRepo.saveProduct(product.getProduct_id(),product.getAvailabel_quntity(),product.getName(),product.getPrice(),product.getCategory().getCategory_id());
	 }
	 
	 public List<Product> getAllProducts(){
		 return productRepo.findAll();
	 }
	 public Product update(int pid) {
		 Optional<Product> optional=productRepo.findById(pid);
		 Product product=null;
		 if(optional.isPresent()) {
			 product=optional.get();
		 }
		 return product;
	 }
	 public void deleteProduct(int pid) {
		 productRepo.deleteById(pid);
	 }
	 public Product updateProduct(Product product) {
		 return productRepo.save(product);
	 }
}

