package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.product.model.Product;
import com.product.model.User;
import com.product.service.ProductService;
import com.product.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	@Autowired
	ProductService productService;
	
	@RequestMapping("/")
	public String index() {
		return "index.html";
	}

	@RequestMapping("/loginpage")
	public String adminlogin(Model m) {
		User user = new User();
		m.addAttribute("user", user);
		return "login";
	}
	 @RequestMapping("/userregister") 
	 public String userregister(@ModelAttribute("user") User user,Model m) { 
		 User u=userService.validate(user.getUserid(),user.getPassword(),user.getType());
	  		if(u==null) { 
	  			m.addAttribute("msg","Invalid Details"); 
	  			return "login";
	  		} else { 
	  			if(user.getType().equals("admin")) { 
	  				return"homepage"; 
	  			} else {
	  					List<Product> productList=productService.getAllProducts();
	  					m.addAttribute("plist", productList);
	  					return "Userhome.html"; 
	  			} 
	  		} 
	  }
	@RequestMapping("/logout")
	public String logout() {
		return "index";
	}

	@RequestMapping("/createNewUser")
	public String newUSer(Model m) {
		// User user=new User();
		// m.addAttribute("user", user);
		return "userRegister";
	}

	@RequestMapping("/usersave")
	public String insertUser(@RequestParam("uid") String uid, @RequestParam("uname") String uname,
			@RequestParam("pass") String pass, @RequestParam("utype") String utype, Model m) {
		userService.addNewUser(uid, uname, pass, utype);
		m.addAttribute("msg", "Registered Successfully ");
		return "userRegister";
	}
}
