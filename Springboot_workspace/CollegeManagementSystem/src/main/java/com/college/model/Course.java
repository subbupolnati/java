package com.college.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="course")
public class Course {

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private int cid;
	private String cname;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "course")
	@JsonBackReference
	private List<Student> student;
	
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Faculty> faculty;
	
	public List<Faculty> getFaculty() {
		return faculty;
	}
	public void setFaculty(List<Faculty> faculty) {
		this.faculty = faculty;
	}
	public List<Student> getStudent() {
		return student;
	}
	public void setStudent(List<Student> student) {
		this.student = student;
	}
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
	
}
