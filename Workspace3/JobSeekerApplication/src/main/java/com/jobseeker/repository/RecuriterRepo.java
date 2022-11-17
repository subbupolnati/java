package com.jobseeker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jobseeker.model.Recuriter;

@Repository
public interface RecuriterRepo extends JpaRepository<Recuriter, Integer>{

	public List<Recuriter> findByTechnology(String techonology);
	public Recuriter findByUsernameAndPassword(String username,String password);
}
