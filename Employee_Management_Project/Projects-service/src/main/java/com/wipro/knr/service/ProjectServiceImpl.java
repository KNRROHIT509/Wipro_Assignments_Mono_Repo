package com.wipro.knr.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wipro.knr.dto.Employee;
import com.wipro.knr.entity.Project;
import com.wipro.knr.exception.ProjectIdNotFoundException;
import com.wipro.knr.feign.EmployeeFeignClient;
import com.wipro.knr.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService{
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private EmployeeFeignClient employeeFeignClient;
	
	@Override
	public Project save(Project project) {
		// TODO Auto-generated method stub
		return projectRepository.save(project);
	}
	
	@Override
	public List<Project> getAll() {
		// TODO Auto-generated method stub
		return projectRepository.findAll();
		
	}
	
	@Override
	public Project getProjectBasedOnId(Integer projectId) {
		// TODO Auto-generated method stub
		return projectRepository.findById(projectId).orElseThrow(()->new ProjectIdNotFoundException("Project","ID",projectId));
	}
	
	@Override
	public Project update(Integer projectId , 	Project project) {
		Project p=projectRepository.findById(projectId).orElseThrow(()->new ProjectIdNotFoundException("Project","ID",projectId));
		p.setProjectName(project.getProjectName());
		p.setDescription(project.getDescription());
		p.setStartDate(project.getStartDate());
		p.setEndDate(project.getEndDate());
		p.setProgress(project.getProgress());
		p.setDepartmentId(project.getDepartmentId());
		
		return projectRepository.save(p);
	}

	@Override
	public ResponseEntity<String> delete(Integer projectId) {
		// TODO Auto-generated method stub
		projectRepository.deleteById(projectId);
		return ResponseEntity.ok("Project with "+projectId+" Deleted Successfully");
	}

	@Override
	public List<Employee> getEmploysBasedOnProjectId(Integer projectId) {
		List<Employee> emps=employeeFeignClient.getAllEmployees();
		List<Employee> assignedEmployee=new ArrayList<>();
		for(Employee emp:emps) {
			if(projectId.equals(emp.getProjectId())) {
				assignedEmployee.add(emp);
			}
		}
		return assignedEmployee;
	}

	@Override
	public String getProjectByEmployeeName(String name) {
		List<Employee> emps=employeeFeignClient.getAllEmployees();
		String assignedProject="";
		for(Employee emp:emps) {
			if(name.equals(emp.getName())) {
				Project project=projectRepository.findById(emp.getProjectId()).orElseThrow(()->new ProjectIdNotFoundException("Project","ID",emp.getProjectId()));
				assignedProject=project.getProjectName();
			}
		}
		return assignedProject;
	}

	

}
