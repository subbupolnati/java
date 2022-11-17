package com.employee_timesheet.model;

import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="invoice")
public class Invoice {

	@Id
	@GeneratedValue
	private int invoiceId;
	private String employeeName;
	private String fileName;
	private String fileType;
	@Lob
	private Blob invoice;
	private String month;
	private String processedDate;
	private double rateHours;
	private String status;
	private double totalHours;
	private String uploadedDate;
	private int year;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private Users user;
	public int getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public Blob getInvoice() {
		return invoice;
	}
	public void setInvoice(Blob invoice) {
		this.invoice = invoice;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getProcessedDate() {
		return processedDate;
	}
	public void setProcessedDate(String processedDate) {
		this.processedDate = processedDate;
	}
	public double getRateHours() {
		return rateHours;
	}
	public void setRateHours(double rateHours) {
		this.rateHours = rateHours;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getTotalHours() {
		return totalHours;
	}
	public void setTotalHours(double totalHours) {
		this.totalHours = totalHours;
	}
	public String getUploadedDate() {
		return uploadedDate;
	}
	public void setUploadedDate(String uploadedDate) {
		this.uploadedDate = uploadedDate;
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
	@Override
	public String toString() {
		return "Invoice [invoiceId=" + invoiceId + ", employeeName=" + employeeName + ", fileName=" + fileName
				+ ", fileType=" + fileType + ", invoice=" + invoice + ", month=" + month + ", processedDate="
				+ processedDate + ", rateHours=" + rateHours + ", status=" + status + ", totalHours=" + totalHours
				+ ", uploadedDate=" + uploadedDate + ", year=" + year + ", user=" + user + "]";
	}
	public Invoice(int invoiceId, String employeeName, String fileName, String fileType, Blob invoice, String month,
			String processedDate, double rateHours, String status, double totalHours, String uploadedDate, int year,
			Users user) {
		super();
		this.invoiceId = invoiceId;
		this.employeeName = employeeName;
		this.fileName = fileName;
		this.fileType = fileType;
		this.invoice = invoice;
		this.month = month;
		this.processedDate = processedDate;
		this.rateHours = rateHours;
		this.status = status;
		this.totalHours = totalHours;
		this.uploadedDate = uploadedDate;
		this.year = year;
		this.user = user;
	}
	public Invoice() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
