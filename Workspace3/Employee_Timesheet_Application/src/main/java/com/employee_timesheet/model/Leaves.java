package com.employee_timesheet.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="leaves")
public class Leaves {

	@Id
	@GeneratedValue
	private int leaveId;
	private LocalDate date;
	private String leaveType;
	private int ptoHours;
	public int getLeaveId() {
		return leaveId;
	}
	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}
	public int getPtoHours() {
		return ptoHours;
	}
	public void setPtoHours(int ptoHours) {
		this.ptoHours = ptoHours;
	}
	@Override
	public String toString() {
		return "Leaves [leaveId=" + leaveId + ", date=" + date + ", leaveType=" + leaveType + ", ptoHours=" + ptoHours
				+ "]";
	}
	public Leaves(int leaveId, LocalDate date, String leaveType, int ptoHours) {
		super();
		this.leaveId = leaveId;
		this.date = date;
		this.leaveType = leaveType;
		this.ptoHours = ptoHours;
	}
	public Leaves() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
