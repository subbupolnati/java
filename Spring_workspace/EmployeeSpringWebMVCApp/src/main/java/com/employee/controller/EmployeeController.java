package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.employee.dao.EmployeeDAO;
import com.employee.model.Employee;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeDAO edao;
	 
	@RequestMapping("/emp_register")
	public String addEmployee(@RequestParam("empid") int empid,@RequestParam("ename") String ename,@RequestParam("salary") int salary,@RequestParam("desig")String desig) {
		Employee e=new Employee();
		e.setEmpid(empid);
		e.setEname(ename);
		e.setSalary(salary);
		e.setDesignation(desig);
		edao.saveEmployee(e);
		return "index.jsp";
	}
	@RequestMapping("/emp_update")
	public String updateEmployee(@RequestParam("empid") int empid,@RequestParam("ename") String ename,@RequestParam("salary") int salary,@RequestParam("desig")String desig) {
		Employee e=new Employee();
		e.setEmpid(empid);
		e.setEname(ename);
		e.setSalary(salary);
		e.setDesignation(desig);
		edao.updateEmploye(e);
		return "index.jsp";
	}
	@RequestMapping("/emp_delete")
	public String deleteEmployee(@RequestParam("empid") int empid) {
		Employee e=new Employee();
		e.setEmpid(empid);
		edao.deleteEmploye(e);
		return "index.jsp";
	}
	@RequestMapping("/emp_selected")
	public ModelAndView selectedEmployee (@RequestParam("empid") int empid) {
		ModelAndView mv=new ModelAndView();
		Employee e=new Employee();
		e.setEmpid(empid);
		List<Employee>se=edao.seletedEmploye(e);
		mv.addObject("emp",se);
		mv.setViewName("ViewAllEmp.jsp");
		return mv;
		
	}
	@RequestMapping("/emp_all")
	public ModelAndView allEmployee() {
		ModelAndView mv=new ModelAndView();
		List<Employee>emp=edao.getDetails();
		mv.addObject("emp",emp);  
       mv.setViewName("ViewAllEmp.jsp");
       return mv;
		
	}
}
