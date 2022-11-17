package com.healthcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.model.NonSeniorSurgeon;
import com.healthcare.repository.NonseniorSurgeonRepo;

@Service
public class NonSeniorSurgeonService {

	@Autowired
	NonseniorSurgeonRepo nssRepo;
	
	public NonSeniorSurgeon addNonSeniorSurgeon(NonSeniorSurgeon nss) {
		return nssRepo.save(nss);
	}
}
