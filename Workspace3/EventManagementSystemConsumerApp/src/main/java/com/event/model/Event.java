package com.event.model;

import java.sql.Date;


public class Event {
	
	private int eventid;
	private String eventName;
	private Date startTime;
	private Date endTime;
	private String participantName;
	private String mobileNumber;
	private int noOfGuests;
	private Venue venue;
	public int getEventid() {
		return eventid;
	}
	public void setEventid(int eventid) {
		this.eventid = eventid;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getParticipantName() {
		return participantName;
	}
	public void setParticipantName(String participantName) {
		this.participantName = participantName;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public int getNoOfGuests() {
		return noOfGuests;
	}
	public void setNoOfGuests(int noOfGuests) {
		this.noOfGuests = noOfGuests;
	}
	public Venue getVenue() {
		return venue;
	}
	public void setVenue(Venue venue) {
		this.venue = venue;
	}
	@Override
	public String toString() {
		return "Event [eventid=" + eventid + ", eventName=" + eventName + ", startTime=" + startTime + ", endTime="
				+ endTime + ", participantName=" + participantName + ", mobileNumber=" + mobileNumber + ", noOfGuests="
				+ noOfGuests + ", venue=" + venue + "]";
	}
	public Event(int eventid, String eventName, Date startTime, Date endTime, String participantName,
			String mobileNumber, int noOfGuests, Venue venue) {
		super();
		this.eventid = eventid;
		this.eventName = eventName;
		this.startTime = startTime;
		this.endTime = endTime;
		this.participantName = participantName;
		this.mobileNumber = mobileNumber;
		this.noOfGuests = noOfGuests;
		this.venue = venue;
	}
	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
