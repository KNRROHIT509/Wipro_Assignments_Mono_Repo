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
public class Salary {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer salaryId;
	
	private Integer basicSal;
	
	private Sal_status status;
	
	private LocalDate paymentDate;
	
	private PaymentMethod payMethod;

}
