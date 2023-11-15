package com.mhef.library.validation.filters;

import com.mhef.library.validation.interfaces.IPatternRegex;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Henrik Beck
 * @version 0.0.4
 */
class FilterStringExtractTest {
	private static String inputAlphaNumericDouble = "abc123.321def456.654ghi789.987";
	private static String inputAlphaNumericInteger = "abc123def456ghi789";
	private static String inputAlphaNumericIntegerAndDouble = "abc123def456.654ghi789";
	private static String inputEmpty = "";

	@Test
	void testGetCharactersAlphabetic() {
		assertEquals("abcdefghi", FilterStringExtract.getCharactersAlphabetic(inputAlphaNumericInteger));
	}

	@Test
	void testGetCharactersNumber() {
		// Support integer
		assertArrayEquals(new String[]{"123", "456", "789"}, FilterStringExtract.getCharactersNumber(inputAlphaNumericInteger, IPatternRegex.numberIntegerOnly));
		assertArrayEquals(new String[]{"123", "321", "456", "654", "789", "987"}, FilterStringExtract.getCharactersNumber(inputAlphaNumericDouble, IPatternRegex.numberIntegerOnly));

		// Support float
		assertArrayEquals(new String[]{"123.321", "456.654", "789.987"}, FilterStringExtract.getCharactersNumber(inputAlphaNumericDouble, IPatternRegex.numberDoubleOnly));

		// Empty values
		assertArrayEquals(new String[]{}, FilterStringExtract.getCharactersNumber(inputEmpty, IPatternRegex.numberIntegerAndDouble));
	}

	@Test
	void testGetDoubleOnly() {
		assertArrayEquals(new double[]{}, FilterStringExtract.getDoubleOnly(inputEmpty));
		assertArrayEquals(new double[]{123.321, 456.654, 789.987}, FilterStringExtract.getDoubleOnly(inputAlphaNumericDouble));
		assertArrayEquals(new double[]{456.654}, FilterStringExtract.getDoubleOnly(inputAlphaNumericIntegerAndDouble));
	}

	@Test
	void testGetIntegerOnly() {
		assertArrayEquals(new int[]{}, FilterStringExtract.getIntegerOnly(inputEmpty));
		assertArrayEquals(new int[]{123, 456, 789}, FilterStringExtract.getIntegerOnly(inputAlphaNumericInteger));
		assertArrayEquals(new int[]{123, 456, 654, 789}, FilterStringExtract.getIntegerOnly(inputAlphaNumericIntegerAndDouble));
	}

	@Test
	void testGetIntegerAndDouble() {
		// Empty values
		assertArrayEquals(new double[]{}, FilterStringExtract.getDoubleOnly(inputEmpty));

		// Support integer
		assertArrayEquals(new double[]{123, 456, 789}, FilterStringExtract.getIntegerAndDouble(inputAlphaNumericInteger));

		// Support double
		assertArrayEquals(new double[]{123.321, 456.654, 789.987}, FilterStringExtract.getIntegerAndDouble(inputAlphaNumericDouble));
		assertArrayEquals(new double[]{123, 456.654, 789}, FilterStringExtract.getIntegerAndDouble(inputAlphaNumericIntegerAndDouble));
	}
}