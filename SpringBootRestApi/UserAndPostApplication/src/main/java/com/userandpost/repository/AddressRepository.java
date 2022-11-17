package com.userandpost.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.userandpost.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address,String> {

}
