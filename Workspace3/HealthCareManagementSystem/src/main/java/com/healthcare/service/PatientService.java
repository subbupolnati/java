package com.healthcare.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.model.Patient;
import com.healthcare.repository.PatientRepo;

@Service
public class PatientService {

	@Autowired
	PatientRepo patientRepo;
	
	public Patient addPatient(Patient patient) {
		return patientRepo.save(patient);
	}
	public List<Patient> getAllPatient(){
		return patientRepo.findAll();
	}
	public Patient getPatientByid(int patientid) {
		return patientRepo.findById(patientid).get();
	}
	public Patient uploadPatient(int patientid) {
		Optional<Patient> optional=patientRepo.findById(patientid);
		Patient patient=null;
		if(optional.isPresent()) {
			patient=optional.get();
			return patient;
		}
		return patient;
	}
	public void deletePatient(int patientid) {
		patientRepo.deleteById(patientid);
	}
}
