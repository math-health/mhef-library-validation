package com.mhef.library.validation.exceptions;

/**
 * @author Henrik Beck
 * @version 0.0.3
 */
public class ExceptionEmptyString extends Exception {
	public ExceptionEmptyString() {
		super("String cannot be empty");
	}

	public ExceptionEmptyString(String message) {
		super(message);
	}
}