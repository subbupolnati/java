package com.college.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.exceptions.CourseNotFoundException;
import com.college.model.Course;
import com.college.model.Student;
import com.college.repository.CourseRepository;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository cr;

	public CourseRepository getCr() {
		return cr;
	}

	public void setCr(CourseRepository cr) {
		this.cr = cr;
	}
	public Course addNewCourse(Course course) {
		return cr.save(course);
	}
	public List<Course> getAllCourseDetails(){
		return cr.findAll();
	}
	public List<Student> getStudnetByCourseId(int cid){
		Optional<Course> c=cr.findById(cid);
		if(!c.isPresent())
			throw new CourseNotFoundException("Course id is not found"+cid);
		return c.get().getStudent();
	}

	public void deleteCourse(int cid) {
		try{
			cr.deleteById(cid);
		}
		catch(Exception e) {
			throw new CourseNotFoundException("Course not found for id : " + cid);
		}
	}

	public Course update(Course course, int cid) {
		Optional<Course> optional = cr.findById(cid);
        if (optional.isPresent()) {
            course.setCid(cid);;
            return cr.save(course);
        }
        else
            throw new CourseNotFoundException("Course not found for id : " + cid);
	}

	public Course getCourse(int cid) {
		Optional<Course> optional = cr.findById(cid);
		Course c=null;
		if(optional.isPresent()) {
			c=optional.get();
			return c;
		}
        else
            throw new CourseNotFoundException("course not found for id : " + cid);
	}
}
