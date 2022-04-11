/**
 * 
 */
package com.javaexpress.accounts.response;

import java.util.List;

import com.javaexpress.accounts.model.Account;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author EazyBytes
 *
 */
@Getter
@Setter
@ToString
public class CustomerDetails {
	
	private Account accounts;
	private List<Loans> loans;
	private List<Cards> cards;
	
	

}
