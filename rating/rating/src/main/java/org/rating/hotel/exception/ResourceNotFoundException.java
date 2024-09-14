package org.rating.hotel.exception;

public class ResourceNotFoundException extends RuntimeException  {
	public ResourceNotFoundException() {
		super("Resource not Found!!!");
	}

	public ResourceNotFoundException(String message) {
		super(message);
	}

}
