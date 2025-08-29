package com.wipro.knr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wipro.knr.dto.Department;
import com.wipro.knr.dto.Salary;
import com.wipro.knr.entity.Employee;
import com.wipro.knr.exception.EmployeeIdNotFoundException;
import com.wipro.knr.feign.DepartmentFeignClient;
import com.wipro.knr.feign.SalaryFeignClient;
import com.wipro.knr.repository.EmployeeRepository;

import feign.FeignException;
import jakarta.ws.rs.ServiceUnavailableException;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Service
@Slf4j
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Autowired
    private DepartmentFeignClient departmentFeignClient;
    
    @Autowired
    private SalaryFeignClient salaryFeignClient;
    
    public List<Salary> getAllSalary() {
        try {
            return salaryFeignClient.getAllSalary();
        } catch (FeignException e) {
            log.error("Failed to fetch all salaries", e);
            throw new ServiceUnavailableException("Salary service is currently unavailable");
        }
    }

    public Salary getSalaryById(Integer salaryId) {
        try {
            return salaryFeignClient.getBySalaryId(salaryId);
        } catch (FeignException.NotFound e) {
            log.warn("Salary not found for ID: {}", salaryId);
            return null;
        } catch (FeignException e) {
            log.error("Failed to fetch salary for ID: {}", salaryId, e);
            throw new ServiceUnavailableException("Salary service is currently unavailable");
        }
    }

    
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
  
    }

    public Employee updateEmployee(Integer id, Employee employee) {
        Employee employee1 = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeIdNotFoundException("Employee","ID",id));
        
        employee1.setName(employee.getName());
        employee1.setAddress(employee.getAddress());
        employee1.setMobileNumber(employee.getMobileNumber());
        employee1.setDepartmentId(employee.getDepartmentId());
        employee1.setProjectId(employee.getProjectId());
        
        Employee updatedEmployee = employeeRepository.save(employee1);
        return updatedEmployee;
    }

    public ResponseEntity<String> deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
        return ResponseEntity.ok("Employee with "+id+" Deleted Successfully");
    }

    public Employee getEmployeeById(Integer id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeIdNotFoundException("Employee","ID",id));
        return employee;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

	public List<Employee> getEmployeesByDepartment(Integer departmentId) {
		// TODO Auto-generated method stub
		return employeeRepository.findByDepartmentId(departmentId);
	}

	public List<Employee> getEmployeesBySalary(Integer salaryId) {
		// TODO Auto-generated method stub
		return employeeRepository.findBySalaryId(salaryId);
	}

	public Department getDepartmentByEmployId(Integer id) {
		Employee emp=employeeRepository.findById(id).orElseThrow(()->new EmployeeIdNotFoundException("Employee","ID",id));
		if(emp.getDepartmentId()!=null) {
			Department dep=departmentFeignClient.getDepartmentById(emp.getDepartmentId());
			return dep;
		}
		return null;
	}

	public Salary getSalaryByEmployId(Integer id) {
		// TODO Auto-generated method stub
		Employee emp=employeeRepository.findById(id).orElseThrow(()->new EmployeeIdNotFoundException("Employee","ID",id));
		if(emp.getSalaryId()!=null) {
			Salary sal=salaryFeignClient.getBySalaryId(emp.getSalaryId());
			return sal;
		}
		return null;
	}

}