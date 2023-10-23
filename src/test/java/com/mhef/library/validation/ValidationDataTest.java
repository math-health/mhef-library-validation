package com.mhef.library.validation;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * @author Henrik Beck
 * @version 0.0.2
 */
class ValidationDataTest {
	public static String projectRootPath = "";

	@BeforeAll
	static void loadVariables() {
		projectRootPath = System.getProperty("user.dir");
	}

	@Test
	void isRowContentDataEmptyOrNullable() {
	}

	@Test
	void isThereArguments() {
	}
}