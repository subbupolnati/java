package com.employee_timesheet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee_timesheet.exception.NotFoundException;
import com.employee_timesheet.model.TimesheetEmployees;
import com.employee_timesheet.repository.TimesheetEmployeesRepositoy;

@Service
public class TimesheetEmployeeService {

	@Autowired
	private TimesheetEmployeesRepositoy timesheetEmployeesRepositoy;
	
	//This method save TimesheetEmployees in database using predefined save method  
	public TimesheetEmployees insertTimesheetEmployees(TimesheetEmployees timesheetEmployees) {
		return timesheetEmployeesRepositoy.save(timesheetEmployees);
	}
	//this method getting all TimesheetEmployees in TimesheetEmployees table
	public List<TimesheetEmployees> getAllTimesheetEmployees(){
		return timesheetEmployeesRepositoy.findAll();
	}
	//this method getting TimesheetEmployees details based on TimesheetEmployees id
	public TimesheetEmployees getTimesheetEmployeesById(int timesheetEmployeeId) {
		//this statement get TimesheetEmployees based on id if TimesheetEmployees is not available optional is null
		TimesheetEmployees timesheetEmployees=timesheetEmployeesRepositoy.findById(timesheetEmployeeId).get();
		//if TimesheetEmployees instance not null execute if block other wise it returns Timesheet null;
		if(timesheetEmployees!=null)
			return timesheetEmployees;
		else
			throw new NotFoundException("TimesheetEmployees not found for id : " +timesheetEmployeeId);
	}
	//this method update TimesheetEmployees based on TimesheetEmployeesId
	public TimesheetEmployees updateTimesheetEmployees(TimesheetEmployees timesheetEmployees,int timesheetEmployeeId) {
		//this statement get Timesheet based on id if Timesheet is not available optional is null
		Optional<TimesheetEmployees> optional=timesheetEmployeesRepositoy.findById(timesheetEmployeeId);
		//if optional instance not null execute if block other wise it returns TimesheetEmployees null;
		if (optional.isPresent()) {
		    timesheetEmployees.setTimesheetEmployeeId(timesheetEmployeeId);
		    return timesheetEmployeesRepositoy.save(timesheetEmployees);
		}else
		   throw new NotFoundException("TimesheetEmployees not found for id : " +timesheetEmployeeId);
	}
	//In this method delete TimesheetEmployees based on id
	public void deleteTimesheetEmployees(int timesheetEmployeeId) {
		timesheetEmployeesRepositoy.deleteById(timesheetEmployeeId);
	}
}
