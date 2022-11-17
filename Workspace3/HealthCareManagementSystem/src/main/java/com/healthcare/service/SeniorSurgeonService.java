package com.healthcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.model.SeniorSurgeon;
import com.healthcare.repository.SeniorSurgeonRepo;

@Service
public class SeniorSurgeonService {

	@Autowired
	SeniorSurgeonRepo ssRepo;
	
	public SeniorSurgeon addSeniorSurgeon(SeniorSurgeon ss) {
		return ssRepo.save(ss);
	}
}
