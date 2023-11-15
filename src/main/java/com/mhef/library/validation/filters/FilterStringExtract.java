package com.mhef.library.validation.filters;

import com.mhef.library.validation.interfaces.IPatternRegex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Henrik Beck
 * @version 0.0.4
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

	/**
	 * <p>Extracts numeric substrings from a given input string and returns them in an array of strings.</p>
	 * <p>This method uses a regular expression to identify and extract sequences of numeric characters
	 * from the input string. The resulting array contains all the numeric substrings found.</p>
	 * <p>For example, given the input string "abc123def456hij789" the method returns ["123", "456", "789"].</p>
	 *
	 * @param input The input string from which numeric substrings will be extracted.
	 * @return An array of strings containing the numeric substrings found in the input string.
	 */
	public static String[] getCharactersNumber(String input, String patternRegex) {
		// Check if the input string is not empty
		if (!input.isEmpty()) {
			// Create a Pattern object
			Pattern regexPattern = Pattern.compile(patternRegex);

			// Create a Matcher object
			Matcher matcher = regexPattern.matcher(input);

			// Create a list to store the matched values
			java.util.List<String> matches = new java.util.ArrayList<>();

			// Find all matches and add them to the list
			while (matcher.find()) {
				matches.add(matcher.group());
			}

			// Convert the list to an array and return it
			return matches.toArray(new String[0]);
		}

		// Return an empty array if the input string is empty
		return new String[0];
	}

	public static double[] getDoubleOnly(String input) {
		String aux[] = getCharactersNumber(input, IPatternRegex.numberDoubleOnly);
		double[] result = new double[aux.length];

		for (int i = 0; i < aux.length; i++) {
			result[i] = Double.parseDouble(aux[i]);
		}

		return result;
	}

	public static int[] getIntegerOnly(String input) {
		String aux[] = getCharactersNumber(input, IPatternRegex.numberIntegerOnly);
		int[] result = new int[aux.length];

		for (int i = 0; i < aux.length; i++) {
			result[i] = Integer.parseInt(aux[i]);
		}

		return result;
	}

	public static double[] getIntegerAndDouble(String input) {
		String aux[] = getCharactersNumber(input, IPatternRegex.numberIntegerAndDouble);
		double[] result = new double[aux.length];

		for (int i = 0; i < aux.length; i++) {
			result[i] = Double.parseDouble(aux[i]);
		}

		return result;
	}
}