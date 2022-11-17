package com.tutorial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TutorialController {

	@RequestMapping("/")
	public String home() {
		return "home";
	}
	@RequestMapping("/java")
	public String javaHome() {
		return "java";
	}
	@RequestMapping("/whatisjava")
	public String whatisjava() {
		return "whatisjava";
	}
	@RequestMapping("/histroyofjava")
	public String histroyOfjava() {
		return "historyofjava";
	}
	@RequestMapping("/featuresofjava")
	public String featuresOfJava() {
		return "featuresofjava";
	}
	@RequestMapping("/jdkjvm")
	public String jdkAndJvm() {
		return "jdkjvm";
	}
	@RequestMapping("/javavariable")
	public String javaVariable() {
		return "javavariable";
	}
	@RequestMapping("/datatypes")
	public String dataTypes() {
		return "datatypes";
	}
	@RequestMapping("/keywords")
	public String keyWords() {
		return "keywords";
	}
}

