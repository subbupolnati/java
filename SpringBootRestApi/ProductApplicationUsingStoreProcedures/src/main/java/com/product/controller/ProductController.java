package com.product.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.product.model.Category;
import com.product.model.Product;
import com.product.service.CategoryService;
import com.product.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping("/productAdd")
	public String product(Model m) {
		Product product=new Product();
		List<Category> categoryList=categoryService.getAllCategory();
		m.addAttribute("clist", categoryList);
		m.addAttribute("product", product);
		return "productRegister";
	}
	@RequestMapping("/productsave")
	//public void addNewProduct(@RequestParam("pid")int pid,@RequestParam("pname")String pname,@RequestParam("cid")int cid,@RequestParam("avl_qul")int avl_qul,@RequestParam("price")int price) {
	public String addNewProduct(@ModelAttribute("product")Product product,Model m) {
		productService.addNewProduct(product);
		m.addAttribute("msg","add product successfully");
		return "productRegister";
	}
	@RequestMapping("/getAllproducts")
	public String getAllProducts(Model m) {
		List<Product> productList=productService.getAllProducts();
		m.addAttribute("plist", productList);
		return "viewproducts";
	}
	@RequestMapping("/update/{id}")
	public String update(@PathVariable("id") int pid,Model m) {
		Product product=productService.update(pid);
		List<Category> categoryList=categoryService.getAllCategory();
		m.addAttribute("clist", categoryList);
		m.addAttribute("product", product);
		return "productupdate";
	}
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") int pid) {
		productService.deleteProduct(pid);
		return "viewproducts";
	}
	@RequestMapping("/productupdate")
	public String productupdate(@ModelAttribute Product product,Model m) {
		Product p=productService.updateProduct(product);
		List<Product> productList=productService.getAllProducts();
		m.addAttribute("plist", productList);
		return "viewproducts";
	}
}
