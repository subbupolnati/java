package com.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.employeeexception.DepartmentNotFoundException;
import com.employee.model.Department;
import com.employee.model.Employee;
import com.employee.repo.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository dr;

	public DepartmentRepository getDr() {
		return dr;
	}

	public void setDr(DepartmentRepository dr) {
		this.dr = dr;
	}

	public Department addDept(Department dept) {
		return dr.save(dept);
	}
	public List<Department> getAllDept(){
		return dr.findAll();
	}
	public List<Employee> getEmployeesByDeptId(int did){
		Optional<Department> d=dr.findById(did);
		if(!d.isPresent())
			throw new DepartmentNotFoundException("Department id is not found"+did);
		return d.get().getEmployee();
	}

	public void deleteDept(int did) {
		try{
			dr.deleteById(did);
		}
		catch(Exception e) {
			throw new DepartmentNotFoundException("Department not found for id : " + did);
		}
	}

	public Department update(Department department, int did) {
		Optional<Department> optional = dr.findById(did);
        if (optional.isPresent()) {
            department.setDid(did);
            return dr.save(department);
        }
        else
            throw new DepartmentNotFoundException("Department not found for id : " + did);
	}

	public Department getDepartment(int did) {
		Optional<Department> optional = dr.findById(did);
		Department dept=null;
		if(optional.isPresent()) {
			dept=optional.get();
			return dept;
		}
        else
            throw new DepartmentNotFoundException("Department not found for id : " + did);
	}
}
