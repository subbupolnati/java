package com.airlinesproducer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airlinesproducer.model.Airlines;

@Repository
public interface AirlinesRepository extends JpaRepository<Airlines, Integer> {

}
