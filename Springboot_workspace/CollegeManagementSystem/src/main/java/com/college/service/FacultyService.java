package com.college.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.college.exceptions.CourseNotFoundException;
import com.college.model.Faculty;
import com.college.repository.FacultyRepsoitory;

@Service
public class FacultyService {

	@Autowired
	private FacultyRepsoitory fr;

	public FacultyRepsoitory getFr() {
		return fr;
	}

	public void setFr(FacultyRepsoitory fr) {
		this.fr = fr;
	}
	 
	public Faculty addNewFaculty(Faculty faculty) {
		return fr.save(faculty);
	}
	
	public List<Faculty> getAllFacuty(){
		return fr.findAll();
	}
	public void deleteFaculty(int fid) {
		try{
			fr.deleteById(fid);
		}
		catch(Exception e) {
			throw new CourseNotFoundException("Faculty not found for id : " + fid);
		}
	}

	public Faculty update(Faculty faculty, int fid) {
		Optional<Faculty> optional = fr.findById(fid);
        if (optional.isPresent()) {
            faculty.setFid(fid);;
            return fr.save(faculty);
        }
        else
            throw new CourseNotFoundException("Faculty not found for id : " + fid);
	}

	public Faculty getFaculty(int fid) {
		Optional<Faculty> optional = fr.findById(fid);
		Faculty f=null;
		if(optional.isPresent()) {
			f=optional.get();
			return f;
		}
        else
            throw new CourseNotFoundException("Faculty not found for id : " + fid);
	}
}
