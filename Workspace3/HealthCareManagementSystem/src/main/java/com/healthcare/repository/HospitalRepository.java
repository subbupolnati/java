package com.healthcare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.healthcare.model.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Integer>{
	List<Hospital> findByName(String name);
}
