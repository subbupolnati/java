package com.college.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.college.model.Course;
import com.college.model.Faculty;
import com.college.model.Student;
import com.college.service.CourseService;
import com.college.service.FacultyService;
import com.college.service.StudentService;


@RestController
public class CollegeController {

	@Autowired
	private StudentService ss;
	
	@Autowired
	private CourseService cs;

	@Autowired
	private FacultyService fs;
	
	public FacultyService getFs() {
		return fs;
	}

	public void setFs(FacultyService fs) {
		this.fs = fs;
	}

	public StudentService getSs() {
		return ss;
	}

	public void setSs(StudentService ss) {
		this.ss = ss;
	}

	public CourseService getCs() {
		return cs;
	}

	public void setCs(CourseService cs) {
		this.cs = cs;
	}
	
	
	@PostMapping("/course")
	public ResponseEntity<Course> addNewCourse(@RequestBody Course course){
		Course c=cs.addNewCourse(course);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{cid}").buildAndExpand(c.getCid()).toUri();
		return ResponseEntity.created(location).build();
	}
	@GetMapping("/course")
	public List<Course> getAllCourseDetails(){
		return cs.getAllCourseDetails();
	}
	@GetMapping("/course/{cid}")
	public Course getCourse(@PathVariable("cid") int cid){
		return cs.getCourse(cid);
	}
	@PutMapping("/course/{cid}")
	public Course updateCourse(@RequestBody Course course,@PathVariable("cid") int cid) {
		return cs.update(course, cid);
	}
	@DeleteMapping("/course/{cid}")
	public void deleteCourse(@PathVariable("cid") int cid) {
		cs.deleteCourse(cid);
	}
	@GetMapping("/course/{cid}/student")
	public List<Student> getAllStudentByCourseId(@PathVariable("cid") int cid){
		return cs.getStudnetByCourseId(cid);
	}
	//Student Controller
	@PostMapping("/student")
	public ResponseEntity<Student> addNewStudent(@RequestBody Student student){
		Student s=ss.addnewStudent(student);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{sid}").buildAndExpand(s.getSid()).toUri();
		return ResponseEntity.created(location).build();
	}
	@GetMapping("/student")
	public List<Student> getAllStudentDetails(){
		return ss.getAllStudentDetails();
	}
	@GetMapping("/student/{sid}")
	public Student getStudentDetails(@PathVariable("sid") int sid) {
		return ss.getStudent(sid);
	}
	@PutMapping("/student/{sid}")
	public Student updateStudent(@RequestBody Student student,@PathVariable("sid") int sid) {
		return ss.update(student, sid);
	}
	@DeleteMapping("/student/{sid}")
	public void deleteStudent(@PathVariable("sid") int sid) {
		ss.deleteStudent(sid);
	}
	
	
	//Faculty Controller
	
	@PostMapping("/faculty")
	public ResponseEntity<Faculty> addNewFaculty(@RequestBody Faculty faculty){
		Faculty f=fs.addNewFaculty(faculty);
		URI loaction =ServletUriComponentsBuilder.fromCurrentRequest().path("/{fid}").buildAndExpand(f.getFid()).toUri();
		return ResponseEntity.created(loaction).build();
	}
	@GetMapping("/faculty")
	public List<Faculty> getAllFaculty(){
		return fs.getAllFacuty();
	}
	@GetMapping("/faculty/{fid}")
	public Faculty geFacultyDetails(@PathVariable("fid") int fid) {
		return fs.getFaculty(fid);
	}
	@PutMapping("/faculty/{fid}")
	public Faculty updateFaculty(@RequestBody Faculty faculty,@PathVariable("fid") int fid) {
		return fs.update(faculty, fid);
	}
	@DeleteMapping("/faculty/{fid}")
	public void deleteFaculty(@PathVariable("fid") int fid) {
		fs.deleteFaculty(fid);
	}
}
