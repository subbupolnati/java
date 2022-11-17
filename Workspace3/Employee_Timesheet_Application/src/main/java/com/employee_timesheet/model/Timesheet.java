package com.employee_timesheet.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="timesheet")
public class Timesheet {
	@Id
	@GeneratedValue
	private int timesheetId;
	private LocalDate date;
	private String comment;
	private boolean reSubmit;
	private String status;
	private int workingHours;
	@OneToOne(optional = false)
	@JoinColumn(name = "leave_id", referencedColumnName = "leaveId")
	private Leaves leave;
	@OneToOne(optional = false)
	@JoinColumn(name="holiday_id",referencedColumnName = "holidayId")
	private Holiday holiday;
	public int getTimesheetId() {
		return timesheetId;
	}
	public void setTimesheetId(int timesheetId) {
		this.timesheetId = timesheetId;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public boolean isReSubmit() {
		return reSubmit;
	}
	public void setReSubmit(boolean reSubmit) {
		this.reSubmit = reSubmit;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getWorkingHours() {
		return workingHours;
	}
	public void setWorkingHours(int workingHours) {
		this.workingHours = workingHours;
	}
	public Leaves getLeave() {
		return leave;
	}
	public void setLeave(Leaves leave) {
		this.leave = leave;
	}
	public Holiday getHoliday() {
		return holiday;
	}
	public void setHoliday(Holiday holiday) {
		this.holiday = holiday;
	}
	@Override
	public String toString() {
		return "Timesheet [timesheetId=" + timesheetId + ", date=" + date + ", comment=" + comment + ", reSubmit="
				+ reSubmit + ", status=" + status + ", workingHours=" + workingHours + ", leave=" + leave + ", holiday="
				+ holiday + "]";
	}
	public Timesheet(int timesheetId, LocalDate date, String comment, boolean reSubmit, String status, int workingHours,
			Leaves leave, Holiday holiday) {
		super();
		this.timesheetId = timesheetId;
		this.date = date;
		this.comment = comment;
		this.reSubmit = reSubmit;
		this.status = status;
		this.workingHours = workingHours;
		this.leave = leave;
		this.holiday = holiday;
	}
	public Timesheet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
