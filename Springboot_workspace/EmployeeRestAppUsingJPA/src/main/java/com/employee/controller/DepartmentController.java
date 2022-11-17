package com.employee.controller;

import java.net.URI;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.employee.model.Department;
import com.employee.model.Employee;
import com.employee.service.DepartmentService;

@RestController
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
		
	public DepartmentService getDepartmentService() {
		return departmentService;
	}
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	@PostMapping("/dept")
	public ResponseEntity<Department> addNewDept(@RequestBody Department dept){
		Department d=departmentService.addDept(dept);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{did}").buildAndExpand(d.getDid()).toUri();
		return ResponseEntity.created(location).build();
	}
	@GetMapping("/dept")
	public List<Department> getAllDept(){
		return departmentService.getAllDept();
	}
	@DeleteMapping("/dept/{did}")
	public void deleteDepartment(@PathVariable("did") int did) {
		departmentService.deleteDept(did);
	}
	@PutMapping("/dept/{did}")
	public Department updateDepartment(@RequestBody Department department,@PathVariable("did") int did) {
		return departmentService.update(department,did);
	}
	@GetMapping("/dept/{did}")
	public Department getDepartment(@PathVariable("did") int did) {
		return departmentService.getDepartment(did);
	}
	@GetMapping("/dept/{did}/employee")
	public List<Employee> getAllEmpDetalisByDeptId(@PathVariable("did") int did){
		return departmentService.getEmployeesByDeptId(did);
	}
}
