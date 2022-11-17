package com.jobseeker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobseeker.model.JobSeeker;
import com.jobseeker.repository.JobSeekerRepo;

@Service
public class JobSeekerService {

	@Autowired
	JobSeekerRepo jsRepo;
	
	public JobSeeker addJobSeeker(JobSeeker jobSeeker) {
		return jsRepo.save(jobSeeker);
	}
	public List<JobSeeker> getAllJobSeeker(){
		return jsRepo.findAll();
	}
	public JobSeeker findByJobSeeker(int id) {
		Optional<JobSeeker> optional=jsRepo.findById(id);
		JobSeeker jobSeeker=null;
		if(optional.isPresent()) {
			jobSeeker=optional.get();
		}
		return jobSeeker;
	}
	public JobSeeker updateJobSeeker(int id) {
		Optional<JobSeeker> optional=jsRepo.findById(id);
		JobSeeker jobSeeker=null;
		if(optional.isPresent()) {
			jobSeeker=optional.get();
			jsRepo.save(jobSeeker);
		}
		return jobSeeker;
	}
	public void deleteJobSeeker(int id) {
		jsRepo.deleteById(id);
	}
	public JobSeeker validate(String username,String password) {
		return jsRepo.findByUsernameAndPassword(username, password);
	}
}
