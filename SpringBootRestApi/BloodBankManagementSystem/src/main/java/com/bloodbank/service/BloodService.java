package com.bloodbank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bloodbank.exception.BloodNotFoundException;
import com.bloodbank.model.Blood;
import com.bloodbank.repository.BloodRepository;

@Service
public class BloodService {

	@Autowired
	private BloodRepository bloodRepository;
	
	
	public Blood addBlood(Blood blood) {
		return bloodRepository.save(blood);
	}
	public List<Blood> getAllBlood(){
		return bloodRepository.findAll();
	}
	public List<Blood> searchBlood(String blood_group){
		try {
		return bloodRepository.findByBloodgroup(blood_group);
		}
		catch(BloodNotFoundException b) {
			throw new BloodNotFoundException("not found");
		}
	}
	public Blood updateBlood(int bloodid) {
		Optional<Blood> optional=bloodRepository.findById(bloodid);
		Blood blood=null;
		if(optional.isPresent()) {
			blood=optional.get();
			return blood;
		}
		return blood;
	}
	public void deleteBlood(int bloodid) {
		bloodRepository.deleteById(bloodid);
	}
}
