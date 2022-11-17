package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.student.model.Student;
import com.student.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@PostMapping("/student")
	public Student addNewStudent(@RequestBody Student student) {
		return studentService.insertNewStudent(student);
	}
	@GetMapping("/student")
	public List<Student> getAllStudent(){
		return studentService.getAllStudents();
	}
	
	@GetMapping("/student/{studentId}")
	public Student getStudentById(@PathVariable("studentId") int StudentId) {
		return studentService.getStudentById(StudentId);
	}
	@PutMapping("/student/{studentId}")
	public Student updateStudent(@RequestBody Student student,@PathVariable("studentId")int StudentId) {
		return studentService.updateStudent(student, StudentId);
	}
	@DeleteMapping("/student/{studentId}")
	public void deleteStudent(@PathVariable("studentId")int studentId) {
		studentService.deleteStudent(studentId);
	}
}
