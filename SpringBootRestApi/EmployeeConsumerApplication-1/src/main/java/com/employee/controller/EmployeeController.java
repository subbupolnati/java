package com.employee.controller;

import java.net.URISyntaxException;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.employee.model.Credential;
import com.employee.model.Employee;
import com.employee.service.CredentialService;
import com.employee.service.EmployeeService;

@Controller
//This is a employee Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;//injecting Employee Service dependenecy
	@Autowired
	private CredentialService credentialService;
	//Getter and setter methods
	public CredentialService getCredentialService() {
		return credentialService;
	}

	public void setCredentialService(CredentialService credentialService) {
		this.credentialService = credentialService;
	}

	public EmployeeService getEmployeeService() {
		return employeeService;
	}
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	static String token;
	//signup after login details
	@PostMapping("/signin")
	public String generateToken(@Valid@ModelAttribute("credential") Credential credential,Model m,HttpSession session){
		Credential c=credentialService.validate(credential.getUserName());
		if(c==null){
			m.addAttribute("msg","please register your details");
			return "loginPage";
		}
		//System.out.println("database pwd"+c.getPassword());
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Boolean status=encoder.matches(credential.getPassword(),c.getPassword());//matches the raw password and encrypt password
		if(c.getUserName()!=credential.getUserName()&&status==false){
			m.addAttribute("msg","Invalid password and username");
			return "loginPage";
		}
		else{
			employeeService.getTokenResponse(credential);
			session.setAttribute("name",c.getUserName());
			session.setAttribute("role", c.getRole());
			if(credential.getRole().equalsIgnoreCase("ROLE_Admin")){
				List<Employee> emp=employeeService.getAllEmp();
				m.addAttribute("emp", emp);
				return "homepage";
			}
			else if(c.getRole().equalsIgnoreCase("ROLE_Employee")){
				Employee emp=employeeService.getEmp(c.getUserName());
				if(emp!=null) {
					m.addAttribute("emp", emp);
					return "Userhome";
				}
				else {
					Employee employee=new Employee();
					System.out.println("c");
					employee.setCredential(c);
					m.addAttribute("employee", employee);
					return "employeeRegister";
				}
			}
			else {
				m.addAttribute("msg","please select valid Role");
				return "loginpage";
			}
		}
		
	}
	//after register employee save to database
	@PostMapping("/employeesave")
	public String insert(@Valid @ModelAttribute("employee") Employee employee,BindingResult bindingResult, Model m) throws URISyntaxException {
		//System.out.println(employee.getCredential());
		if(bindingResult.hasErrors()) {
			return "employeeRegister";
		}
		else {
			System.out.println(employee);
			Employee emp=employeeService.insertEmp(employee);
			System.out.println(emp);
			m.addAttribute("emp",emp);
			return "Userhome";
		}
	}
	//click submit button admin update admin side update save to database
	@PostMapping("/adminupdate")
	public String updateAdmin(@Valid @ModelAttribute("employee") Employee employee,BindingResult bindingResult, Model m) throws URISyntaxException {
		if(bindingResult.hasErrors()) {
			return "adminUpdate";
		}else {
			//employeeService.insertEmp(employee);
			employeeService.update(employee,employee.getEmpId());
			List<Employee> emp=employeeService.getAllEmp();
			m.addAttribute("emp", emp);
			return "homepage";
		}
	}
	//update based on employee id click id data will be redirect to adminupdate page	
	@GetMapping("/update/{empid}")
	public String updateEmployee(@PathVariable("empid") int empid,Model m) {
		Employee e=employeeService.getEmployee(empid);
		m.addAttribute("employee", e);
		return "adminUpdate";
	}
	//update based on username 
	@GetMapping("/updateByusername/{username}")
	public String updateEmployeeByUsername(@PathVariable("username") String username,Model m) {
		Employee e=employeeService.getEmp(username);
		m.addAttribute("employee", e);
		return "userUpdate";
	}
	//update based on userside after saving
	@PostMapping("/update")
	public String updateUser(@Valid @ModelAttribute("employee") Employee employee,BindingResult bindingResult, Model m) {
		if(bindingResult.hasErrors()) {
			return "userUpdate";
		}else {
			employeeService.update(employee,employee.getEmpId());
			Employee emp=employeeService.getEmp(employee.getCredential().getUserName());
			m.addAttribute("emp", emp);
			return "Userhome";
		}
	}
	@GetMapping("/delete/{empid}")
	public String deleteEmployee(@PathVariable("empid") int empid,Model m) {
		employeeService.deleteEmployee(empid);
		List<Employee> emp=employeeService.getAllEmp();
		m.addAttribute("emp", emp);
		return "homepage";
	}
	
	
}
