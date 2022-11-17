package com.employee_timesheet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee_timesheet.exception.NotFoundException;
import com.employee_timesheet.model.Timesheet;
import com.employee_timesheet.repository.TimesheetRepository;

@Service
public class TimesheetService {
	@Autowired
	private TimesheetRepository timesheetRepository;
	
	//This method save Timesheet in database using predefined save method  
	public Timesheet insertTimesheet(Timesheet timesheet) {
		return timesheetRepository.save(timesheet);
	}
	//this method getting avll Timesheet in Timesheet table
	public List<Timesheet> getAllTimesheets(){
		return timesheetRepository.findAll();
	}
	//this method getting Timesheet details based on Manager id
	public Timesheet getTimesheetById(int timesheetId) {
		//this statement get Timesheet based on id if Timesheet is not available optional is null
		Timesheet timesheet=timesheetRepository.findById(timesheetId).get();
		//if Timesheet instance not null execute if block other wise it returns Timesheet null;
		if(timesheet!=null)
			return timesheet;
		else
			throw new NotFoundException("Timesheet not found for id : " +timesheetId);
	}
	//this method update Timesheet based on timesheetId
	public Timesheet updateTimesheet(Timesheet timesheet,int timesheetId) {
		//this statement get Timesheet based on id if Timesheet is not available optional is null
		Optional<Timesheet> optional=timesheetRepository.findById(timesheetId);
		//if optional instance not null execute if block other wise it returns Timesheet null;
		if (optional.isPresent()) {
		    timesheet.setTimesheetId(timesheetId);
		    return timesheetRepository.save(timesheet);
		}else
		   throw new NotFoundException("Timesheet not found for id : " +timesheetId);
	}
	//In this method delete Timesheet based on id
	public void deleteTimesheet(int timesheetId) {
		timesheetRepository.deleteById(timesheetId);
	}
}
