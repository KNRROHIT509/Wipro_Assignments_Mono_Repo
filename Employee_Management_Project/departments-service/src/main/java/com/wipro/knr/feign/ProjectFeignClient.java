package com.wipro.knr.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.wipro.knr.dto.Project;


@FeignClient(name="projects-service")
public interface ProjectFeignClient {
	@GetMapping("/api/projects/getAllProjects")
	public List<Project> getProjects();
	
	@GetMapping("/api/projects/getProjectById/{projectId}")
	public Project getProjectById(@PathVariable Integer projectId);
}
