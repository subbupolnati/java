package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class EmployeeController {
	@RequestMapping("/hai")
	public String hello() {
		return "hello";
	}
}
