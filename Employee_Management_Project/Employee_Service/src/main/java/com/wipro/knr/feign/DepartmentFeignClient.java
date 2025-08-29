package com.wipro.knr.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.wipro.knr.dto.Department;

@FeignClient(name = "departments-service") 
public interface DepartmentFeignClient {

    @GetMapping("/api/departments/getDepartmentById/{departmentId}")
    public Department getDepartmentById(@PathVariable("departmentId") Integer departmentId);
    
    @GetMapping("/api/departments/getAllDepartments")
    public List<Department> getAllDept();
}
