package com.exam.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
public class Answers {
	
   List<Questions> questions;

public List<Questions> getQuestions() {
	return questions;
}

public void setQuestions(List<Questions> questions) {
	this.questions = questions;
}

public Answers() {
	super();
	// TODO Auto-generated constructor stub
}

public Answers(List<Questions> questions) {
	super();
	this.questions = questions;
}

@Override
public String toString() {
	return "Answers [questions=" + questions + "]";
}
    
}
