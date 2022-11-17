package com.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.product.model.Category;
import com.product.service.CategoryService;

@Controller
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	@RequestMapping("/addCategory")
	public String category(Model m) {
		Category category=new Category();
		m.addAttribute("category", category);
		return "categoryRegister";
	}
	@RequestMapping("/categorysave")
	public String addNewCategory(@ModelAttribute("category")Category category,Model m) {
		Category c=categoryService.addNewCategory(category);
		m.addAttribute("msg","Add successfully");
		return "categoryRegister";
	}
	@RequestMapping("/homepage")
	public String homepage() {
		return"homepage";
	}
	
	
}
