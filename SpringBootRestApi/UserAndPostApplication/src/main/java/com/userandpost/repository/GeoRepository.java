package com.userandpost.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.userandpost.model.Geo;
@Repository
public interface GeoRepository extends JpaRepository<Geo,String> {

}
