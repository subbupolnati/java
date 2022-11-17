package com.jobseeker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jobseeker.model.JobSeeker;

@Repository
public interface JobSeekerRepo extends JpaRepository<JobSeeker, Integer> {

	public JobSeeker findByUsernameAndPassword(String username,String password);
}
