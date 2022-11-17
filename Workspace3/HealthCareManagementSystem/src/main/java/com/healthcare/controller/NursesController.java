package com.healthcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.healthcare.model.Nurses;
import com.healthcare.service.NursesService;

@Controller
public class NursesController {

	@Autowired
	NursesService nursesService;
	
	@RequestMapping("/addNurses")
	public String addNurses(Model m) {
		Nurses nurse=new Nurses();
		m.addAttribute("nurse", nurse);
		return "NurseRegister";
	}
	@PostMapping("/saveNurse")
	public String saveNurse(@ModelAttribute("nurse")Nurses nurse,Model m) {
		nursesService.addNurses(nurse);
		m.addAttribute("msg","Nurses adding successfully");
		return "NurseRegister";
	}
}
