package com.wipro.knr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.knr.entity.Salary;
import com.wipro.knr.service.SalaryService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/api/salary")
public class SalaryController {
	
	@Autowired
	private SalaryService salaryService;
	
	@PostMapping("/addSalary")
	public Salary addDept(@RequestBody Salary salary) {
		return salaryService.save(salary);
	}
	
	@GetMapping("/getAllSalary")
	public List<Salary> getAllSalary() {
		return salaryService.getAllSalary();
	}
	
	@GetMapping("/getBySalaryId/{salaryId}")
	public Salary getBySalaryId(@PathVariable Integer salaryId ) {
		return salaryService.getById(salaryId);
	}
	
	
	@GetMapping("/getSalaryByEmployeeName")
	@CircuitBreaker(name="getSalaryCircuitBreaker" , fallbackMethod= "getSalaryFallBackMethod")
	public ResponseEntity<?> getSalaryByEmployeeName(@RequestParam String name) {
		return ResponseEntity.ok(salaryService.getSalaryByEmployName(name));
	}
	public ResponseEntity<String> getSalaryFallBackMethod(String name, Throwable throwable){
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Employee Server is down , please try again later");
	}
	
	@CircuitBreaker(name="getSalaryByDepartmentCircuitBreaker" , fallbackMethod= "getSalaryByDepartmentFallBackMethod")
	@GetMapping("/getAllSalaryByDepartmentId/{departmentId}")
	public ResponseEntity<?> getAllSalariesByDepartmentId(@PathVariable Integer departmentId){
		return ResponseEntity.ok(salaryService.getAllSalByDeptId(departmentId));
	}
	public ResponseEntity<String> getSalaryByDepartmentFallBackMethod(Integer departmentId , Throwable throwable){
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Employee Server is down , please try again later");
	}
	@PatchMapping("/updateSalary/{salaryId}")
	public Salary updateSal(@PathVariable Integer salaryId, @RequestBody Salary salary) {
		return salaryService.update(salaryId, salary);
	}
	
	@DeleteMapping("/deleteSalary/{salaryId}")
	public ResponseEntity<String> deleteSal(@PathVariable Integer salaryId) {
		return salaryService.delete(salaryId);
	}

}
