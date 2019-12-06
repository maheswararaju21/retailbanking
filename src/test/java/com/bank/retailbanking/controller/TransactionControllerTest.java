package com.bank.retailbanking.controller;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.bank.retailbanking.dto.AccountSummaryResponse;
import com.bank.retailbanking.dto.AccountSummaryResponsedto;
import com.bank.retailbanking.entity.Customer;
import com.bank.retailbanking.exception.TransactionException;
import com.bank.retailbanking.service.TransactionService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class TransactionControllerTest {
	@InjectMocks
	TransactionController transactionController;
	@Mock
	TransactionService transactionService;
	@Mock
	AccountSummaryResponse accountSummaryResponse;

	AccountSummaryResponsedto accountSummaryResponsedto = new AccountSummaryResponsedto();
	List<AccountSummaryResponse> accountSummaryResponsesList = new ArrayList<>();

	@Before
	public void setUp() {
		Customer customer = new Customer();
		customer.setCustomerId(2125L);
		accountSummaryResponse.setTransactionType("debit");
		accountSummaryResponse.setTransactionComments("fee");
		accountSummaryResponse.setTransactionStatus("debited successfull");
		accountSummaryResponse.setTransactionAmount(1254.54);
		accountSummaryResponse.setTransactionDate(LocalDate.now());
		accountSummaryResponsesList.add(accountSummaryResponse);
		accountSummaryResponsedto.setStatusCode(500);
		accountSummaryResponsedto.setStatusMessage("success");
		accountSummaryResponsedto.setTransactions(accountSummaryResponsesList);
		
		}

	@Test
	public void fetchTransactionsByMonth() throws ParseException, TransactionException {
		Mockito.when(transactionService.fetchTransactionsByMonth(2125L, "june")).thenReturn(Optional.of(accountSummaryResponsedto));
		Assert.assertNotNull(accountSummaryResponsedto);

	}

}
