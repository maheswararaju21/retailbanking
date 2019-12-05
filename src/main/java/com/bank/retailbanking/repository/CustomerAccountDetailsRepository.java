package com.bank.retailbanking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.retailbanking.entity.Customer;
import com.bank.retailbanking.entity.CustomerAccountDetails;

@Repository
public interface CustomerAccountDetailsRepository extends JpaRepository<CustomerAccountDetails, Long> {
	Optional<CustomerAccountDetails> findByCustomerId(Customer customer);
}
