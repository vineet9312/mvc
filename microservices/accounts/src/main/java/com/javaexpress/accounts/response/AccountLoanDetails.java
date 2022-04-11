package com.javaexpress.accounts.response;

import java.util.List;

import com.javaexpress.accounts.models.Account;

import lombok.Data;


@Data
public class AccountLoanDetails {

	

	private Account account ; 
	private 	List<Loans> loanDetails  ; 
	
	
	
}
