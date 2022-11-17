package com.sample.cotroller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.sample.model.Credential;
import com.sample.model.Employee;
import com.sample.service.CredentialService;
import com.sample.service.EmployeeService;



@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	@Autowired 
	private CredentialService credentialService;

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

	@RequestMapping("/")
	public String login(Model m) {
		Credential c=new Credential();
		m.addAttribute("credential",c);
		return"login";
	}
	
	@RequestMapping("/loginregisterpage")
	public String adminlogin(Model m) {
		Credential c=new Credential();
		m.addAttribute("credential",c);
		return"loginregister";
	}
	@RequestMapping("/save")
	public String insert(@Valid @ModelAttribute("credential") Credential credential ,BindingResult bindingResult, Model m) {
		if(bindingResult.hasErrors()) {
			return "loginregister";
		}
		else {
		credentialService.insert(credential);
			return "login";
		}
	}
	@RequestMapping("/credentialcheck")
	public String validate(@ModelAttribute("credential") Credential credential,Model m) {
		Credential c=credentialService.validate(credential.getUsername(),credential.getPassword());
		if(c==null) {
			m.addAttribute("msg","Invalid Details");
			return "login";
		}
		else{
			if(credential.getUsername().equals("admin")&& credential.getPassword().equals("admin")) {
				List<Employee> emp=employeeService.getAllEmp();
				m.addAttribute("emp", emp);
				return"homepage";
			}
			else{
				Employee emp=employeeService.getEmp(credential.getUsername());
				if(emp!=null) {
					m.addAttribute("emp", emp);
					return "Userhome";
				}
				else {
					return "redirect:createNewEmployee";
				}
			}
			
		}
	}
		
	@RequestMapping("/logout")
	public String logout() {
		return "redirect:/";
	}
	@RequestMapping("/createNewEmployee")	
	public String newEmployee(Model m) {
		Employee emp=new Employee();
		m.addAttribute("employee", emp);
		return "register";
	}
	@RequestMapping("/usersave")
	public String insertUser(@Valid @ModelAttribute("employee") Employee employee,BindingResult bindingResult, Model m) {
		if(bindingResult.hasErrors()) {
			return "register";
		}else {
			employeeService.insertEmployee(employee);
			Employee emp=employeeService.getEmp(employee.getUsername());
			m.addAttribute("emp", emp);
			return "Userhome";
		}
	}
	@RequestMapping("/adminupdate")
	public String updateAdmin(@Valid @ModelAttribute("employee") Employee employee,BindingResult bindingResult, Model m) {
		if(bindingResult.hasErrors()) {
			return "update";
		}else {
			employeeService.insertEmployee(employee);
			List<Employee> emp=employeeService.getAllEmp();
			m.addAttribute("emp", emp);
			return "homepage";
		}
	}
		
	@RequestMapping("/update/{empid}")
	public String updateEmployee(@PathVariable("empid") int empid,Model m) {
		Employee e=employeeService.update(empid);
		m.addAttribute("employee", e);
		return "update";
	}
	@RequestMapping("/updateByusername/{username}")
	public String updateEmployeeByUsername(@PathVariable("username") String username,Model m) {
		Employee e=employeeService.updateByUsername(username);
		m.addAttribute("employee", e);
		return "edit";
	}
	@RequestMapping("/userupdate")
	public String updateUser(@Valid @ModelAttribute("employee") Employee employee,BindingResult bindingResult, Model m) {
		if(bindingResult.hasErrors()) {
			return "edit";
		}else {
			employeeService.insertEmployee(employee);
			Employee emp=employeeService.getEmp(employee.getUsername());
			m.addAttribute("emp", emp);
			return "Userhome";
		}
	}
}
