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
@Table(name="manager_tracker")
public class ManagerTracker {

	@Id
	@GeneratedValue
	private int managerTrackerId;
	private LocalDate approvalEndDate;
	private int emailCount;
	private LocalDate startDate;
	private String managerUid;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="manager_id")
	private Manager manager;
	public int getManagerTrackerId() {
		return managerTrackerId;
	}
	public void setManagerTrackerId(int managerTrackerId) {
		this.managerTrackerId = managerTrackerId;
	}
	public LocalDate getApprovalEndDate() {
		return approvalEndDate;
	}
	public void setApprovalEndDate(LocalDate approvalEndDate) {
		this.approvalEndDate = approvalEndDate;
	}
	public int getEmailCount() {
		return emailCount;
	}
	public void setEmailCount(int emailCount) {
		this.emailCount = emailCount;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public String getManagerUid() {
		return managerUid;
	}
	public void setManagerUid(String managerUid) {
		this.managerUid = managerUid;
	}
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	@Override
	public String toString() {
		return "ManagerTracker [managerTrackerId=" + managerTrackerId + ", approvalEndDate=" + approvalEndDate
				+ ", emailCount=" + emailCount + ", startDate=" + startDate + ", managerUid=" + managerUid
				+ ", manager=" + manager + "]";
	}
	public ManagerTracker() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ManagerTracker(int managerTrackerId, LocalDate approvalEndDate, int emailCount, LocalDate startDate,
			String managerUid, Manager manager) {
		super();
		this.managerTrackerId = managerTrackerId;
		this.approvalEndDate = approvalEndDate;
		this.emailCount = emailCount;
		this.startDate = startDate;
		this.managerUid = managerUid;
		this.manager = manager;
	}
	
}
