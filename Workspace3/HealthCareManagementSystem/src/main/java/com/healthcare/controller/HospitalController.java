package com.healthcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.healthcare.model.Hospital;
import com.healthcare.service.HosptialService;

@Controller
public class HospitalController {

	@Autowired
	HosptialService hosptialService;
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	@RequestMapping("/addHospital")
	public String addHospital(Model m) {
		Hospital hospital=new Hospital();
		m.addAttribute("hospital", hospital);
		return "HospitalRegister";
	}
	@PostMapping("/saveHospital")
	public String saveHospital(@ModelAttribute("hospital")Hospital hospital,Model m){
		hosptialService.addHospital(hospital);
		m.addAttribute("msg", "Adding successfully");
		return "HospitalRegister";
	}
	@RequestMapping("/viewHospitals")
	public String viewHospitals(Model m) {
		List<Hospital> hospitalList=hosptialService.getAllHospitals();
		m.addAttribute("hospitalList", hospitalList);
		return "viewHospitals";
	}
	@RequestMapping("/searchhospital")
	public String searchHospital(String name,Model m) {
		List<Hospital> hospitalList=hosptialService.searchHospital(name);
		if(hospitalList.isEmpty()) {
			m.addAttribute("message", "No data Found ");
		}
		m.addAttribute("hospitalList", hospitalList);
		return "viewHospitals";
	}
}
