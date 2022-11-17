package com.sample.reposiroty;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	Optional<Employee> findByUsername(String username);
}
