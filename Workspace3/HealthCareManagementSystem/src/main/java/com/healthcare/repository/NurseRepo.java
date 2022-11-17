package com.healthcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.healthcare.model.Nurses;

@Repository
public interface NurseRepo extends JpaRepository<Nurses, Integer> {

}
