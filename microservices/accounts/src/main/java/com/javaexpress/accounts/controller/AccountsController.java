 package com.javaexpress.accounts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaexpress.accounts.Client.CardsFeignClient;
import com.javaexpress.accounts.Client.LoansFeignClient;
import com.javaexpress.accounts.config.AccountsServiceConfig;
import com.javaexpress.accounts.models.Account;
import com.javaexpress.accounts.models.Customer;
import com.javaexpress.accounts.repos.AccountsRepository;
import com.javaexpress.accounts.response.AccountLoanDetails;
import com.javaexpress.accounts.response.Cards;
import com.javaexpress.accounts.response.CustomerDetails;
import com.javaexpress.accounts.response.Loans;
import com.javaexpress.accounts.response.Properties;


@RestController
public class AccountsController {

	@Autowired
	private AccountsRepository accountsRepository;
	
	@Autowired
	private AccountsServiceConfig accountsServiceConfig;
	
	@Autowired
	private CardsFeignClient iCardsClient ; 
	
	@Autowired
	private LoansFeignClient loansFeignClient ; 
	
	@PostMapping(value="/myAccount")
	public Account fetchAccountDetails(@RequestBody Customer customer) {
		// retrieve account information using customerId
		Account account = accountsRepository.findByCustomerId(customer.getCustomerId());
		if(account != null) {
			return account;
		}else {
			return null;
		}
	}
	
	@GetMapping("/account/properties")
	public Properties getPropertyDetails() {
		return new Properties(accountsServiceConfig.getMsg(), accountsServiceConfig.getBuildVersion(),
				accountsServiceConfig.getMailDetails(), accountsServiceConfig.getActiveBranches());
	}
	
	@PostMapping(value="/myAccountDetails")
	public CustomerDetails fetchAccountCardsDetails(@RequestBody Customer customer) {
		// retrieve account information using customerId
		Account account = accountsRepository.findByCustomerId(customer.getCustomerId());
		List<Cards> cardDetails = iCardsClient.getCardDetails(customer) ;
			CustomerDetails customerDetails = new CustomerDetails() ; 
			customerDetails.setAccount(account) ; 
			customerDetails.setCardDetails(cardDetails) ; 
			return customerDetails ; 
	}
	
			
		
	@PostMapping(value="/myAccountLoansDetails")
	public AccountLoanDetails  fetchAccountLoansDetails(@RequestBody Customer customer)
	{
		Account account = accountsRepository.findByCustomerId(customer.getCustomerId());
		//List<Loans> d = service.findByLoanNo(customer);
		
		List<Loans> fetchLoansData = loansFeignClient.fetchLoansData(customer);
	
		AccountLoanDetails accountLoanDetails =  new AccountLoanDetails() ; 
		
		accountLoanDetails.setAccount(account) ; 
		accountLoanDetails.setLoanDetails(fetchLoansData) ; 
		return accountLoanDetails ; 
		
	
	}
			
			
			
	
	

}

