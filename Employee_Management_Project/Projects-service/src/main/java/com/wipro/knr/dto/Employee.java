package com.wipro.knr.dto;


import java.time.LocalDate;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private Integer id;
    
    private String name;
    private String address;
    private String mobileNumber;
    
    public enum Gender {
    	MALE , FEMALE

    }

    private Gender gender;
    private LocalDate dateOfJoining;
    
    private Integer departmentId;
    
    private Integer projectId;
    
    private Integer salaryId;
    
}