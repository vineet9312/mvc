/**
 * 
 */
package com.javaexpress.cards.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.javaexpress.cards.config.CardsServiceConfig;
import com.javaexpress.cards.models.Cards;
import com.javaexpress.cards.models.Customer;
import com.javaexpress.cards.repos.CardsRepository;
import com.javaexpress.cards.response.Properties;

import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
public class CardsController {

	private static final Logger logger = LoggerFactory.getLogger(CardsController.class);
	
	@Autowired
	private CardsRepository cardsRepository;
	
	@Autowired
	private CardsServiceConfig cardConfig;

	@PostMapping("/myCards")
	public List<Cards> getCardDetails(@RequestBody Customer customer) {
		//logger.info("getCardDetails() method started");
		log.info( "getCardDetails method started ") ; 
		List<Cards> cards = cardsRepository.findByCustomerId(customer.getCustomerId());
		logger.info("getCardDetails() method ended");
		if (cards != null) {
			return cards;
		} else {
			return null;
		}

	}
	
	@GetMapping("/cards/properties")
	public Properties getPropertyDetails() throws JsonProcessingException {
		Properties properties = new Properties(cardConfig.getMsg(), cardConfig.getBuildVersion(),
				cardConfig.getMailDetails(), cardConfig.getActiveBranches());
		return properties;
	}

}
