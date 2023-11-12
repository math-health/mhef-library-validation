package com.mhef.library.validation.exceptions;

/**
 * @author Henrik Beck
 * @version 0.0.3
 */
public class ExceptionEmptyDocument extends Exception {
	public ExceptionEmptyDocument() {
		super("Document file is empty");
	}

	public ExceptionEmptyDocument(String message) {
		super(message);
	}
}