package com.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.model.Exams;

@Repository
public interface ExamsRepository extends JpaRepository<Exams,Integer> {
	public int findFirstByOrderByExamIdDesc();
}
