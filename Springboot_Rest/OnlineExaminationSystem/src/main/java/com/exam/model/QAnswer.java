package com.exam.model;

import java.util.List;

public class QAnswer {

	List<Questions> ques;

	public List<Questions> getQues() {
		return ques;
	}

	public void setQues(List<Questions> ques) {
		this.ques = ques;
	}

	public QAnswer(List<Questions> ques) {
		super();
		this.ques = ques;
	}

	public QAnswer() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
