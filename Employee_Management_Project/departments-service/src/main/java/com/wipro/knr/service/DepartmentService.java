package com.wipro.knr.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.wipro.knr.dto.Employee;
import com.wipro.knr.dto.Project;
import com.wipro.knr.entity.Department;

public interface DepartmentService {
	
	public Department save(Department department);
	
	public List<Department> getAll();
	
	public Department update(Integer departmentId, Department department);
	
	public ResponseEntity<String> delete(Integer departmentId);

	public Department getById(Integer departmentId);

	public List<Employee> getEmployByDept(Integer departmentId);

	public List<Project> getProjectByDept(Integer departmentId);

}
