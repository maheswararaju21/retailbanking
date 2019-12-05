package com.bank.retailbanking.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AccountSummaryResponsedto {
	Integer statusCode;
	String statusMessage;
	private List<AccountSummaryResponse> transactions;
}
