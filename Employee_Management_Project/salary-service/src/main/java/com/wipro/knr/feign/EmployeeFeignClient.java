package com.wipro.knr.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.wipro.knr.dto.Employee;

@FeignClient(name = "employee-service")  
public interface EmployeeFeignClient {

    @GetMapping("/api/employees/getAllEmployees")
    public List<Employee> getAllEmployees();
    
    @GetMapping("/api/employees/getEmployeeById/{id}")
    public Employee getEmployeeById(@PathVariable("id") Integer id);  
}

