package com.bloodbank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bloodbank.model.Patient;
import com.bloodbank.repository.PatientRepository;

@Service
public class PatientService {

	@Autowired
	private PatientRepository patientRepo;
	
	
	public Patient addPatient(Patient patient) {
		return patientRepo.save(patient);
	}
	public List<Patient> getAllpatients(){
		return patientRepo.findAll();
	}
	public Patient getPatient(int patientid) {
		return patientRepo.findById(patientid).get();
	}
	public Patient updatePatient(int patientid) {
		Optional<Patient> optional=patientRepo.findById(patientid);
		Patient patient=null;
		if(optional.isPresent()) {
			patient=optional.get();
			return patient;
		}
		return patient;
	}
	public void deletPatient(int patientid) {
		patientRepo.deleteById(patientid);
	}
	public List<Patient> searchPatient(int patientid) {
		return patientRepo.findByPatientid(patientid);
	}
	public Patient validate(String username,String password) {
		return patientRepo.findByPatientusernameAndPatientpassword(username, password);
	}
}
