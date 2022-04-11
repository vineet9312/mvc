package com.javaexpress.accounts.Client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.javaexpress.accounts.models.Customer;
import com.javaexpress.accounts.response.Cards;

@FeignClient(name="cards")
public interface CardsFeignClient {

	
	@PostMapping("/myCards")
	public List<Cards> getCardDetails(@RequestBody Customer customer) ; 

}
