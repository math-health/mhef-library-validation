package com.mhef.library.validation.utils;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * @author Henrik Beck
 * @version 0.0.2
 */
public class MessageDisplayTest {
	private static String projectRootPath = "";
	private static final String pathFileOrigin = "";
	private static final String pathFileDestiny = "";
	private static final IOException error = new IOException();

	@BeforeAll
	static void setupLoadVariable() {
		projectRootPath = System.getProperty("user.dir");
	}

	@Test
	void displayMessageFileConversionError() {
		MessageDisplay.displayMessageFileConversionError(getPathFileOrigin(), getPathFileDestiny(), getError());
	}

	@Test
	void displayMessageFileConversionSuccess() {
		MessageDisplay.displayMessageFileConversionSuccess(getPathFileOrigin(), getPathFileDestiny());
	}

	@Test
	void displayMessageFileWriteError() {
		MessageDisplay.displayMessageFileWriteError(getPathFileOrigin(), getError());
	}

	@Test
	void displayMessageFileWriteSuccess() {
		MessageDisplay.displayMessageFileConversionSuccess(getPathFileOrigin(), getPathFileDestiny());
	}

	// Getters

	public String getPathFileOrigin() {
		return projectRootPath + pathFileOrigin;
	}

	public String getPathFileDestiny() {
		return projectRootPath + pathFileDestiny;
	}

	public IOException getError() {
		return error;
	}
}