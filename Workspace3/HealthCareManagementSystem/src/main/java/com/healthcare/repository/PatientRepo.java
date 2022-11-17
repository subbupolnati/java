package com.healthcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.healthcare.model.Patient;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Integer>{

}
