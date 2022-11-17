package com.healthcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.healthcare.model.Patient;
import com.healthcare.model.Ward;
import com.healthcare.service.PatientService;
import com.healthcare.service.WardService;

@Controller
public class PatientController {

	@Autowired
	PatientService patientService;
	@Autowired
	WardService wardService;
	@RequestMapping("/addPatient")
	public String addPatient(Model m) {
		Patient patient=new Patient();
		List<Ward>ward=wardService.getAllWard();
		m.addAttribute("patient", patient);
		m.addAttribute("ward", ward);
		return "patientRegister";
	}
	@PostMapping("/savePatient")
	public String savePatient(@ModelAttribute("patient") Patient patient,Model m) {
		patientService.addPatient(patient);
		m.addAttribute("msg","successfully added patient");
		return "patientRegister";
	}
}
