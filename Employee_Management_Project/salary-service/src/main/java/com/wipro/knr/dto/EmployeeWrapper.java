package com.wipro.knr.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeWrapper {
    private Integer id;
    
    private String name;
    
    private Integer departmentId;
    
    private Integer basicSal;
    
}