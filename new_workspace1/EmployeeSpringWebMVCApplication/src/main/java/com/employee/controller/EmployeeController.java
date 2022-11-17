package com.employee.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.employee.Employee;

public class EmployeeController  implements Controller{

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ModelAndView mv=new ModelAndView();
		Employee e=new Employee();
		e.setEmpid(Integer.parseInt(request.getParameter("empid")));
		e.setEname(request.getParameter("ename"));
		e.setSalary(Integer.parseInt(request.getParameter("salary")));
		mv.addObject("empid",e.getEmpid());
		mv.addObject("ename",e.getEname());
		mv.addObject("salary",e.getSalary());
		mv.setViewName("View");
		return mv;
	}

}
