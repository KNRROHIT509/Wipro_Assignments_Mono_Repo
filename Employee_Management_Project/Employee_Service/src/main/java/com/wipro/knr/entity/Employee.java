package com.wipro.knr.entity;


import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String name;
    private String address;
    private String mobileNumber;
    private Gender gender;
    private LocalDate dateOfJoining;
    
    private Integer departmentId;
    
    private Integer salaryId;
    
    private Integer projectId;
    
    private String errorMessage;
}