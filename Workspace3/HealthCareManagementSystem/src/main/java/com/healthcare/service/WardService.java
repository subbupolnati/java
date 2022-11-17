package com.healthcare.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.model.Ward;
import com.healthcare.repository.WardRepo;

@Service
public class WardService {

	@Autowired
	WardRepo wardRepo;
	
	public Ward addWard(Ward ward) {
		return wardRepo.save(ward);
	}
	public List<Ward> getAllWard(){
		return wardRepo.findAll();
	}
	public Ward getWardById(int wardid) {
		Optional<Ward> optional=wardRepo.findById(wardid);
		Ward ward=null;
		if(optional.isPresent()) {
			ward=optional.get();
			return ward;
		}
		return ward;
	}
	public Ward updateWard(int wardid) {
		Optional<Ward> optional=wardRepo.findById(wardid);
		Ward ward=null;
		if(optional.isPresent()) {
			ward=optional.get();
			return ward;
		}
		return ward;
	}
	public void deleteWard(int wardid) {
		wardRepo.deleteById(wardid);
	}
}
