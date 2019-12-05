package com.bank.retailbanking.controller;

import java.text.ParseException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.retailbanking.dto.AccountSummaryResponsedto;
import com.bank.retailbanking.service.TransactionService;

import lombok.extern.slf4j.Slf4j;

/**
 * The {@code TransactionController} class responsible for diplaying all the
 * transactions which are fetched by the resprected layers from the db
 * 
 * @author maheswraraju
 * @since JDK1.8
 */

@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RestController
@RequestMapping("/transactions")
@Slf4j
public class TransactionController {
	@Autowired
	TransactionService transactionService;
	/*
	 * this method is responible for calling the service layes and in return it
	 * fetches AccountsSummaryObject. finally it displays the transactions data with
	 * the respective statuc codes
	 */

	@GetMapping("{customerId}/{month}")
	public ResponseEntity<Optional<AccountSummaryResponsedto>> fetchTransactionsByMonth(
			@RequestParam("customerId") Long customerId, @RequestParam("month") String month) throws ParseException {
		log.info("fetch fetchTransactionsByMonth() is called");
		Optional<AccountSummaryResponsedto> accountSummaryResponsedtoList = transactionService
				.fetchTransactionsByMonth(customerId, month);

		accountSummaryResponsedtoList.get().setStatusCode(HttpStatus.OK.value());
		accountSummaryResponsedtoList.get().setStatusMessage("Success");
		return new ResponseEntity<>(accountSummaryResponsedtoList, HttpStatus.OK);
	}

}
