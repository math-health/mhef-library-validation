package com.mhef.library.validation.conversions;

import java.util.HashMap;

/**
 * @author Henrik Beck
 * @version 0.0.3
 */
public class ConversionNumberDecimalRoman {
	private static final HashMap<Character, Integer> romanToDecimal = new HashMap<>();
	private static final HashMap<Integer, String> decimalToRoman = new HashMap<>();

	static {
		romanToDecimal.put('I', 1);
		romanToDecimal.put('V', 5);
		romanToDecimal.put('X', 10);
		romanToDecimal.put('L', 50);
		romanToDecimal.put('C', 100);
		romanToDecimal.put('D', 500);
		romanToDecimal.put('M', 1000);

		decimalToRoman.put(1, "I");
		decimalToRoman.put(4, "IV");
		decimalToRoman.put(5, "V");
		decimalToRoman.put(9, "IX");
		decimalToRoman.put(10, "X");
		decimalToRoman.put(40, "XL");
		decimalToRoman.put(50, "L");
		decimalToRoman.put(90, "XC");
		decimalToRoman.put(100, "C");
		decimalToRoman.put(400, "CD");
		decimalToRoman.put(500, "D");
		decimalToRoman.put(900, "CM");
		decimalToRoman.put(1000, "M");
	}

	public static int fromRomanToDecimal(String roman) {
		int decimal = 0;
		int prevValue = 0;

		for (int i = roman.length() - 1; i >= 0; i--) {
			int currentValue = romanToDecimal.get(roman.charAt(i));

			if (currentValue < prevValue) {
				decimal -= currentValue;
			} else {
				decimal += currentValue;
			}

			prevValue = currentValue;
		}

		return decimal;
	}

	public static String fromDecimalToRoman(int decimal) {
		StringBuilder roman = new StringBuilder();

		int[] decimalValues = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

		for (int value : decimalValues) {
			while (decimal >= value) {
				roman.append(decimalToRoman.get(value));
				decimal -= value;
			}
		}

		return roman.toString();
	}
}