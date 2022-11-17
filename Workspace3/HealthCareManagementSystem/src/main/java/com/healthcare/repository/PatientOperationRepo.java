package com.healthcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.healthcare.model.PatientOperation;

@Repository
public interface PatientOperationRepo extends JpaRepository<PatientOperation, Integer>{

}
