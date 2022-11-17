package com.employee.model;


import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

//This Pojo class stores employee data throug validations
public class Employee {
	
	@Min(value = 10000, message = "Empid should not be less than 5")
	private int empId;//This field should be store employee Id
	private String fullName;//This field should be store Full Name
	private String address;//This field should be store employee Address
	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$",message="should have a valid Email id")
	private String email;//This field should be store employee Email
	@Min(value =10000, message = "Salary should not be less than 5 digits")
	private int salary;//This field should be store employee Salary
	@Pattern(regexp = "(0/91)?[7-9][0-9]{9}",message="mobile number should be of 10 numbers")
	private String mobileNo;//This field should be store employee mobile No
	
	private Credential credential;//This field should be store Credential Details

	//Getter and setter methods
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Credential getCredential() {
		return credential;
	}

	public void setCredential(Credential credential) {
		this.credential = credential;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", fullName=" + fullName + ", address=" + address + ", email=" + email
				+ ", salary=" + salary + ", mobileNo=" + mobileNo + ", credential=" + credential + "]";
	}

	public Employee(@Min(value = 10000, message = "Empid should not be less than 5") int empId, String fullName,
			String address,
			@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "should have a valid Email id") String email,
			@Min(value = 10000, message = "Salary should not be less than 5 digits") int salary,
			@Pattern(regexp = "(0/91)?[7-9][0-9]{9}", message = "mobile number should be of 10 numbers") String mobileNo,
			Credential credential) {
		super();
		this.empId = empId;
		this.fullName = fullName;
		this.address = address;
		this.email = email;
		this.salary = salary;
		this.mobileNo = mobileNo;
		this.credential = credential;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
