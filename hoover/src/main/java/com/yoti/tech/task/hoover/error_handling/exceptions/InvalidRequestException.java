package com.yoti.tech.task.hoover.error_handling.exceptions;

public class InvalidRequestException extends Exception {

	private static final long serialVersionUID = -6017057542892085594L;
	private static final String DEFAULT_MESSAGE = "Invalid Request";
			
	public InvalidRequestException() {
		super(DEFAULT_MESSAGE);
	}

	public InvalidRequestException(String message) {
		super(message);
	}

}
