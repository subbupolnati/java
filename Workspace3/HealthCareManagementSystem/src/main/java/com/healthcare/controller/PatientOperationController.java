package com.healthcare.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.healthcare.model.OperationTheatre;
import com.healthcare.model.Patient;
import com.healthcare.model.PatientOperation;
import com.healthcare.model.Surgeon;
import com.healthcare.service.OperationTheatreService;
import com.healthcare.service.PatientOperationService;
import com.healthcare.service.PatientService;
import com.healthcare.service.SurgeonService;
@Controller
public class PatientOperationController {

	@Autowired
	PatientOperationService patientOperationService;
	
	@Autowired
	SurgeonService surgeonService;
	@Autowired
	PatientService patientService;
	@Autowired
	OperationTheatreService ots;
	@PostConstruct
	public void create() {
		OperationTheatre op1=new OperationTheatre(1);
		ots.addOpertionTheatre(op1);
	}
	@RequestMapping("/addpatientOperation")
	public String addPatientOpertion(Model m) {
		PatientOperation po=new PatientOperation();
		List<OperationTheatre> opList=ots.getListTheatre();
		List<Surgeon> surgeonList=surgeonService.getAllSurgeons();
		List<Patient>patientList=patientService.getAllPatient();
		m.addAttribute("patientOperation", po);
		m.addAttribute("opList", opList);
		m.addAttribute("patientList", patientList);
		m.addAttribute("surgeonList",surgeonList);
		return "PatientOperationRegister";
	}
	@PostMapping("/savePatientOperation")
	public String savePatientOperation(@ModelAttribute("patientOperation") PatientOperation patientOperation,Model m) {
		patientOperationService.addOperation(patientOperation);
		m.addAttribute("msg","patientOpertion successfully");
		return "PatientOperationRegister";
	}
}
