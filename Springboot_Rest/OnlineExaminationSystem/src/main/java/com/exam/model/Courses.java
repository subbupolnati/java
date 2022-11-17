package com.exam.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Courses {
   @Id
   private String cName;
   private int tmarks;
   private String time;
public String getcName() {
	return cName;
}
public void setcName(String cName) {
	this.cName = cName;
}
public int getTmarks() {
	return tmarks;
}
public void setTmarks(int tmarks) {
	this.tmarks = tmarks;
}
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}
public Courses(String cName, int tmarks, String time) {
	super();
	this.cName = cName;
	this.tmarks = tmarks;
	this.time = time;
}
public Courses() {
	super();
	// TODO Auto-generated constructor stub
}

   
}
