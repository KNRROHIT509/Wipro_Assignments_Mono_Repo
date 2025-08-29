package com.wipro.knr.dto;

import java.time.LocalDate;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Salary {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer salaryId;
	
	private Integer basicSal;
	public enum Sal_status {
		PENDING , PAID, HOLD
	}

	
	private Sal_status status;
	
	private LocalDate paymentDate;
	public enum PaymentMethod {
		BANK_TRANSFER, CHECK , CASH , UPI_PAYMENTS
	}

	
	private PaymentMethod payMethod;

}
