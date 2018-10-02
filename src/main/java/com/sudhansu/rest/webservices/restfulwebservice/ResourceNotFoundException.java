package com.sudhansu.rest.webservices.restfulwebservice;

public class ResourceNotFoundException extends RuntimeException {
	public ResourceNotFoundException() {
		this("Resource not found!");
	}

	public ResourceNotFoundException(String message) {
		this(message, null);
	}

	public ResourceNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
