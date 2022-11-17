package com.aadhar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aadhar.model.Aadhar;

@Repository
public interface AadharRepository extends JpaRepository<Aadhar,String> {

}
