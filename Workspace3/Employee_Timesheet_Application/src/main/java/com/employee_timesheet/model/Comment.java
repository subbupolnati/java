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
@Table(name="comments")
public class Comment {

	@Id
	@GeneratedValue
	private int commentId;
	private String comment;
	private String commentBy;
	private LocalDate date;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="timesheet_id")
	private Timesheet timesheet;
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getCommentBy() {
		return commentBy;
	}
	public void setCommentBy(String commentBy) {
		this.commentBy = commentBy;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Timesheet getTimesheet() {
		return timesheet;
	}
	public void setTimesheet(Timesheet timesheet) {
		this.timesheet = timesheet;
	}
	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", comment=" + comment + ", commentBy=" + commentBy + ", date="
				+ date + ", timesheet=" + timesheet + "]";
	}
	public Comment(int commentId, String comment, String commentBy, LocalDate date, Timesheet timesheet) {
		super();
		this.commentId = commentId;
		this.comment = comment;
		this.commentBy = commentBy;
		this.date = date;
		this.timesheet = timesheet;
	}
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
