package com.employee_timesheet.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;



@Entity//This Annotations class like Entity model class
@Table(name="users")
@Data
//This This Model class encapsulates users data fields
public class Users {
	
	@Id //this annotation used to generate primary key
	@GeneratedValue //this annotation used to automatically generated value
	private int userId;
	private boolean active;
	private String address;
	private String bankDetails;
	private double compensation;
	private String contactNo;
	private String createdBy;
	private LocalDate createdTime;
	private String designation;
	private String dob;
	private String employerMail;
	private LocalDate endDate;
	private String fileName;
	private String fileType;
	private String firstName;
	private boolean firstTime;
	private String gender;
	private LocalDate joiningDate;
	private String lastModifiedBy;
	private LocalDate lastModifiedDate;
	private String lastName;
	private String machineAssetno;
	private String managerMail;
	private String officialMail;
	private String password;
	private String personalMail;
	@Lob
	@Column(name = "profile", length = Integer.MAX_VALUE, nullable = true)
	private String profile;
	private String roles;
	private String userType;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "client_id") 
	private Client clientId;
}
