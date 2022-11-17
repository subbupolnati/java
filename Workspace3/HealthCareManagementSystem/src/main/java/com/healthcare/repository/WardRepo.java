package com.healthcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.healthcare.model.Ward;

@Repository
public interface WardRepo extends JpaRepository<Ward, Integer>{

}
