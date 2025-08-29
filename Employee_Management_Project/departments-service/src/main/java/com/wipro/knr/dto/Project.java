package com.wipro.knr.dto;


import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {
	
	private Integer projectId;
	
	private String projectName;
	
	private String description;
	
	private LocalDate startDate;
	
	private LocalDate endDate;
	
	public enum Progress {
		PLANNING , INPROGRESS, COMPLETED , CANCELLED

	}
	private Progress progress;
	
	private Integer departmentId;

}
