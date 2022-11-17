package com.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.booking.model.Buses;
import com.booking.model.User;
import com.booking.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	@RequestMapping("/")
	public String index() {
		return"index";
	}
	@RequestMapping("/loginpage")
	public String adminlogin(Model m) {
		User user=new User();
		m.addAttribute("user", user);
		return"login";
	}
	@RequestMapping("/userregister")
	public String userregister(@ModelAttribute("user") User user,Model m) {
		User u=userService.validate(user.getUsername(),user.getPassword(),user.getUsertype());
		if(u==null) {
			m.addAttribute("msg","Invalid Details");
			return "login";
			
		}
		else {
			if(user.getUsertype().equals("admin")) {
				return"homepage";
			}
			else {
				return "Userhome";
			}
		}		
	}
	@RequestMapping("/homepage")
	public String homepage(){
		return "homepage";
	}
	@RequestMapping("/userhome")
	public String userhome(Model m){
		return "Userhome";
	}
	@RequestMapping("/logout")
	public String logout() {
		return "index";
	}
	@RequestMapping("/createNewUser")	
	public String newUSer(Model m) {
		User user=new User();
		m.addAttribute("user", user);
		return "userRegister";
	}
	@RequestMapping("/usersave")
	public String insertUser(@ModelAttribute("user") User user, Model m) {
		User u=userService.addNewUser(user);
		return "index";
	}
}
