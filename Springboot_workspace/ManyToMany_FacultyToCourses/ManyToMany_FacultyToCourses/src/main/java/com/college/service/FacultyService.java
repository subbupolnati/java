package com.college.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.exceptions.CourseNotFoundException;
import com.college.exceptions.FacultyNotFoundException;
import com.college.model.Course;
import com.college.model.Faculty;
import com.college.repo.FacultyRepository;

@Service
public class FacultyService {
	
	@Autowired
	FacultyRepository fr;
	public FacultyRepository getFr() {
		return fr;
	}
	public void setFr(FacultyRepository fr) {
		this.fr = fr;
	}
	public Faculty addNewFaculty(Faculty faculty) {
		return fr.save(faculty);
	}
	public List<Faculty> getAllFaculty() {
		return fr.findAll();
	}
	public void deleteFaculty(int fid) {
		try{
			fr.deleteById(fid);
		}
		catch(Exception e) {
			throw new FacultyNotFoundException("Fuculty not found for id : " + fid);
		}
	}

	public Faculty update(Faculty faculty, int fid) {
		Optional<Faculty> optional = fr.findById(fid);
        if (optional.isPresent()) {
            faculty.setFid(fid);;
            return fr.save(faculty);
        }
        else
            throw new FacultyNotFoundException("Faculty not found for id : " + fid);
	}

	public Faculty getFaculty(int fid) {
		Optional<Faculty> optional = fr.findById(fid);
		Faculty f=null;
		if(optional.isPresent()) {
			f=optional.get();
			return f;
		}
        else
            throw new FacultyNotFoundException("faculty not found for id : " + fid);
	}
	

}
