package com.bank.retailbanking.service;

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

import com.bank.retailbanking.dto.AccountSummaryResponsedto;
import com.bank.retailbanking.entity.Customer;
import com.bank.retailbanking.entity.CustomerAccountDetails;
import com.bank.retailbanking.entity.CustomerTransactions;
import com.bank.retailbanking.exception.TransactionException;
import com.bank.retailbanking.repository.CustomerAccountDetailsRepository;
import com.bank.retailbanking.repository.CustomerRepository;
import com.bank.retailbanking.repository.CustomerTransactionsRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class TransactionServiceImplTest {
	@Mock
	CustomerRepository customerRepository;
	@Mock
	CustomerAccountDetailsRepository customerAccountDetailsRepository;
	@Mock
	CustomerTransactionsRepository customerTransactionsRepository;

	@InjectMocks
	TransactionServiceImpl transactionServiceImpl;
	List<CustomerTransactions> cuTransactionsList = new ArrayList<>();
	CustomerAccountDetails cuAccountDetails = new CustomerAccountDetails();
	Customer customer = new Customer();
	CustomerAccountDetails customerAccountDetails = new CustomerAccountDetails();
	List<CustomerTransactions> customerTransactionsList = new ArrayList<>();
	CustomerTransactions customerTransactions = null;

	@Before
	public void setUp() {
		customerTransactions = new CustomerTransactions();

		customer.setCustomerId(101L);
		customerAccountDetails.setAccountNumber(3241L);
		customerAccountDetails.setAccountOpeningDate(LocalDate.now());
		customerAccountDetails.setAccountType("savings");
		customerAccountDetails.setAvailableBalance(3452.87);

		customerTransactions.setTransactionAmount(4567.00);
		customerTransactions.setTransactionComments("useful");
		customerTransactions.setTransactionDate(LocalDate.parse("2019-11-09"));
		customerTransactions.setTransactionStatus("success");
		customerTransactions.setTransactionType("debit");
		customerTransactionsList.add(customerTransactions);

	}

	@Test
	public void fetchTransactionsByMonth() throws ParseException, TransactionException {

		Mockito.when(customerRepository.findById(101L)).thenReturn(Optional.of(customer));
		Mockito.when(customerAccountDetailsRepository.findByCustomerId(customer))
				.thenReturn(Optional.of(customerAccountDetails));
		Mockito.when(customerTransactionsRepository.findByAccountNumber(customerAccountDetails))
				.thenReturn(customerTransactionsList);
		Optional<AccountSummaryResponsedto> accountSummaryResponsedto = transactionServiceImpl
				.fetchTransactionsByMonth(101L, "november");
		Assert.assertNotNull(accountSummaryResponsedto);
	}

	@Test(expected = TransactionException.class)
	public void fetchTransactionsByMonthNegative() throws ParseException, TransactionException {

		Optional<AccountSummaryResponsedto> accountSummaryResponsedto = transactionServiceImpl
				.fetchTransactionsByMonth(101L, "december");
		Assert.assertNotNull(accountSummaryResponsedto);
	}

	@Test(expected = TransactionException.class)
	public void fetchTransactionsByMonthwithoutcustomerAccountDetails() throws ParseException, TransactionException {
		Mockito.when(customerRepository.findById(101L)).thenReturn(Optional.of(customer));
		Mockito.when(customerAccountDetailsRepository.findByCustomerId(customer))
				.thenReturn(Optional.of(customerAccountDetails));
		Mockito.when(customerTransactionsRepository.findByAccountNumber(customerAccountDetails))
				.thenReturn(customerTransactionsList);
		Optional<AccountSummaryResponsedto> accountSummaryResponsedto = transactionServiceImpl
				.fetchTransactionsByMonth(105L, "november");
	}
}
