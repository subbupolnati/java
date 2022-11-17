package com.healthcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.healthcare.model.SeniorSurgeon;

@Repository
public interface SeniorSurgeonRepo extends JpaRepository<SeniorSurgeon,Integer>{

}
