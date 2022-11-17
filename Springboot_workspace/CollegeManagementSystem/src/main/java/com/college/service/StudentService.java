package com.college.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.college.exceptions.StudentNotFoundException;
import com.college.model.Student;
import com.college.repository.StudentRepository;



@Service
public class StudentService {

	@Autowired
	private StudentRepository sr;

	public StudentRepository getSr() {
		return sr;
	}

	public void setSr(StudentRepository sr) {
		this.sr = sr;
	}
	public Student addnewStudent(Student student) {
		return sr.save(student);
	}
	public List<Student> getAllStudentDetails(){
		return sr.findAll();
	}
	public void deleteStudent(int sid) {
		try {
			sr.deleteById(sid);
		}
		catch (Exception e) {
			throw new StudentNotFoundException("Student not found for id : " + sid);
		}
	}
	public Student update(Student student, int sid) {
		Optional<Student> optional = sr.findById(sid);
        if (optional.isPresent()) {
            student.setSid(sid);
            return sr.save(student);
        }
        else
            throw new StudentNotFoundException("Student not found for id : " + sid);
	}
	public Student getStudent(int sid) {
		Optional<Student> optional=sr.findById(sid);
		Student stud=null;
		if(optional.isPresent()) {
			stud=optional.get();
			return stud;
		}
		else
            throw new StudentNotFoundException("student not found for id : " +sid);
	}

	
	
	
}
