package com.meritamerica.assignment7.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {
	
	
	@GetMapping("/")
	public String home() {
		return ("<h1>Bank Application</h2>" + "<h2>This is normal. You should use postman or the like for GETting and PUSHing data.</h2>" +
				"<div><a href='/AccountHolders'>Account Holders</a> (Administrators Only) </div>");
	}
	
}
