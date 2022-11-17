package com.college.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Course {
	@Id
	private int cid;
	private String cname;
	
	@ManyToMany(cascade = CascadeType.ALL)
	List<Faculty> faculty;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public List<Faculty> getFaculty() {
		return faculty;
	}

	public void setFaculty(List<Faculty> faculty) {
		this.faculty = faculty;
	}


	
}
