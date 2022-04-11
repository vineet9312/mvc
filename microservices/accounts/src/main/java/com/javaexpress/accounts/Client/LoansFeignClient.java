package com.javaexpress.accounts.Client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.javaexpress.accounts.models.Customer;
import com.javaexpress.accounts.response.Loans;


@FeignClient(name="day13loans")
public interface LoansFeignClient {

	
	@PostMapping(value="/myLoan")
	public List<Loans>fetchLoansData(@RequestBody Customer customer) ; 
	

}
