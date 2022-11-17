package com.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.college.model.Faculty;

@Repository
public interface FacultyRepsoitory extends JpaRepository<Faculty, Integer> {

}
