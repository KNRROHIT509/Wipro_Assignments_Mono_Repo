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

import com.wipro.knr.entity.Project;
import com.wipro.knr.service.ProjectService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/projects")
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@PostMapping("/addNewProject")
	public Project createProject(@RequestBody Project project) {
		return projectService.save(project);
	}
	
	@GetMapping("/getAllProjects")
	public List<Project> getProjects() {
		return projectService.getAll();
	}
	
	@GetMapping("/getProjectById/{projectId}")
	public Project getProjectById(@PathVariable Integer projectId) {
		return projectService.getProjectBasedOnId(projectId);
	}
	@CircuitBreaker(name="getEmployeeCircuitBreaker", fallbackMethod ="getEmployeeFallBackMethod")
	@GetMapping("/getEmployeeByProjectId/{projectId}")
	public ResponseEntity<?> getEmployeeByProjectId(@PathVariable Integer projectId){
		return ResponseEntity.ok(projectService.getEmploysBasedOnProjectId(projectId));
	}
	public ResponseEntity<String> getEmployeeFallBackMethod(Integer projectId, Throwable throwable){
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Employee Server is down, please try again later");
	}
	
	@CircuitBreaker(name="getEmployeeNameCircuitBreaker", fallbackMethod ="getEmployeeNameFallBackMethod")
	@GetMapping("/getProjectByEmployeeName")
	public ResponseEntity<?> getProjectByEmployeeName(@RequestParam String name) {
		return ResponseEntity.ok(projectService.getProjectByEmployeeName(name));
	}
	public ResponseEntity<String> getEmployeeNameFallBackMethod(String name, Throwable throwable){
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Employee Server is down, please try again later");
	}
	@PatchMapping("/updateProject/{projectId}")
	public Project updateProject(@PathVariable Integer projectId, @RequestBody Project project) {
		return projectService.update(projectId,project);
	}
	
	@DeleteMapping("/deleteProject/{projectId}")
	public ResponseEntity<String> deleteProject(@PathVariable Integer projectId) {
		return projectService.delete(projectId);
	}
 
}
