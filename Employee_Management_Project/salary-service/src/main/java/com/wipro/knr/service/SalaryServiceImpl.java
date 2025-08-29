package com.wipro.knr.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wipro.knr.dto.Employee;
import com.wipro.knr.dto.EmployeeWrapper;
import com.wipro.knr.entity.Salary;
import com.wipro.knr.exception.SalaryIdNotFoundException;
import com.wipro.knr.feign.EmployeeFeignClient;
import com.wipro.knr.repository.SalaryRepository;

@Service
public class SalaryServiceImpl implements SalaryService {
	
	@Autowired
	private SalaryRepository salaryRepository;
	
	@Autowired
	private EmployeeFeignClient employeeFeignClient;
	@Override
	public Salary save(Salary salary) {
		// TODO Auto-generated method stub
		return salaryRepository.save(salary);
	}

	@Override
	public List<Salary> getAllSalary() {
		// TODO Auto-generated method stub
		return salaryRepository.findAll();
	}

	@Override
	public Salary update(Integer salaryId, Salary salary) {
		// TODO Auto-generated method stub
		Salary sal=salaryRepository.findById(salaryId).orElseThrow(()->new SalaryIdNotFoundException("Salary","ID",salaryId));
		sal.setBasicSal(salary.getBasicSal());
		sal.setPayMethod(salary.getPayMethod());
		sal.setPaymentDate(salary.getPaymentDate());
		sal.setStatus(salary.getStatus());
		
		return salaryRepository.save(sal);
	}

	@Override
	public ResponseEntity<String> delete(Integer salaryId) {
		// TODO Auto-generated method stub
		salaryRepository.findById(salaryId);
		return ResponseEntity.ok("Salary with "+salaryId+" Deleted Successfully");
		
	}

	@Override
	public Salary getById(Integer salaryId) {
		// TODO Auto-generated method stub
		return salaryRepository.findById(salaryId).orElseThrow(()->new SalaryIdNotFoundException("Salary","ID",salaryId));
	}

	@Override
	public Integer getSalaryByEmployName(String name) {
		List<Employee> emps=employeeFeignClient.getAllEmployees();
		Integer assignedSalary=null;
		for(Employee emp:emps) {
			if(name.equals(emp.getName())) {
				Salary salary=salaryRepository.findById(emp.getSalaryId()).orElseThrow(()->new SalaryIdNotFoundException("Salary","ID",emp.getSalaryId()));
				assignedSalary=salary.getBasicSal();
			}
		}
		return assignedSalary;
	}

	@Override
	public List<EmployeeWrapper> getAllSalByDeptId(Integer departmentId) {
		// TODO Auto-generated method stub
		List<Employee> emps=employeeFeignClient.getAllEmployees();
		List<EmployeeWrapper> departmentSal=new ArrayList<>();
		for(Employee emp:emps) {
			EmployeeWrapper wrapper=new EmployeeWrapper();
			if(departmentId.equals(emp.getDepartmentId())) {
				wrapper.setId(emp.getId());
				wrapper.setName(emp.getName());
				wrapper.setDepartmentId(emp.getDepartmentId());
				Salary salary=salaryRepository.findById(emp.getSalaryId()).orElseThrow(()->new SalaryIdNotFoundException("Salary","ID",emp.getSalaryId()));
				wrapper.setDepartmentId(emp.getDepartmentId());
				wrapper.setBasicSal(salary.getBasicSal());
				
				departmentSal.add(wrapper);
			}
		}
		return departmentSal;
	}



	
	

}
