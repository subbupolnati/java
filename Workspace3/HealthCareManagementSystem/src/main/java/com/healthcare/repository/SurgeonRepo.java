package com.healthcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.healthcare.model.Surgeon;

@Repository
public interface SurgeonRepo extends JpaRepository<Surgeon, Integer> {

}
