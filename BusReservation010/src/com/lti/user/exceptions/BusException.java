package com.lti.user.exceptions;

public class BusException extends Exception {

	public BusException(String message, Throwable cause) {
		super(message, cause);
	}

	public BusException(String message) {
		super(message);
	}

	public BusException(Throwable cause) {
		super(cause);
	}
	
	

}
