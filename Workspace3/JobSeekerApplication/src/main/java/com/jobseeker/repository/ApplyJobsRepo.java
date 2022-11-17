package com.jobseeker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jobseeker.model.ApplyJobs;

@Repository
public interface ApplyJobsRepo extends JpaRepository<ApplyJobs, Integer>{
	//@Query("select applyingjobs from applyingjobs where recuriter_recuriterid=1?")
	public ApplyJobs findByRecuriterid(int recuriterid);

}
