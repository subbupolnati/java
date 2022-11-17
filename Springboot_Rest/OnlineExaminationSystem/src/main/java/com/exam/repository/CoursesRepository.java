package com.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.model.Courses;

@Repository
public interface CoursesRepository extends JpaRepository<Courses,String>{

	public String findByTime(String cName);
	public int findByTmarks(String cName);
}
