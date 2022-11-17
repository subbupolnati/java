package com.healthcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.healthcare.model.Surgeon;
import com.healthcare.service.SurgeonService;

@Controller
public class SurgeonController {

	@Autowired
	SurgeonService surgeonService;
	
	@RequestMapping("/addsurgeon")
	public String addSurgeon(Model m) {
		Surgeon surgeon=new Surgeon();
		m.addAttribute("surgeon", surgeon);
		return "surgeonRegister";
	}
	@PostMapping("/saveSurgeon")
	public String saveSurgeon(@ModelAttribute("surgeon") Surgeon surgeon,Model m) {
		surgeonService.addSurgeon(surgeon);
		m.addAttribute("msg","Surgeon adding successfully");
		return "surgeonRegister";
	}
}
