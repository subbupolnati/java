package com.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exam.model.Courses;
import com.exam.model.Questions;
import com.exam.repository.CoursesRepository;
import com.exam.service.CoursesService;

@Controller
public class CoursesController {

	@Autowired
	CoursesService coursesService;
	
	
	@RequestMapping("/course")
	public String coursePage(Model m) {
		Courses c=new Courses();
		List<Courses> listCourses=coursesService.getAllCourses();
		m.addAttribute("course", c);
		m.addAttribute("listCourses", listCourses);
		return "courses";
	}
	@RequestMapping("/coursesave")
	public String insertCourse(@ModelAttribute("course") Courses course, Model m) {
		Courses c=coursesService.addCourse(course);
		return "redirect:course";
	}
	@RequestMapping("/delete/{cName}")
	public String deleteCourse(String cName) {
		coursesService.deleteCourse(cName);
		return "redirect:course";
	}
}
