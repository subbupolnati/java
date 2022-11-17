package com.employee_timesheet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee_timesheet.exception.NotFoundException;
import com.employee_timesheet.model.Holiday;
import com.employee_timesheet.repository.HolidayRepository;

@Service
public class HolidayService {

	@Autowired
	private HolidayRepository holidayRepository;
	
	//This method save Holidays in database using predefined save method  
	public Holiday insertHoliday(Holiday holiday) {
		return holidayRepository.save(holiday);
	}
	//this method getting all Holidays in holiday table
	public List<Holiday> getAllHolidays(){
		return holidayRepository.findAll();
	}
	//this method getting Holiday details based on Holiday id
	public Holiday getHolidayById(int holidayId) {
		//this statement get Holiday based on id if Holiday is not available optional is null
		Holiday holiday=holidayRepository.findById(holidayId).get();
		//if holiday instance not null execute if block other wise it returns Holiday null;
		if(holiday!=null) {
			return holiday;
		}else
			 throw new NotFoundException("Holiday not found for id : " +holidayId);
	}
	//this method update Holiday based on holidaytId
	public Holiday updateHoliday(Holiday holiday,int holidayId) {
		//this statement get Holiday based on id if Holiday is not available optional is null
		Optional<Holiday> optional=holidayRepository.findById(holidayId);
		//if optional instance not null execute if block other wise it returns Holiday null;
	    if (optional.isPresent()) {
	         holiday.setHolidayId(holidayId);
	         return holidayRepository.save(holiday);
	    }else
	       throw new NotFoundException("Holiday not found for id : " +holidayId);
	}
	//In this method delete Holiday based on id
	public void deleteHoliday(int holidayId) {
		holidayRepository.deleteById(holidayId);
	}
}
