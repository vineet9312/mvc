package com.javaexpress.cards.config;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "accounts")
@Data
public class CardsServiceConfig {

	private String msg;
	private String buildVersion;
	private Map<String,String> mailDetails;
	private List<String> activeBranches;
	
}
