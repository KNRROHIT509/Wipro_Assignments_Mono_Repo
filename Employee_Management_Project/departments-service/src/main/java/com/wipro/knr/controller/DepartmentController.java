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
import org.springframework.web.bind.annotation.RestController;

import com.wipro.knr.entity.Department;
import com.wipro.knr.service.DepartmentService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("/addNewDepartment")
	public Department addDept(@RequestBody Department department) {
		return departmentService.save(department);
	}
	
	@GetMapping("/getAllDepartments")
	public List<Department> getAllDept() {
		return departmentService.getAll();
	}
	

	@GetMapping("/getDepartmentById/{departmentId}")
	public Department getDepartmentById(@PathVariable Integer departmentId) {
	    return departmentService.getById(departmentId);  // Add getById to DepartmentServiceImpl using repository.findById
	}
	
	@GetMapping("/getEmployeeByDeptId/{departmentId}")
	@CircuitBreaker(name="getEmployeeCircuitBreaker", fallbackMethod ="getEmployeeFallBackMethod")
	public ResponseEntity<?> getEmployeesByDepartmentId(@PathVariable Integer departmentId){
		return ResponseEntity.ok(departmentService.getEmployByDept(departmentId));
	}
	
	public ResponseEntity<String> getEmployeeFallBackMethod(Integer departmentId, Throwable throwable){
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Employee Server is down, please try again later");
	}
	
	@CircuitBreaker(name="getProjectCircuitBreaker", fallbackMethod ="getProjectFallBackMethod")
	@GetMapping("/getProjectByDeptId/{departmentId}")
	public ResponseEntity<?> getProjectsByDepartmentId(@PathVariable Integer departmentId){
		return ResponseEntity.ok(departmentService.getProjectByDept(departmentId));
	}
	
	public ResponseEntity<String> getProjectFallBackMethod(Integer departmentId , Throwable throwable){
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Project Server is down, please try again later");
	}
	
	@PatchMapping("/updateDepartment/{departmentId}")
	public Department updateDept(@PathVariable Integer departmentId, @RequestBody Department department) {
		return departmentService.update(departmentId,department);
	}
	
	@DeleteMapping("/deleteDepartment/{departmentId}")
	public ResponseEntity<String> deleteDept(@PathVariable Integer departmentId) {
		return departmentService.delete(departmentId);
	}

}
