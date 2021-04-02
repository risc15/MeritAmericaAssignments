package com.meritamerica.assignment5.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends Exception{
	
	public NotFoundException(String msg) {
		super(msg);
	}

}
