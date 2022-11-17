package com.calculator.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {

	@RequestMapping("/calc")
	public ModelAndView handleRequest(HttpServletRequest req,HttpServletResponse res) {
		ModelAndView mv=new ModelAndView();
		int n1=Integer.parseInt(req.getParameter("t1"));
		int n2=Integer.parseInt(req.getParameter("t2"));
		
		if("ADD".equals(req.getParameter("add"))) {
			mv.addObject("res",n1+n2);
			//mv.setViewName("result.jsp");
		}
		else if("SUB".equals(req.getParameter("sub"))) {
			mv.addObject("res",n1-n2);
			//mv.setViewName("result.jsp");
		}
		else if("MUL".equals(req.getParameter("mul"))) {
			mv.addObject("res",n1*n2);
			//mv.setViewName("result.jsp");
		}
		else {
			mv.addObject("res",n1/n2);
			//mv.setViewName("result.jsp");
		}
		mv.setViewName("result.jsp");
		return mv;
	}
}
