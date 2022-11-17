package com.employee_timesheet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee_timesheet.exception.NotFoundException;
import com.employee_timesheet.model.Leaves;
import com.employee_timesheet.repository.LeavesRepository;

@Service
public class LeaveService {

	@Autowired
	private LeavesRepository leavesRepositroy;
	
	//This method save Leaves in database using predefined save method  
	public Leaves insertLeave(Leaves leave) {
		return leavesRepositroy.save(leave);
	}
	//this method getting all Leaves  in leave table
	public List<Leaves> getAllLeaves(){
		return leavesRepositroy.findAll();
	}
	//this method getting Leaves details based on Leave id
	public Leaves getLeavesById(int leaveId) {
		//this statement get Leaves based on id if Leaves is not available optional is null
		Leaves leave=leavesRepositroy.findById(leaveId).get();
		//if Leaves instance not null execute if block other wise it returns Leaves null;
		if(leave!=null)
			return leave;
		else
			throw new NotFoundException("Leaves not found for id : " +leaveId);
	}
	//this method update Leaves based on Leave id
	public Leaves updateLeaves(Leaves leave,int leaveId) {
		//this statement get Leaves based on id if Leaves is not available optional is null
		Optional<Leaves> optional=leavesRepositroy.findById(leaveId);
		//if optional instance not null execute if block other wise it returns Holiday null;
		if (optional.isPresent()) {
		    leave.setLeaveId(leaveId);
		    return leavesRepositroy.save(leave);
		}else
		   throw new NotFoundException("Leaves not found for id : " +leaveId);
		}
		//In this method delete Leaves based on id
		public void deleteLeaves(int invoiceId) {
			leavesRepositroy.deleteById(invoiceId);
		}	
}
