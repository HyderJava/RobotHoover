package com.yoti.tech.task.hoover.error_handling.exceptions;

public class CoordinatesOutOfBoundsException extends InvalidRequestException {

	private static final long serialVersionUID = 2392446976755730324L;
	private static final String DEFAULT_MESSAGE = "Initial coordinates must be inside the room";

	public CoordinatesOutOfBoundsException() {
		super(DEFAULT_MESSAGE);
	}

	public CoordinatesOutOfBoundsException(String message) {
		super(message);
	}

}