package com.healthcare.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.model.Nurses;
import com.healthcare.repository.NurseRepo;

@Service
public class NursesService {

	@Autowired
	NurseRepo nurseRepo;
	
	public Nurses addNurses(Nurses nurses) {
		return nurseRepo.save(nurses);
	}
	public List<Nurses> getAllNurses(){
		return nurseRepo.findAll();
	}
	public Nurses getNurseByid(int nurseid) {
		return nurseRepo.findById(nurseid).get();
	}
	public Nurses updateNurse(int nurseid) {
		Optional<Nurses> optional=nurseRepo.findById(nurseid);
		Nurses nurses=null;
		if(optional.isPresent()) {
			nurses=optional.get();
			return nurses;
		}
		return nurses;
	}
	public void deleteNurse(int nurseid) {
		nurseRepo.deleteById(nurseid);
	}
}
