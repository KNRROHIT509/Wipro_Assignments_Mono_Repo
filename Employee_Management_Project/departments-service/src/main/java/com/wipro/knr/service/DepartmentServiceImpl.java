package com.wipro.knr.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wipro.knr.dto.Employee;
import com.wipro.knr.dto.Project;
import com.wipro.knr.entity.Department;
import com.wipro.knr.exception.DepartmentIdNotFoundException;
import com.wipro.knr.feign.EmployeeFeignClient;
import com.wipro.knr.feign.ProjectFeignClient;
import com.wipro.knr.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private EmployeeFeignClient employeeFeignClient;
	
	@Autowired
	private ProjectFeignClient projectFeignClient;
	@Override
	public Department save(Department department) {
		// TODO Auto-generated method stub
		return departmentRepository.save(department);
	}

	@Override
	public List<Department> getAll() {
		// TODO Auto-generated method stub
		return departmentRepository.findAll();
	}

	@Override
	public Department update(Integer departmentId, Department department) {
		// TODO Auto-generated method stub
		Department dept=departmentRepository.findById(departmentId).orElseThrow(()->new DepartmentIdNotFoundException("Department","ID",departmentId));
		
		dept.setDepartmentName(department.getDepartmentName());
		dept.setDepartmentCode(department.getDepartmentCode());
		Department updatedDetails=departmentRepository.save(dept);
		return updatedDetails;
	}

	@Override
	public ResponseEntity<String> delete(Integer departmentId) {
		// TODO Auto-generated method stub
		departmentRepository.deleteById(departmentId);
		return ResponseEntity.ok("Department with "+departmentId+" Deleted Successfully");
	}

	@Override
	public Department getById(Integer departmentId) {
		// TODO Auto-generated method stub
		return departmentRepository.findById(departmentId).orElseThrow(()->new DepartmentIdNotFoundException("Department","ID",departmentId));
	}

	@Override
	public List<Employee> getEmployByDept(Integer departmentId) {
		// TODO Auto-generated method stub
		List<Employee> employees=employeeFeignClient.getAllEmployees();
		List<Employee> res = new ArrayList<>();
		for(Employee employee:employees) {
			if(departmentId.equals(employee.getDepartmentId())) {
				res.add(employee);
			}
		}
		return res;
	}

	@Override
	public List<Project> getProjectByDept(Integer departmentId) {
		List<Project> projects=projectFeignClient.getProjects();
		List<Project> res=new ArrayList<>();
		for(Project project:projects) {
			if(departmentId.equals(project.getDepartmentId())) {
				res.add(project);
			}
		}
		return res;
	}
	

}
