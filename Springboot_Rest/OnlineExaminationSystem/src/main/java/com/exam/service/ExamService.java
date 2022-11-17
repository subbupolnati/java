package com.exam.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.model.Exams;
import com.exam.repository.CoursesRepository;
import com.exam.repository.ExamsRepository;

@Service
public class ExamService {

	@Autowired
	ExamsRepository examRepository;
	@Autowired
	CoursesRepository coursesRepository;
	
	public int startExam(String cName) {
		int examId=0;
		Exams exam=new Exams();
		exam.setcName(cName);
		exam.setDate(getFormatedDate(LocalDate.now().toString()));
		exam.setStartTime(LocalTime.now().toString());
		exam.setExamTime(getCourseTimeByName(cName));
		exam.setTmarks(getTotalMarksByName(cName));
		examRepository.save(exam);
		examId=examRepository.findFirstByOrderByExamIdDesc();
		return examId;
	}
	private  String getFormatedDate(String date){
        LocalDate localDate=LocalDate.parse(date);
        return localDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }
	public String getCourseTimeByName(String cName){
	     String c=null;
	     return c=coursesRepository.findByTime(cName);
	  }
	public int getTotalMarksByName(String cName){
	     int marks=0;
	     return marks=coursesRepository.findByTmarks(cName);
	}
	public int getLastExamId(){
        int id=0;
        return id=examRepository.findFirstByOrderByExamIdDesc();
	}
        
        
}
        
