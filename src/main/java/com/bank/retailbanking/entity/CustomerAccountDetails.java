package com.bank.retailbanking.entity;



import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Setter
@Getter
@NoArgsConstructor
@SequenceGenerator(name = "accountNumberSequencer", initialValue = 100001, allocationSize = 1)

public class CustomerAccountDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "accountNumberSequencer")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Long accountNumber;
	private String accountType;
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "customerId", nullable = false)
	private Customer customerId;

	private Double availableBalance;
	private LocalDate accountOpeningDate;

}