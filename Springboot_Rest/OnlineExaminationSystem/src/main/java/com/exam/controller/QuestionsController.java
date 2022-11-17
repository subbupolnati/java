package com.exam.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.exam.model.Courses;
import com.exam.model.Questions;
import com.exam.service.CoursesService;
import com.exam.service.QuestionsService;

@Controller
public class QuestionsController {

	@Autowired
	QuestionsService quesService;
	@Autowired
	CoursesService courseService;
	@RequestMapping("/addQues")
	public String addJava(Model m) {
		Questions questions=new Questions();
		List<Courses> clist= courseService.getAllCourses();
		m.addAttribute("questions",questions);
		m.addAttribute("clist", clist);
		return "addques";
	}
	@RequestMapping("/save")
	public String insertQuestion(@ModelAttribute("questions") Questions ques, Model m) {
		Questions q=quesService.addQuestion(ques);
		return "homepage";
	}
	@RequestMapping("/questions") 
	public String home(Model m,@RequestParam("courseName") String courseName) {
		List<Questions>ques=quesService.getQuestions(courseName);
		m.addAttribute("ques",ques); 
		return"showAll";
	}
	
	/*
	 * @RequestMapping("/resultSubmit") public String submit(Model
	 * m,HttpServletRequest request) { String
	 * []question_Ids=request.getParameterValues("quesId"); //String
	 * answers[]=request.getParameterValues("ans"); for(String quesId:question_Ids)
	 * { System.out.println(quesId); } //System.out.println(quesId);
	 * //System.out.println(ans); return "result";
	 * 
	 * }
	 */}
