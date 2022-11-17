package com.exam.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.exam.model.Answers;
import com.exam.model.Questions;
import com.exam.service.ExamService;
import com.exam.service.QuestionsService;

@Controller
public class ExamController {

	@Autowired
	QuestionsService quesService;
	@Autowired
	ExamService examService;
	
	List<Questions> qlist;
	long score;
	@RequestMapping("/examquestion") 
	public String userExam(Model m,@RequestParam("courseName") String courseName) {
		qlist=quesService.getQuestions(courseName);
		Answers answer=new Answers(qlist);
		m.addAttribute("answer",answer);
		m.addAttribute("courseName", courseName);
		System.out.println(courseName);
		System.out.println(answer.toString());
		return"Test";
	}
	@RequestMapping(value="/resultSubmit",method = RequestMethod.POST)
	public String submit(@ModelAttribute Answers ans, Model m) {
		List<Questions> answeredList = ans.getQuestions();
		Optional<Long> score = Optional.ofNullable(qlist.stream().filter(answeredList::contains).count());
		m.addAttribute("courseName", ans.getQuestions().get(0).getCourseName());
		m.addAttribute("score", score.get());
		m.addAttribute("total", answeredList.size());
		return "result";
	}
}
