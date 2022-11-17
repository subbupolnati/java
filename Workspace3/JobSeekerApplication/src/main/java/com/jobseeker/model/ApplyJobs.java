package com.jobseeker.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="applyingjobs")
public class ApplyJobs {
	@Id
	private int applyingid;
	@OneToOne(cascade = CascadeType.ALL)
	private Recuriter recuriterid;
	@OneToOne(cascade = CascadeType.ALL)
	private JobSeeker jobseekerid;
	public int getApplyingid() {
		return applyingid;
	}
	public void setApplyingid(int applyingid) {
		this.applyingid = applyingid;
	}
	public Recuriter getRecuriterid() {
		return recuriterid;
	}
	public void setRecuriterid(Recuriter recuriterid) {
		this.recuriterid = recuriterid;
	}
	public JobSeeker getJobseekerid() {
		return jobseekerid;
	}
	public void setJobseekerid(JobSeeker jobseekerid) {
		this.jobseekerid = jobseekerid;
	}
	
	
}
