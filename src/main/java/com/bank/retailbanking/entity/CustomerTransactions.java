package com.bank.retailbanking.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CustomerTransactions {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long transactionId;
	private String transactionType;

	@Override
	public String toString() {
		return "CustomerTransactions [transactionId=" + transactionId + ", transactionType=" + transactionType
				+ ", accountNumber=" + accountNumber + ", transactionAmount=" + transactionAmount + ", transactionDate="
				+ transactionDate + ", transactionStatus=" + transactionStatus + ", transactionComments="
				+ transactionComments + "]";
	}

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "accountNumber", nullable = false)
	private CustomerAccountDetails accountNumber;

	private Double transactionAmount;
	private LocalDate transactionDate;
	private String transactionStatus;
	private String transactionComments;
}
