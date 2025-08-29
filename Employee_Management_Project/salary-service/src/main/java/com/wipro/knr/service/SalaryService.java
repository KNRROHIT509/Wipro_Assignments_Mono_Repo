package com.wipro.knr.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.wipro.knr.dto.EmployeeWrapper;
import com.wipro.knr.entity.Salary;

public interface SalaryService {

	Salary save(Salary salary);

	
	Salary update(Integer salaryId, Salary salary);

	ResponseEntity<String> delete(Integer salaryId);


	List<Salary> getAllSalary();


	Salary getById(Integer salaryId);


	Integer getSalaryByEmployName(String name);


	List<EmployeeWrapper> getAllSalByDeptId(Integer departmentId);

}
