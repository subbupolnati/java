package com.college.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.model.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Integer> {
	
}
