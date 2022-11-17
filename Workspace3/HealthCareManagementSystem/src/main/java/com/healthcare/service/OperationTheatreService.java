package com.healthcare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.model.OperationTheatre;
import com.healthcare.repository.OperationTheatreRepo;

@Service
public class OperationTheatreService {

	@Autowired
	OperationTheatreRepo otRepo;
	
	public OperationTheatre addOpertionTheatre(OperationTheatre ot) {
		return otRepo.save(ot);
	}
	public List<OperationTheatre> getListTheatre(){
		return otRepo.findAll();
	}
	public OperationTheatre getById(int operationid) {
		return otRepo.findById(operationid).get();
	}
	
	public void deleteOperationTheatre(int operationid) {
		otRepo.deleteById(operationid);
	}
}
