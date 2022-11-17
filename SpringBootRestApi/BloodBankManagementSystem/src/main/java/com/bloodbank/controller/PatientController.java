package com.bloodbank.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bloodbank.model.Patient;
import com.bloodbank.model.Permission;
import com.bloodbank.service.PatientService;
import com.bloodbank.service.PermissionService;

@Controller
public class PatientController {

	@Autowired
	private PatientService patientService;
	@Autowired
	private PermissionService permissionService;
	Logger logger=LoggerFactory.getLogger("PatientController.class");
	@RequestMapping("/newpatient")
	public String createPatient(Model m) {
		m.addAttribute("patient",new Patient());
		List<Permission> plist=permissionService.getAllPermissions();
		m.addAttribute("permissionList", plist);
		return "PatientRegister";
	}
	@PostMapping("/savepatient")
	public String savePatient(@ModelAttribute("patient") Patient patient,Model m) {
		logger.info("Adding patient ");
		patientService.addPatient(patient);
		m.addAttribute("msg","Patient added successfully");
		return "PatientRegister";
	}
	@RequestMapping("/viewpatients")
	public String viewPatients(Model m) {
		logger.info("view All Patient list");
		List<Patient> patientList=patientService.getAllpatients();
		m.addAttribute("patientList",patientList);
		return "viewPatients";
	}
	@RequestMapping("/updatepatient/{id}")
	public String updatePatient(@PathVariable("id")int id,Model m) {
		logger.info("update patient details based on id");
		List<Permission> plist=permissionService.getAllPermissions();
		m.addAttribute("patient",patientService.updatePatient(id));
		m.addAttribute("permissionList", plist);
		m.addAttribute("msg","Patient successfully added");
		return "PatientRegister";
	}
	@RequestMapping("/deletepatient/{id}")
	public String deletePatient(@PathVariable("id") int id,Model m) {
		logger.info("delete patient details based on id");
		patientService.deletPatient(id);
		List<Patient> patientList=patientService.getAllpatients();
		m.addAttribute("patientList",patientList);
		return "viewPatients";
	}
	@RequestMapping("/searchpatient")
	public String searchPatient(@RequestParam("id") int id,Model m) {
		logger.info("search patient details based on patient id");
		List<Patient>patientList=patientService.searchPatient(id);
		if(patientList.isEmpty()) {
			m.addAttribute("message","No data Found");
			return "viewPatients";
		}
		m.addAttribute("patientList",patientList);
		return "viewPatients";
	}
}
