package com.mhef.library.validation.conversions;

import com.mhef.library.validation.enums.ESystemUnitNumber;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Henrik Beck
 * @version 0.0.3
 */
public class ConversionNumberCommaPointTest {
	private static ESystemUnitNumber defaultSystemBrl = ESystemUnitNumber.DECIMAL_COMMA;
	private static ESystemUnitNumber defaultSystemUsa = ESystemUnitNumber.DECIMAL_POINT;
	private static String decimalWithComma = "3,14";
	private static String decimalWithPoint = "3.14";

	@Test
	void testConvertFromCommaToPoint() {
		assertEquals(decimalWithPoint, ConversionNumberCommaPoint.convertFromCommaToPoint(decimalWithComma));
		assertEquals(decimalWithPoint, ConversionNumberCommaPoint.convertFromCommaToPoint(decimalWithPoint));
	}

	@Test
	void testConvertFromPointToComma() {
		assertEquals(decimalWithComma, ConversionNumberCommaPoint.convertFromPointToComma(decimalWithComma));
		assertEquals(decimalWithComma, ConversionNumberCommaPoint.convertFromPointToComma(decimalWithPoint));
	}

	@Test
	void testConvertFromDynamically() {
		assertEquals(decimalWithComma, ConversionNumberCommaPoint.convertFromDynamically(defaultSystemBrl, decimalWithComma));
		assertEquals(decimalWithComma, ConversionNumberCommaPoint.convertFromDynamically(defaultSystemBrl, decimalWithPoint));

		assertEquals(decimalWithPoint, ConversionNumberCommaPoint.convertFromDynamically(defaultSystemUsa, decimalWithComma));
		assertEquals(decimalWithPoint, ConversionNumberCommaPoint.convertFromDynamically(defaultSystemUsa, decimalWithPoint));
	}
}