package com.college.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.college.model.Course;
import com.college.model.Faculty;
import com.college.service.CourseService;
import com.college.service.FacultyService;

@RestController
public class CollegeController {
	@Autowired
	CourseService cs;
	@Autowired
	FacultyService fs;
	
	@PostMapping("/faculty")
	public Faculty saveFaculty(@RequestBody Faculty f) {
		return fs.addNewFaculty(f);
	}
	
	@PostMapping("/course")
	public Course saveCourse(@RequestBody Course c) {
		return cs.addNewCourse(c);
	}
	
	@GetMapping("/faculty")
	public List<Faculty> getAllFaculty() {
		return fs.getAllFaculty();
	}
	
	@GetMapping("/courses")
	public List<Course> getAllCourse() {
		return cs.getAllCourses();
	}
	
	@GetMapping("/faculty/{facultyId}/courses")
	public List<Course> getCoursesByFacultyId(@PathVariable("facultyId") int facultyId) {
		return cs.getCoursesByFacultyId(facultyId);
	}
	
	@GetMapping("/courses/{courseId}/faculty")
	public List<Faculty> getFacultyByCourseId(@PathVariable("courseId") int courseId) {
		return cs.getFacultyByCourseId(courseId);
	}
	
	@DeleteMapping("/faculty/{facultyId}")
	public Faculty deleteFaculty(@PathVariable("facultyId") int facultyId) {
		return cs.deleteFaculty(facultyId);
	}
	
	@DeleteMapping("/course/{courseId}")
	public Course deleteCourse(@PathVariable("courseId") int courseId) {
		return cs.deleteCourse(courseId);
	}
}
