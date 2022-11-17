package com.aadhar.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aadhar.model.Aadhar;
import com.aadhar.repository.AadharRepository;


@Service
public class AadharService {

	@Autowired
	private AadharRepository aadharRepository;

	public AadharRepository getAadharRepository() {
		return aadharRepository;
	}

	public void setAadharRepository(AadharRepository aadharRepository) {
		this.aadharRepository = aadharRepository;
	}
	public Aadhar createAadhar(Aadhar aadhar) {
		  return aadharRepository.save(aadhar);
	}
	public List<Aadhar> getAllDetails(){
		return aadharRepository.findAll();
	}
	public Aadhar update(String aadharNumber) {
		Optional<Aadhar> optional = aadharRepository.findById(aadharNumber);
		Aadhar aadhar=null;
        if (optional.isPresent()) {
        	aadhar=optional.get();
            return aadharRepository.save(aadhar);
        }
        else
           //throw new RuntimeException("Employee not found for id : " + empid);
        	return aadhar;
	}

	public void delete(String aadharNumber) {
		aadharRepository.deleteById(aadharNumber);
	}
	
}
