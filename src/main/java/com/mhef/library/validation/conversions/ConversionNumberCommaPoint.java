package com.mhef.library.validation.conversions;

import com.mhef.library.validation.enums.ESystemUnitNumber;

/**
 * @author Henrik Beck
 * @version 0.0.3
 */
public class ConversionNumberCommaPoint {
	public static String convertFromCommaToPoint(String input) {
		return input.replace(",", ".");
	}

	public static String convertFromPointToComma(String input) {
		return input.replace(".", ",");
	}

	public static String convertFromDynamically(ESystemUnitNumber defaultPattern, String input) {
		if (defaultPattern == ESystemUnitNumber.DECIMAL_COMMA) {
			return convertFromPointToComma(input);
		} else if (defaultPattern == ESystemUnitNumber.DECIMAL_POINT) {
			return convertFromCommaToPoint(input);
		} else {
			return "";
		}
	}
}