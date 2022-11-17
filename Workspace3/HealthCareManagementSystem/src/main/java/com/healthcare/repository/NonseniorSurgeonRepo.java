package com.healthcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.healthcare.model.NonSeniorSurgeon;

@Repository
public interface NonseniorSurgeonRepo extends JpaRepository<NonSeniorSurgeon,Integer>{

}
