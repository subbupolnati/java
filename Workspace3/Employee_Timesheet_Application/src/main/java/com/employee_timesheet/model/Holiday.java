package com.employee_timesheet.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="holidays")
public class Holiday {
	@Id
	@GeneratedValue
	private int holidayId;
	private LocalDate date;
	private String month;
	private String reason;
	private int year;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="client_id")
	private Client clientId;
	public int getHolidayId() {
		return holidayId;
	}
	public void setHolidayId(int holidayId) {
		this.holidayId = holidayId;
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
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public Client getClientId() {
		return clientId;
	}
	public void setClientId(Client clientId) {
		this.clientId = clientId;
	}
	@Override
	public String toString() {
		return "Holiday [holidayId=" + holidayId + ", date=" + date + ", month=" + month + ", reason=" + reason
				+ ", year=" + year + ", clientId=" + clientId + "]";
	}
	public Holiday() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Holiday(int holidayId, LocalDate date, String month, String reason, int year, Client clientId) {
		super();
		this.holidayId = holidayId;
		this.date = date;
		this.month = month;
		this.reason = reason;
		this.year = year;
		this.clientId = clientId;
	}
	
}
