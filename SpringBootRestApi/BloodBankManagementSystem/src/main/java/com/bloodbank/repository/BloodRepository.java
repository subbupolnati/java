package com.bloodbank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bloodbank.model.Blood;
@Repository
public interface BloodRepository extends JpaRepository<Blood, Integer> {
	List<Blood> findByBloodgroup(String bloodgroup);
}
