package com.userandpost.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userandpost.model.Company;

public interface CompanyRepository extends JpaRepository<Company, String> {

}
