package com.employee_timesheet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee_timesheet.exception.NotFoundException;
import com.employee_timesheet.model.Manager;
import com.employee_timesheet.repository.ManagerRepository;

@Service
public class ManagerService {

	@Autowired
	private ManagerRepository managerRepository;
	
	//This method save Managers in database using predefined save method  
	public Manager insertManager(Manager manager) {
		return managerRepository.save(manager);
	}
	//this method getting all Managers in manager table
	public List<Manager> getAllManagers(){
		return managerRepository.findAll();
	}
	//this method getting Manager details based on Manager id
	public Manager getManagereById(int managerId) {
		//this statement get Manager based on id if Manager is not available optional is null
		Manager manager=managerRepository.findById(managerId).get();
		//if Manager instance not null execute if block other wise it returns Manager null;
		if(manager!=null)
			return manager;
		else
			throw new NotFoundException("Manager not found for id : " +managerId);
	}
	//this method update Manager based on ManagertId
	public Manager updateManager(Manager manager,int managerId) {
		//this statement get Manager based on id if Manager is not available optional is null
		Optional<Manager> optional=managerRepository.findById(managerId);
		//if optional instance not null execute if block other wise it returns manager null;
		if (optional.isPresent()) {
		    manager.setManagerId(managerId);
		    return managerRepository.save(manager);
		}else
		   throw new NotFoundException("Manager not found for id : " +managerId);
	}
	//In this method delete Manager based on id
	public void deleteManager(int managerId) {
		managerRepository.deleteById(managerId);
	}
}
