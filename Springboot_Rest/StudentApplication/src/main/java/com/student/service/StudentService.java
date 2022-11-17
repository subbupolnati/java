package com.student.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.student.model.Student;
import com.student.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	public Student insertNewStudent( Student student) {
		return studentRepository.save(student);
	}
	public List<Student> getAllStudents(){
		return studentRepository.findAll();
	}
	public Student getStudentById(int studentId) {
		Optional<Student> optional=studentRepository.findById(studentId);
		Student student=null;
		if(optional.isPresent()) {
			student=optional.get();
		}
		return student;
	}
	public Student updateStudent(Student student,int studentId) {
		Optional<Student> optional=studentRepository.findById(studentId);
		if(optional.isPresent()) {
			student.setStudentId(studentId);
		}
		return studentRepository.save(student);
	}
	public void deleteStudent(int studentId) {
		studentRepository.deleteById(studentId);
	}
}
