package com.mhef.library.validation.filters;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Henrik Beck
 * @version 0.0.3
 */
public class FilterStringExtract {
	public static String getCharactersAlphabetic(String input) {
		// Use regular expression to match only alphabetic characters (A-Z, a-z)
		Pattern pattern = Pattern.compile("[a-zA-Z]");
		Matcher matcher = pattern.matcher(input);

		// Build a string with matched alphabetic characters
		StringBuilder result = new StringBuilder();

		while (matcher.find()) {
			result.append(matcher.group());
		}

		return result.toString();
	}

	public static String getCharactersNumberOnlyLatestDigits(String input) {
		// Define the regular expression pattern to match numbers at the end of the string
		Pattern pattern = Pattern.compile("\\d+$");
		Matcher matcher = pattern.matcher(input);

		// Check if there is a match
		if (matcher.find()) {
			// Return the matched numbers
			return matcher.group();
		} else {
			// Return an empty string if no match is found
			return "";
		}
	}
}