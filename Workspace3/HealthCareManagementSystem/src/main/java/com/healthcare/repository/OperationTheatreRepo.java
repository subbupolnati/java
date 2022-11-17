package com.healthcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.healthcare.model.OperationTheatre;

@Repository
public interface OperationTheatreRepo extends JpaRepository<OperationTheatre, Integer>{

}
