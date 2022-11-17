package com.jobseeker.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobseeker.model.ApplyJobs;
import com.jobseeker.model.Recuriter;
import com.jobseeker.repository.ApplyJobsRepo;
import com.jobseeker.repository.RecuriterRepo;

@Service
public class ApplyJobService {
	@Autowired
	ApplyJobsRepo ajRepo;
	public ApplyJobs addJobs(ApplyJobs aj) {
		return ajRepo.save(aj);
	}
	public List<ApplyJobs> searchjobsByRecuritrId(int id){
		List<ApplyJobs> newList=new ArrayList<ApplyJobs>();
		List<ApplyJobs> alist=this.getAllApplyJobs();
		for(ApplyJobs a:alist) {
			if(a.getRecuriterid().equals(id)) {
				newList.add(a);
			}
		}
		return newList;
	}
	public List<ApplyJobs> getAllApplyJobs(){
		return ajRepo.findAll();
	}
}
