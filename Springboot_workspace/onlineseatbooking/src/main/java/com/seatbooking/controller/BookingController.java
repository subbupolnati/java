package com.seatbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.seatbooking.model.Theater;
import com.seatbooking.model.User;
import com.seatbooking.service.BookingService;
import com.seatbooking.service.UserService;

@Controller
public class BookingController {
	@Autowired
	private BookingService bs;
	@Autowired
	private UserService us;

	public UserService getUs() {
		return us;
	}

	public void setUs(UserService us) {
		this.us = us;
	}

	public BookingService getBs() {
		return bs;
	}

	public void setBs(BookingService bs) {
		this.bs = bs;
	}
	@RequestMapping("/")
	public String home(Model m) {
		Theater theater=new Theater();
		User user=new User();
		m.addAttribute("user",user);
		m.addAttribute("theater",theater);
		return "index";
	}
	
	/*@RequestMapping("/adminloginvalidation")
	public String adminvalidation(@ModelAttribute("user") User user) {
		
		return "admin";
		
	}*/
	
	@RequestMapping("/admin")
	public String adminpage() {
		return "admin";
	}
	@RequestMapping("/adduser")
	public String userRegisterpage() {
		return "userRegister";
	}
	@RequestMapping("/userreg")
	public String adduser(@ModelAttribute("user") User user) {
		us.insertUser(user);
		return "admin";
	}
	@RequestMapping("/addtheater")
	public String theater()
	{
		return "addnewtheater";
	}
	@RequestMapping(path="/theaterreg",method = RequestMethod.POST)
	public String theaterregister(@ModelAttribute("theater") Theater theater)
	{
		bs.insertTheater(theater);
		return"admin";
	}
	@RequestMapping("/viewalltheater")
	public String viewTheaters(Model m) {
		List<Theater> tlist=bs.viewAll();
		m.addAttribute("tlist", tlist);
		return "TheaterDetails";
	}
}

