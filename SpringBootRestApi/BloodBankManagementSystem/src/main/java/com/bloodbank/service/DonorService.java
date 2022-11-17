package com.bloodbank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bloodbank.model.Donor;
import com.bloodbank.repository.DonorRepository;

@Service
public class DonorService {

	@Autowired
	private DonorRepository donorRepo;
	
	public Donor addDonor(Donor donor) {
		return donorRepo.save(donor);
	}
	public List<Donor> getALLDonors(){
		return donorRepo.findAll();
	}
	public List<Donor> getDonor(int donorid) {
		return donorRepo.findByDonorid(donorid);
	}
	public Donor updateDonor(int donorid) {
		Optional<Donor> optional=donorRepo.findById(donorid);
		Donor donor=null;
		if(optional.isPresent()){
			donor=optional.get();
			return donor;
		}
		return donor;
	}
	public void deleteDonor(int donorid) {
		donorRepo.deleteById(donorid);
	}
	public Donor validate(String username,String password) {
		return donorRepo.findByDonorusernameAndDonorpassword(username, password);
	}
}
