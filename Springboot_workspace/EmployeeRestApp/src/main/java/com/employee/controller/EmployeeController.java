package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.employee.model.Employee;
import com.employee.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService er;
	
	public EmployeeService getEr() {
		return er;
	}
	public void setEr(EmployeeService er) {
		this.er = er;
	}
	@GetMapping("/")
	public ModelAndView home(Model m) {
		ModelAndView mv=new ModelAndView();
		Employee e=new Employee();
		m.addAttribute("employee", e);
		mv.setViewName("home");
		return mv;
	}
	@PostMapping("/save")
	public  List<Employee> insertEmployee(@ModelAttribute("employee") Employee employee) {
		return er.getEmployeeDetails(employee);
	}
	/*@GetMapping("/employees")
	public List<Employee>getAllEmployee(){
		return er.getEmployeeDetails();
	}*/
	@GetMapping("/employee/{id}")
	public Employee getEmployeeById(@PathVariable int id) {
		return er.getEmployeeById(id);
	}
}
