package com.onlineshoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.onlineshoppingcart.model.User;
import com.onlineshoppingcart.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/")
	public String login(Model m) {
		User user=new User();
		m.addAttribute("user",user);
		return"loginPage";
	}
	//THis Url is navigate to register New Register page
	@GetMapping("/userregisterpage")
	public String adminlogin(Model m) {
		m.addAttribute("user",new User());
		return"credentialRegister";
	}
	//THis Url is navigate to after a enter register details saving to database using Jpa Reposioty
	@PostMapping("/usersave")
	public String insert(@ModelAttribute("user") User user, Model m) {
			userService.insertUser(user);
			m.addAttribute("msg","Successfully Register Details");
			return "credentialRegister";
	}
	//This Url is navigate to logout page
	@GetMapping("/logout")
		public String logout() {
			return "redirect:/";
	}
	@PostMapping("/credentialcheck")
	public String validate(@ModelAttribute("user") User user,Model m) {
		User u=userService.validate(user.getUserid(),user.getPassword(),user.getRole());
		if(u==null) {
			m.addAttribute("msg","Invalid Details");
			return "loginPage";
		}
		else {
			
		}
		return "credentialRegister";
	}
}
