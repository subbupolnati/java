package com.employee.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.employee.model.Credential;
import com.employee.service.CredentialService;
import com.employee.service.EmployeeService;

@Controller
public class CredentialController {

	@Autowired 
	private CredentialService credentialService;//injecting Credential Service dependenecy
	
	@Autowired
	private EmployeeService employeeService;//injecting Employee Service dependenecy
	
	//Getter and setter methods
	public EmployeeService getEmployeeService() {
		return employeeService;
	}
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public CredentialService getCredentialService() {
		return credentialService;
	}

	public void setCredentialService(CredentialService credentialService) {
		this.credentialService = credentialService;
	}
	//THis Url is navigate to login page
	@RequestMapping("/")
	public String login(Model m) {
		Credential credential=new Credential();
		m.addAttribute("credential",credential);
		return"loginPage";
	}
	//THis Url is navigate to register New Register page
	@GetMapping("/credentialregisterpage")
	public String adminlogin(Model m) {
		m.addAttribute("credential",new Credential());
		return"credentialRegister";
	}
	//THis Url is navigate to after a enter register details saving to database using Jpa Reposioty
	@PostMapping("/credentialsave")
	public String insert(@Valid @ModelAttribute("credential") Credential credential ,BindingResult bindingResult, Model m) {
		if(bindingResult.hasErrors()) {
			return "credentialRegister";
		}
		else {
			credentialService.insert(credential);
			m.addAttribute("msg","Successfully Register Details");
			return "credentialRegister";
		}
	}
	//This Url is navigate to logout page
	@GetMapping("/logout")
		public String logout() {
			employeeService.logout();
			return "redirect:/";
	}
}
