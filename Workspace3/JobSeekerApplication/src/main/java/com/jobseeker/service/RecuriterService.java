package com.jobseeker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobseeker.model.Recuriter;
import com.jobseeker.repository.RecuriterRepo;

@Service
public class RecuriterService {
	@Autowired
	RecuriterRepo rp;
	
	public Recuriter addRecuriter(Recuriter recuriter) {
		return rp.save(recuriter);
	}
	public List<Recuriter> getAllRecuriters(){
		return rp.findAll();
	}
	public Recuriter getRecuriterById(int id) {
		Optional<Recuriter> optional=rp.findById(id);
		Recuriter recuriter=null;
		if(optional.isPresent()) {
			recuriter=optional.get();
		}
		return recuriter;
	}
	public List<Recuriter> findByJob(String techonology){
		return rp.findByTechnology(techonology);
	}
	public Recuriter updateRecuriter(int id) {
		Optional<Recuriter> optional=rp.findById(id);
		Recuriter recuriter=null;
		if(optional.isPresent()) {
			recuriter=optional.get();
			rp.save(recuriter);
		}
		return recuriter;
	}
	public void deleteRecuriter(int id) {
		rp.deleteById(id);
	}
	public Recuriter validate(String username,String password) {
		return rp.findByUsernameAndPassword(username, password);
	}
}
