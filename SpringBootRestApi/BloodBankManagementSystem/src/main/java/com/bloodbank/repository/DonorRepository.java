package com.bloodbank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bloodbank.model.Donor;

@Repository
public interface DonorRepository extends JpaRepository<Donor, Integer> {
	public Donor findByDonorusernameAndDonorpassword(String username,String password);
	public List<Donor> findByDonorid(int donorid);
}
