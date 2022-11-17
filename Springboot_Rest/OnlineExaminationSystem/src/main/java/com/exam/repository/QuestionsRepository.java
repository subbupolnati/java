package com.exam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.model.Questions;


public interface QuestionsRepository extends JpaRepository<Questions, Integer> {

	List<Questions>findByCourseName(String courseName);
	public String findByCorrect(int questionNo);

}
