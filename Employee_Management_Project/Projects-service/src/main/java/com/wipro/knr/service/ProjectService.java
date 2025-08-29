package com.wipro.knr.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.wipro.knr.dto.Employee;
import com.wipro.knr.entity.Project;

public interface ProjectService {
	
	public Project save(Project project);
	public List<Project> getAll();
	public Project getProjectBasedOnId(Integer projectId);
	public Project update(Integer projectId , Project project);
	public ResponseEntity<String> delete(Integer projectId);
	public List<Employee> getEmploysBasedOnProjectId(Integer projectId);
	public String getProjectByEmployeeName(String name);
}
