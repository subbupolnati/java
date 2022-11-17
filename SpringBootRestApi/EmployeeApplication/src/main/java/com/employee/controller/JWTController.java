package com.employee.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.exception.EmployeeNotFoundException;
import com.employee.helper.JwtTokenUtil;
import com.employee.model.Credential;
import com.employee.model.Employee;
import com.employee.model.JwtResponse;
import com.employee.service.CredentialService;
import com.employee.service.EmployeeService;

@Controller
public class JWTController {

	@Autowired
	private CredentialService credentialService;
	
	@Autowired
	private JwtTokenUtil jwttokenutil;
	
	@Autowired 
	private AuthenticationManager mgr;
	
	@Autowired
	private EmployeeService employeeService;
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

	@PostMapping("/login1")
	public String generateToken(@ModelAttribute("credential") Credential credential,Model m,HttpSession session,HttpServletResponse response){
		System.out.println(credential.getUserName());
		try {
			this.mgr.authenticate(new UsernamePasswordAuthenticationToken(credential.getUserName(),credential.getPassword()));
			
		}catch(EmployeeNotFoundException ue)
		{
			m.addAttribute("msg","Invalid Details");
		}
		UserDetails userDetails=this.credentialService.loadUserByUsername(credential.getUserName());

		String token=this.jwttokenutil.generateToken(userDetails);
		System.out.println(token);
		new JwtResponse(token);
		token="Bearer "+token;
		System.out.println("after appending"+token);
		HttpHeaders headers = getHeaders();
        headers.set("Authorization", token);
		session.setAttribute("token",token);
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
	private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        return headers;
    }
}
	
