package com.example.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.User;
import com.example.service.UserService;


@Controller
public class UserController {

	@Autowired
	private UserService us;
	
	public UserService getUs() {
		return us;
	}
	public void setUs(UserService us) {
		this.us = us;
	}
	@RequestMapping(path="/" ,method = RequestMethod.GET)
	public String validateUser(Model m) {
		User user=new User();
		m.addAttribute("user",user);
		return "registerpage";
	}
	@RequestMapping(path ="/register",method = RequestMethod.POST)
	public String submitForm(@Valid @ModelAttribute("user") User user,BindingResult bindingResult, Model m) {
		if (bindingResult.hasErrors()) {
			return "registerpage";
		} else {
			us.insertUser(user);
			return "success";
		}
	}

}
