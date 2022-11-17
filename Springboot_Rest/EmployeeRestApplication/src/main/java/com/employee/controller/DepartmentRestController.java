package com.employee.controller;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.Department;
import com.employee.model.Employee;
import com.employee.service.DepartmentRestService;

@RestController
public class DepartmentRestController {
	@Autowired
	DepartmentRestService deptRestService;
	
	@GetMapping("/dept/{did}")
	public ResponseEntity<Department> searchDeptById(@PathVariable("did") int did){
		return deptRestService.searchDeptById(did);
	}
	@GetMapping("/dept")
	public ResponseEntity<Department[]> showAllDept(){
		
		return deptRestService.showAllDept();
	}
	@PostMapping("/dept")
	public ResponseEntity<Department>addNewDept(@RequestBody Department dept) throws URISyntaxException{
		
		return deptRestService.addNewDept(dept);
	}
	@PutMapping("/dept/{did}")
	public ResponseEntity<Department>updateDept(@PathVariable("did") int did) throws URISyntaxException{
		
		return deptRestService.updateDept(did);
	}
	@DeleteMapping("/dept/{did}")
	public ResponseEntity<Department>deleteDept(@PathVariable("did") int did) throws URISyntaxException{
		
		return deptRestService.DeleteDeptById(did);
	}
	
}
