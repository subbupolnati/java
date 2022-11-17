package com.employee_timesheet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee_timesheet.model.Manager;
@Repository
public interface ManagerRepository extends JpaRepository<Manager, Integer> {

}
