package com.example.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExampleController {

	@RequestMapping("/")
	public String home(Model m) {
		m.addAttribute("sid", "1001");
		m.addAttribute("sname","subbu");
		return "studentdetails";
	}
	@RequestMapping("/stud")
	public String studentDetails(Model m) {
		List<String> names=Arrays.asList("anikit","subbu");
		m.addAttribute("names", names);
		return "studentdetails";
	}
	@RequestMapping("/condt")
	public String conditionalHandler(Model m) {
		m.addAttribute("isActive",true);
		m.addAttribute("gender","F");
		return "studentdetails";
	}

	
}
