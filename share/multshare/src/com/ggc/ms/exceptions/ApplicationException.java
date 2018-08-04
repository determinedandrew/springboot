package com.ggc.ms.exceptions;

@SuppressWarnings("serial")
public class ApplicationException extends RuntimeException{
	
	public ApplicationException() {		
	}
	
	public ApplicationException(String msg) {
		super(msg);
	}
	
}
