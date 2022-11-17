package com.employee.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.employee.model.Employee;

public interface EmployeeRepository extends CassandraRepository<Employee, Integer> {

}
