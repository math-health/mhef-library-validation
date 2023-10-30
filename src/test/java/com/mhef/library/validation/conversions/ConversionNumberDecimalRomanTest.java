package com.mhef.library.validation.conversions;

import org.junit.jupiter.api.Test;

/**
 * @author Henrik Beck
 * @version 0.0.3
 */
import static org.junit.jupiter.api.Assertions.assertEquals;

class ConversionNumberDecimalRomanTest {
	@Test
	public void testFromRomanToDecimal() {
		assertEquals(21, ConversionNumberDecimalRoman.fromRomanToDecimal("XXI"));
		assertEquals(1987, ConversionNumberDecimalRoman.fromRomanToDecimal("MCMLXXXVII"));
		assertEquals(4, ConversionNumberDecimalRoman.fromRomanToDecimal("IV"));
		assertEquals(3999, ConversionNumberDecimalRoman.fromRomanToDecimal("MMMCMXCIX"));
		assertEquals(7, ConversionNumberDecimalRoman.fromRomanToDecimal("VII"));
	}

	@Test
	public void testFromDecimalToRoman() {
		assertEquals("XXI", ConversionNumberDecimalRoman.fromDecimalToRoman(21));
		assertEquals("MCMLXXXVII", ConversionNumberDecimalRoman.fromDecimalToRoman(1987));
		assertEquals("IV", ConversionNumberDecimalRoman.fromDecimalToRoman(4));
		assertEquals("MMMCMXCIX", ConversionNumberDecimalRoman.fromDecimalToRoman(3999));
		assertEquals("VII", ConversionNumberDecimalRoman.fromDecimalToRoman(7));
	}
}