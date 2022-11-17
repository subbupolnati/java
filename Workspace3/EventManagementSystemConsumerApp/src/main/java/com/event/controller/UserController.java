package com.event.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.event.model.User;
import com.event.service.UserService;


@Controller
public class UserController {

	@Autowired
	UserService userService;
	public static String token;
	public static String getToken() {
		return token;
	}
	public static void setToken(String token) {
		UserController.token = token;
	}
	@RequestMapping("/")
	public String login(Model m) {
		m.addAttribute("user",new User());
		return "login";
	}
	@RequestMapping("/newuser")
	public String newUserRegister(Model m) {
		m.addAttribute("user",new User());
		return "userRegister";
	}
	@PostMapping("/saveuser")
	public String saveUser(@ModelAttribute("user") User user,Model m) {
		userService.addUser(user);
		m.addAttribute("msg","adding successfully");
		return "userRegister";
	}
	//signup after login details
		@PostMapping("/signin")
		public String generateToken(@ModelAttribute("user") User user,Model m){
			User u=userService.validate(user.getUsername());
			System.out.println(u.getUsername());
			if(u.equals(null)){
				m.addAttribute("msg","please register user");
				return "login";
			}
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			Boolean status=encoder.matches(user.getPassword(),u.getPassword());//matches the raw password and encrypt password
			if(u.getUsername()!=user.getUsername()&&status==false){
				m.addAttribute("msg","Invalid password and username");
				return "login";
			}
			else {
				token=userService.getTokenResponse(user);
				System.out.println("user details"+user);
				System.out.println(token);
				if(user.getRole().equalsIgnoreCase("ROLE_Admin")){
					return "home";
				}
				else if(user.getRole().equalsIgnoreCase("ROLE_Customer")){
					
					return "redirect:addEvent";
				}
			}
			m.addAttribute("msg","please register user");
			return "login";
		}
}
