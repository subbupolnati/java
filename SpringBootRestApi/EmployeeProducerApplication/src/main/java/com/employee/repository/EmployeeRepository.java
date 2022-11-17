package com.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.employee.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	@Query(value="select * from employee2 where  credential_user_name=?1", nativeQuery = true)
	public Employee findByCredential(String userName);
	public Employee findByEmpId(int empid);
}
