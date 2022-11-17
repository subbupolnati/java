package com.employee.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import com.employee.exception.EmployeeNotFoundException;
import com.employee.helper.JwtTokenUtil;
import com.employee.model.Credential;
import com.employee.model.Employee;
import com.employee.model.JwtResponse;
import com.employee.service.CredentialService;
import com.employee.service.EmployeeService;

@Controller
//This is a employee Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;//injecting Employee Service dependenecy
	@Autowired
	private CredentialService credentialService;
	
	@Autowired
	private JwtTokenUtil jwttokenutil;
	
	@Autowired 
	private AuthenticationManager mgr;
	//Getter and setter methods
	public CredentialService getCredentialService() {
		return credentialService;
	}

	public void setCredentialService(CredentialService credentialService) {
		this.credentialService = credentialService;
	}

	public JwtTokenUtil getJwttokenutil() {
		return jwttokenutil;
	}

	public void setJwttokenutil(JwtTokenUtil jwttokenutil) {
		this.jwttokenutil = jwttokenutil;
	}

	public AuthenticationManager getMgr() {
		return mgr;
	}

	public void setMgr(AuthenticationManager mgr) {
		this.mgr = mgr;
	}

	public EmployeeService getEmployeeService() {
		return employeeService;
	}
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	static String token;
	
	@PostMapping("/login")
	public String generateToken(@ModelAttribute("credential") Credential credential,Model m,HttpSession session,HttpServletResponse response){
		System.out.println(credential.getUserName());
		try {
			this.mgr.authenticate(new UsernamePasswordAuthenticationToken(credential.getUserName(),credential.getPassword()));
			
		}catch(EmployeeNotFoundException ue)
		{
			m.addAttribute("msg","Invalid Details");
		}
		UserDetails userDetails=this.credentialService.loadUserByUsername(credential.getUserName());

		token=this.jwttokenutil.generateToken(userDetails);
		System.out.println(token);
		new JwtResponse(token);
		System.out.println("after appending"+token);
		//HttpHeaders headers = getHeaders();
		response.addHeader("Authorization",token);
		//session.setAttribute("token",token);
		session.setAttribute("name",credential.getUserName());
		session.setAttribute("role", credential.getRole());
		if(credential.getRole().equalsIgnoreCase("ROLE_Admin")){
			List<Employee> emp=employeeService.getAllEmp();
			m.addAttribute("emp", emp);
			return "homepage";
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
	
	//THis Url is navigate to user save page
	@PostMapping("/employee/employeesave")
	public String insertUser(@Valid @ModelAttribute("employee") Employee employee,BindingResult bindingResult, Model m) {
		if(bindingResult.hasErrors()) {
			return "employeeRegister";
		}else {
			
			m.addAttribute("emp", employeeService.insertEmployee(employee));
			return "Userhome";
		}
	}
	//admin update admin side
	@PostMapping("/employee/adminupdate")
	public String updateAdmin(@Valid @ModelAttribute("employee") Employee employee,BindingResult bindingResult, Model m) {
		if(bindingResult.hasErrors()) {
			return "adminUpdate";
		}else {
			employeeService.insertEmployee(employee);
			List<Employee> emp=employeeService.getAllEmp();
			m.addAttribute("emp", emp);
			return "homepage";
		}
	}
	//update based on employee id	
	@GetMapping("/employee/update/{empid}")
	public String updateEmployee(@PathVariable("empid") int empid,Model m) {
		Employee e=employeeService.update(empid);
		m.addAttribute("employee", e);
		return "adminUpdate";
	}
	//update based on username 
	@GetMapping("/employee/updateByusername/{username}")
	public String updateEmployeeByUsername(@PathVariable("username") String username,Model m) {
		Employee e=employeeService.updateByUsername(username);
		m.addAttribute("employee", e);
		return "userUpdate";
	}
	//update based on userside after saving
	@PostMapping("/employee/userupdate")
	public String updateUser(@Valid @ModelAttribute("employee") Employee employee,BindingResult bindingResult, Model m) {
		if(bindingResult.hasErrors()) {
			return "userUpdate";
		}else {
			employeeService.insertEmployee(employee);
			Employee emp=employeeService.getEmp(employee.getCredential().getUserName());
			m.addAttribute("emp", emp);
			return "Userhome";
		}
	}
	
	private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        System.out.println("token "+token);
        headers.set("Authorization", token);
        return headers;
    }
}
