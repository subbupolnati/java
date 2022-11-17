package com.employee.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.employee.model.Credential;
import com.employee.model.Employee;
import com.employee.service.CredentialService;
import com.employee.service.EmployeeService;

@Controller
public class CredentialController {

	@Autowired 
	private CredentialService credentialService;//injecting Credential Service dependenecy
	
	@Autowired
	private BCryptPasswordEncoder bPasswordEncoder;
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
	@GetMapping("/")
	public String login(Model m) {
		m.addAttribute("credential",new Credential());
		return"loginPage";
	}
	//THis Url is navigate to register New Register page
	@GetMapping("/credentialregisterpage")
	public String adminlogin(Model m) {
		m.addAttribute("credential",new Credential());
		return"credentialRegister";
	}
	//THis Url is navigate to after a enter register details saving to database using Jpa Reposioty
	@PostMapping("/credential/save")
	public String insert(@Valid @ModelAttribute("credential") Credential credential ,BindingResult bindingResult, Model m) {
		if(bindingResult.hasErrors()) {
			return "credentialRegister";
		}
		else {
			credential.setPassword(this.bPasswordEncoder.encode(credential.getPassword()));
			credentialService.insert(credential);
			m.addAttribute("msg","Successfully Register Details");
			return "credentialRegister";
		}
	}
	//Checking the credentials
	@PostMapping("/credentialcheck")
	public String credentialCheck(@ModelAttribute("credential") Credential credential,Model m,HttpSession session) {
		Credential c=credentialService.validate(credential.getUserName(),credential.getPassword(),credential.getRole());
			if(c==null) {
				m.addAttribute("msg","Invalid Details");
				return "loginPage";
			}
			else{
				session.setAttribute("name",credential.getUserName());
				session.setAttribute("role", credential.getRole());
				if(credential.getRole().equalsIgnoreCase("Admin")) {
					List<Employee> emp=employeeService.getAllEmp();
					m.addAttribute("emp", emp);
					return"homepage";
				}
				else{
					Employee emp=employeeService.getEmp(credential.getUserName());
					if(emp!=null) {
						m.addAttribute("emp", emp);
						return "Userhome";
					}
					else {
						Employee employee=new Employee();
						employee.setCredential(credential);
						m.addAttribute("employee", employee);
						return "employeeRegister";
					}
				}	
			}
		}
			//This Url is navigate to logout page
		@GetMapping("/logout")
		public String logout() {
			return "redirect:/";
		}
}
