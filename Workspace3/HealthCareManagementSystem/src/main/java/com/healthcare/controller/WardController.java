package com.healthcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.healthcare.model.Nurses;
import com.healthcare.model.Ward;
import com.healthcare.service.NursesService;
import com.healthcare.service.WardService;

@Controller
public class WardController {

	@Autowired
	WardService wardService;
	@Autowired
	NursesService nursesService;
	@RequestMapping("/addWard")
	public String addWard(Model m) {
		Ward ward=new Ward();
		m.addAttribute("ward", ward);
		List<Nurses> nurseList=nursesService.getAllNurses();
		m.addAttribute("nurseList", nurseList);
		return "wardRegister";
	}
	@PostMapping("/saveWard")
	public String saveWard(@ModelAttribute("ward") Ward ward,Model m) {
		wardService.addWard(ward);
		m.addAttribute("msg","adding ward details successfully");
		return "wardRegister";
	}
}
