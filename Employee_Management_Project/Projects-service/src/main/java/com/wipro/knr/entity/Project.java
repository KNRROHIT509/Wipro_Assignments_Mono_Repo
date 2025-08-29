package com.wipro.knr.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer projectId;
	
	private String projectName;
	
	private String description;
	
	private LocalDate startDate;
	
	private LocalDate endDate;
	
	private Progress progress;
	
	private Integer departmentId;

}
