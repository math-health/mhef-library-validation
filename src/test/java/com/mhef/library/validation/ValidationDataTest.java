package com.mhef.library.validation;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * @author Henrik Beck
 * @version 0.0.2
 *
 * @todo Must test the isRowContentDataEmptyOrNullable method.
 * @todo Must test the isThereArguments method.
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