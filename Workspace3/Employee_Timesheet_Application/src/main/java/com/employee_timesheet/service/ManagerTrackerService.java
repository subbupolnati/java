package com.employee_timesheet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee_timesheet.exception.NotFoundException;
import com.employee_timesheet.model.ManagerTracker;
import com.employee_timesheet.repository.ManagerTrackerRepository;

@Service
public class ManagerTrackerService {
	@Autowired
	private ManagerTrackerRepository managerTrackerRepository;
	
	//This method save ManagerTracker in database using predefined save method  
	public ManagerTracker insertManagerTracker(ManagerTracker managerTracker) {
		return managerTrackerRepository.save(managerTracker);
	}
	//this method getting all ManagerTracker in ManagerTracker table
	public List<ManagerTracker> getAllManagerTracker(){
		return managerTrackerRepository.findAll();
	}
	//this method getting ManagerTracker details based on ManagerTracker id
	public ManagerTracker getManagerTrackerById(int managerTrackerId) {
		//this statement get ManagerTracker based on id if ManagerTracker is not available optional is null
		ManagerTracker managerTracker=managerTrackerRepository.findById(managerTrackerId).get();
		//if ManagerTracker instance not null execute if block other wise it returns ManagerTracker null;
		if(managerTracker!=null)
			return managerTracker;
		else
			throw new NotFoundException("ManagerTracker not found for id : " +managerTrackerId);
	}
	//this method update ManagerTracker based on ManagertId
	public ManagerTracker updateManagerTracker(ManagerTracker managerTracker,int managerTrackerId) {
		//this statement get ManagerTracker based on id if ManagerTracker is not available optional is null
		Optional<ManagerTracker> optional=managerTrackerRepository.findById(managerTrackerId);
		//if optional instance not null execute if block other wise it returns ManagerTracker null;
		if (optional.isPresent()) {
		    managerTracker.setManagerTrackerId(managerTrackerId);
		    return managerTrackerRepository.save(managerTracker);
		}else
		   throw new NotFoundException("ManagerTracker not found for id : " +managerTrackerId);
	}
	//In this method deleteManagerTracker based on id
	public void deleteManagerTracker(int managerTrackerId) {
		managerTrackerRepository.deleteById(managerTrackerId);
	}
}
