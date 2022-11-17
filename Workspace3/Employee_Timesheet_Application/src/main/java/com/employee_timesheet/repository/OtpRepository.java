package com.employee_timesheet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee_timesheet.model.Otp;
@Repository
public interface OtpRepository extends JpaRepository<Otp, Integer> {

}
