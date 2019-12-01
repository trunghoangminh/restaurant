package com.trunghoang.restaurant.exceptions;

/**
 * 
 * This class represent for exception of application. If the new exception is
 * created then should be extend this class
 *
 */
public class ApplicationException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor
	 */
	public ApplicationException() {

	}

	public ApplicationException(String message) {
		super(message);
	}
}
