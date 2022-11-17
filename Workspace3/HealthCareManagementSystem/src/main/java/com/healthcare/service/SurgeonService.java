package com.healthcare.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.model.Surgeon;
import com.healthcare.repository.SurgeonRepo;

@Service
public class SurgeonService {

	@Autowired
	SurgeonRepo surgeonRepo;
	
	
	public Surgeon addSurgeon(Surgeon surgeon) {
		return surgeonRepo.save(surgeon);
	}
	public List<Surgeon> getAllSurgeons(){
		return surgeonRepo.findAll();
	}
	public Surgeon getSurgeonById(int surgeonid) {
		Optional<Surgeon> optional=surgeonRepo.findById(surgeonid);
		Surgeon surgeon=null;
		if(optional.isPresent()) {
			surgeon=optional.get();
		}
		return surgeon;
	}
	public Surgeon updateSurgeon(int surgeonid) {
		Optional<Surgeon> optional=surgeonRepo.findById(surgeonid);
		Surgeon surgeon=null;
		if(optional.isPresent()) {
			surgeon=optional.get();
		}
		return surgeon;
	}
	public void deleteSurgeon(int surgeonid) {
		surgeonRepo.deleteById(surgeonid);
	}
}
