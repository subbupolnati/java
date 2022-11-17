package com.exam.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.model.Questions;
import com.exam.repository.QuestionsRepository;
@Service
public class QuestionsService {

	@Autowired
	QuestionsRepository quesRepository;
	
	
	public Questions addQuestion(Questions ques) {
		return quesRepository.save(ques);
	}
	public Questions  update(int questionNo) {
		Optional<Questions > optional = quesRepository.findById(questionNo);
		Questions  q= null;
        if (optional.isPresent())
            q = optional.get();
        return q;
	}
	public void delete(int questionNo) {
		quesRepository.deleteById(questionNo);
	}
	public List<Questions> getQuestions(String courseName){
	List<Questions>qlist=quesRepository.findByCourseName(courseName);
	return qlist; 
	}
	 
	/*
	 * public int findAnswerIdCorrect(int questionNo) { Questions
	 * ques=quesRepository.findById(questionNo).get(); i
	 * 
	 * } }
	 */
}
