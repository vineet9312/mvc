/**
 * 
 */
package com.javaexpress.accounts.controller;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.javaexpress.accounts.client.CardsFeignClient;
import com.javaexpress.accounts.client.LoansFeignClient;
import com.javaexpress.accounts.config.AccountsServiceConfig;
import com.javaexpress.accounts.model.Account;
import com.javaexpress.accounts.model.Customer;
import com.javaexpress.accounts.repository.AccountsRepository;
import com.javaexpress.accounts.response.Cards;
//import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
//import io.github.resilience4j.retry.annotation.Retry;
import com.javaexpress.accounts.response.CustomerDetails;
import com.javaexpress.accounts.response.Loans;
import com.javaexpress.accounts.response.Properties;

@RestController
public class AccountsController {
	
	private static final Logger logger = LoggerFactory.getLogger(AccountsController.class);

	@Autowired
	private AccountsRepository accountsRepository;
	
	@Autowired
	private AccountsServiceConfig accountsConfig;
	
	@Autowired
	LoansFeignClient loansFeignClient;

	@Autowired
	CardsFeignClient cardsFeignClient;
	
	static int count=0;


	@PostMapping("/myAccount")
	public Account getAccountDetails(@RequestBody Customer customer) {
		Account accounts = accountsRepository.findByCustomerId(customer.getCustomerId());
		if (accounts != null) {
			return accounts;
		} else {
			return null;
		}

	}
	
	@GetMapping("/account/properties")
	public Properties getPropertyDetails() throws JsonProcessingException {
		Properties properties = new Properties(accountsConfig.getMsg(), accountsConfig.getBuildVersion(),
				accountsConfig.getMailDetails(), accountsConfig.getActiveBranches());
		return properties;
	}
	
	
	@PostMapping("/myCustomerDetails")
	//@CircuitBreaker(name = "detailsForCustomerSupportApp",fallbackMethod ="myCustomerDetailsFallBack")
	//@Retry(name = "retryForCustomerDetails", fallbackMethod = "myCustomerDetailsFallBack")
	public CustomerDetails myCustomerDetails(@RequestBody Customer customer) {
		logger.info("myCustomerDetails() method started "+count++);
		Account accounts = accountsRepository.findByCustomerId(customer.getCustomerId());
		List<Cards> cards = cardsFeignClient.getCardDetails(customer);
		List<Loans> loans = loansFeignClient.getLoansDetails(customer);
		
		CustomerDetails customerDetails = new CustomerDetails();
		customerDetails.setAccounts(accounts);
		customerDetails.setLoans(loans);
		customerDetails.setCards(cards);
		logger.info("myCustomerDetails() method ended");
		return customerDetails;

	}
	
	/*
	private CustomerDetails myCustomerDetailsFallBack(Customer customer, Throwable t) {
		Account accounts = accountsRepository.findByCustomerId(customer.getCustomerId());
		List<Loans> loans = loansFeignClient.getLoansDetails(customer);
		CustomerDetails customerDetails = new CustomerDetails();
		customerDetails.setAccounts(accounts);
		customerDetails.setLoans(loans);
		return customerDetails;

	}
	*/
		
}
