package com.healthcare.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.model.Hospital;
import com.healthcare.repository.HospitalRepository;

@Service
public class HosptialService {

	@Autowired
	HospitalRepository hospitalRepository;
	
	public Hospital addHospital(Hospital hospital) {
		return hospitalRepository.save(hospital);
	}
	public Hospital getHospitalById(int hospitalid) {
		Optional<Hospital> optional=hospitalRepository.findById(hospitalid);
		Hospital hospital=null;
		if(optional.isPresent()) {
			hospital=optional.get();
		}
		return hospital;
	}
	public List<Hospital> getAllHospitals(){
		return hospitalRepository.findAll();
	}
	public List<Hospital> searchHospital(String name){
		return hospitalRepository.findByName(name);
	}
}
