package com.mhef.library.validation.conversions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Henrik Beck
 * @version 0.0.4
 */
public class ConversionStringList {
	public static String convertFromListToString(List<String> input) {
		String result = null;

		for (int i = 0; i < input.size(); i++) {
			result += input.get(i);

			if (i != input.size() - 1) {
				result += "\n";
			}
		}

		return result;
	}

	public static List<String> convertFromStringToList(String input, boolean hasBlankCharsOnEndOfLine) {
		List<String> resultList = null;
		Stream<String> lines = null;

		// Use a Stream to split the input string into lines
		lines = Arrays.stream(input.split("\\n")); // You can use "\\r?\\n" for Windows line endings

		if (hasBlankCharsOnEndOfLine == true) {
			// Collect the lines into a List
			resultList = lines.collect(Collectors.toList());
		} else {
			// Collect the lines into a List and remove trailing blanks
			resultList = lines.map(line -> line.replaceAll("\\s+$", "")).collect(Collectors.toList());
		}

		return resultList;
	}
}