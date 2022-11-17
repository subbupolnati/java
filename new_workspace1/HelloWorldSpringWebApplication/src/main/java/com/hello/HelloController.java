package com.hello;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController  implements Controller{
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ModelAndView mv=new ModelAndView();
		mv.addObject("msg","Enfec Solutions Pvt Limited");
		mv.setViewName("Hello");
		return mv;
		}

}
