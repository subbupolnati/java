package com.bloodbank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bloodbank.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
	public Patient findByPatientusernameAndPatientpassword(String username,String password);
	public List<Patient> findByPatientid(int pid);
}
