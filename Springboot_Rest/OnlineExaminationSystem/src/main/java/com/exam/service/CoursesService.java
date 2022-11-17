package com.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.model.Courses;
import com.exam.repository.CoursesRepository;

@Service
public class CoursesService {

	@Autowired
	CoursesRepository courseRepoitory;
	
	public Courses addCourse(Courses course) {
		return courseRepoitory.save(course);
	}
	
	public List<Courses>getAllCourses(){
		return courseRepoitory.findAll();
	}
	public void deleteCourse(String cName) {
		courseRepoitory.deleteById(cName);
	}
}
