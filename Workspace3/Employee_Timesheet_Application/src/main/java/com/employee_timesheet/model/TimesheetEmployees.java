package com.employee_timesheet.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="timesheet_employee")
public class TimesheetEmployees {

	@Id
	@GeneratedValue
	private int timesheetEmployeeId;
	private LocalDate date;
	private String month;
	private int year;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private Users user;
	@OneToOne(cascade =CascadeType.ALL)
	@JoinColumn(name="timesheet_id")
	private Timesheet timesheet;
	public int getTimesheetEmployeeId() {
		return timesheetEmployeeId;
	}
	public void setTimesheetEmployeeId(int timesheetEmployeeId) {
		this.timesheetEmployeeId = timesheetEmployeeId;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public Timesheet getTimesheet() {
		return timesheet;
	}
	public void setTimesheet(Timesheet timesheet) {
		this.timesheet = timesheet;
	}
	@Override
	public String toString() {
		return "TimesheetEmployees [timesheetEmployeeId=" + timesheetEmployeeId + ", date=" + date + ", month=" + month
				+ ", year=" + year + ", user=" + user + ", timesheet=" + timesheet + "]";
	}
	public TimesheetEmployees(int timesheetEmployeeId, LocalDate date, String month, int year, Users user,
			Timesheet timesheet) {
		super();
		this.timesheetEmployeeId = timesheetEmployeeId;
		this.date = date;
		this.month = month;
		this.year = year;
		this.user = user;
		this.timesheet = timesheet;
	}
	public TimesheetEmployees() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
