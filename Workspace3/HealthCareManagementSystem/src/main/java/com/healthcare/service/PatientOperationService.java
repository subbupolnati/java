package com.healthcare.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.model.PatientOperation;
import com.healthcare.repository.PatientOperationRepo;

@Service
public class PatientOperationService {

	@Autowired
	PatientOperationRepo poRepo;
	
	public PatientOperation addOperation(PatientOperation po) {
		return poRepo.save(po);
	}
	public List<PatientOperation> getAllDetials(){
		return poRepo.findAll();
	}
	public PatientOperation getOpertionDetailsById(int operationid) {
		return poRepo.findById(operationid).get();
	}
	public PatientOperation updateOpertion(int operationid) {
		Optional<PatientOperation>optional=poRepo.findById(operationid);
		PatientOperation po=null;
		if(optional.isPresent()) {
			po=optional.get();
			return po;
		}
		return po;
	}
	public void deleteOperation(int operationid) {
		poRepo.deleteById(operationid);
	}
}
