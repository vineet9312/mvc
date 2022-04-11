package com.javaexpress.cards.response;

import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Properties {

	private String message;
	private String version;
	private Map<String,String> mailDetails;
	private List<String> activeBranches;
	
	public Properties(String msg, String buildVersion, Map<String, String> mailDetails, List<String> activeBranches) {
		super();
		this.message = msg;
		this.version = buildVersion;
		this.mailDetails = mailDetails;
		this.activeBranches = activeBranches;
	}
	
	
}
