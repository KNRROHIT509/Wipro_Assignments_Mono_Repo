package com.wipro.knr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wipro.knr.dto.Salary;
import com.wipro.knr.entity.Employee;
import com.wipro.knr.service.EmployeeService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @PatchMapping("/updateEmployeeById/{id}")
    public Employee updateEmployee(@PathVariable Integer id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Integer id) {
        return employeeService.deleteEmployee(id);
    }

    @GetMapping("/getEmployeeById/{id}")
    public Employee getEmployeeById(@PathVariable Integer id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/getAllEmployees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
    
    @GetMapping("/department/{departmentId}")
    public List<Employee> getEmployeesByDepartment(@PathVariable Integer departmentId) {
        return employeeService.getEmployeesByDepartment(departmentId);
    }
 
    @GetMapping("/getDepartmentByEmployeeId/{id}")
    @CircuitBreaker(name="getEmployeeCircuitBreaker", fallbackMethod ="getEmployeeFallBackMethod")
    public ResponseEntity<?> getDepartmentByEmployeeId(@PathVariable Integer id) {
        return ResponseEntity.ok(employeeService.getDepartmentByEmployId(id));
    }

    public ResponseEntity<String> getEmployeeFallBackMethod(Integer id, Throwable throwable) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
               .body("Department server is down! Please try again later.");
    }
    
    @CircuitBreaker(name="getSalaryCircuitBreaker", fallbackMethod ="getSalaryFallBackMethod")
    @GetMapping("/getSalaryByEmployeeId/{id}")
    public ResponseEntity<?> getSalaryByEmployeeId(@PathVariable Integer id) {
    	return ResponseEntity.ok(employeeService.getSalaryByEmployId(id));
    }
    public ResponseEntity<String> getSalaryFallBackMethod(Integer id, Throwable throwable) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
               .body("Salary server is down! Please try again later.");
    }
    @GetMapping("/salary/{salaryId}")
    public List<Employee> getEmployeesBySalary(@PathVariable Integer salaryId) {
        return employeeService.getEmployeesBySalary(salaryId);
    }
    
    @GetMapping("/salary/getAllSalaries")
    public List<Salary> getAllSalaries(){
    	return employeeService.getAllSalary();
    }

    
}