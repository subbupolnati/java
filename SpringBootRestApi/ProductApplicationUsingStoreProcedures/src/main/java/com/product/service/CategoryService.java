package com.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.model.Category;
import com.product.repository.CategoryRepo;

@Service
public class CategoryService {

	@Autowired
	CategoryRepo categoryRepo;
	
	public Category addNewCategory(Category category) {
		return categoryRepo.save(category);
	}
	
	public List<Category> getAllCategory(){
		return categoryRepo.findAll();
	}
}
