package com.javaexpress.accounts.response;

import java.util.List;

import com.javaexpress.accounts.models.Account;

import lombok.Data;


@Data
public class CustomerDetails {

	
	private Account account ; 
	private 	List<Cards> cardDetails  ; 
	
	
	
}
