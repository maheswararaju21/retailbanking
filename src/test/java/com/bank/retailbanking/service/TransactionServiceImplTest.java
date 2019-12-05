package com.bank.retailbanking.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.bank.retailbanking.repository.CustomerAccountDetailsRepository;
import com.bank.retailbanking.repository.CustomerRepository;
import com.bank.retailbanking.repository.CustomerTransactionsRepository;

@RunWith(MockitoJUnitRunner.class)
public class TransactionServiceImplTest {
	@Mock
	CustomerRepository customerRepository;
	@Mock
	CustomerAccountDetailsRepository customerAccountDetailsRepository;
	@Mock
	CustomerTransactionsRepository customerTransactionsRepository;

	@Test
	public void fetchTransactionsByMonth() {

	}
}
