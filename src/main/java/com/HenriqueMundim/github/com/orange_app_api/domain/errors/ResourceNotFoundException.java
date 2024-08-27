package com.HenriqueMundim.github.com.orange_app_api.domain.errors;


public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(String message) {
		super(message);
	}
}
