package com.nt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("home")
public class ActuatorController {

	@GetMapping("actuator")
	public String display()
	{
		
		return "this is too awesome" ; 
	}
	
	
	
}
