package com.yoti.tech.task.hoover.error_handling.exceptions;

public class PatchesOutOfBoundsException extends InvalidRequestException {

	private static final long serialVersionUID = 2392446976755730324L;
	private static final String DEFAULT_MESSAGE = "Patches must be inside the room";

	public PatchesOutOfBoundsException() {
		super(DEFAULT_MESSAGE);
	}

	public PatchesOutOfBoundsException(String message) {
		super(message);
	}

}