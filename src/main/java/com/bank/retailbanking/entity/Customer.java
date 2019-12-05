package com.bank.retailbanking.entity;



import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Setter
@Getter
@NoArgsConstructor
@SequenceGenerator(name = "customerIdSequencer", initialValue = 1001, allocationSize = 1)
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customerIdSequencer")
	private Long customerId;
	private String customerEmail;
	private String password;
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	private String gender;
	private Long mobile;

}
