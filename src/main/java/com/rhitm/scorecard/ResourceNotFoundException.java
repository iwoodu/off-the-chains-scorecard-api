package com.rhitm.scorecard;

/**
 * Indicates a resource was not found.
 *
 */
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1465833374378431642L;

	public ResourceNotFoundException(String message) {
		super(message);
	}

}
