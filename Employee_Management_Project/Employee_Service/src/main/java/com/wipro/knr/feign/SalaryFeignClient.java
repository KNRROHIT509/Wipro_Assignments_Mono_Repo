package com.wipro.knr.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.wipro.knr.dto.Salary;

@FeignClient(name = "salary-service")  // Matches spring.application.name in Salary Service
public interface SalaryFeignClient {

    @GetMapping("/api/salary/getAllSalary")
    public List<Salary> getAllSalary();
    
    @GetMapping("/api/salary/getBySalaryId/{salaryId}")
    public Salary getBySalaryId(@PathVariable("salaryId") Integer salaryId);
}
