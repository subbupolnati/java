package com.employee_timesheet.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="client")
//This This Model class encapsulates client data fields
public class Client {

	@Id//this annotation used to generate primary key
	@GeneratedValue//this annotation used to automatically generated value
	private int clientId;
	private boolean active;
	private String address;
	private String clientName;
	private String contactNo;
	private String createdBy;
	private LocalDate createdDate;
	private String email;
	private String lastModifiedBy;
	private LocalDate lastModifiedDate;
	
	//getter and setter
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public LocalDate getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLastModifiedBy() {
		return lastModifiedBy;
	}
	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}
	public LocalDate getLastModifiedDate() {
		return lastModifiedDate;
	}
	public void setLastModifiedDate(LocalDate lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", active=" + active + ", address=" + address + ", clientName="
				+ clientName + ", contactNo=" + contactNo + ", createdBy=" + createdBy + ", createdDate=" + createdDate
				+ ", email=" + email + ", lastModifiedBy=" + lastModifiedBy + ", lastModifiedDate=" + lastModifiedDate
				+ "]";
	}
	public Client(int clientId, boolean active, String address, String clientName, String contactNo, String createdBy,
			LocalDate createdDate, String email, String lastModifiedBy, LocalDate lastModifiedDate) {
		super();
		this.clientId = clientId;
		this.active = active;
		this.address = address;
		this.clientName = clientName;
		this.contactNo = contactNo;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.email = email;
		this.lastModifiedBy = lastModifiedBy;
		this.lastModifiedDate = lastModifiedDate;
	}
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
