package com.mhef.library.validation.filters;

/**
 * @author Henrik Beck
 * @version 0.0.3
 */
public class FilterStringSpaceEmpty {
	public static String removeEmptySpacesFromBeginAndStart(String input) {
		String aux = removeEmptySpacesFromBegin(input);

		return removeEmptySpacesFromEnd(aux);
	}

	public static String removeEmptySpacesFromBegin(String input) {
		int i = 0;

		while (i < input.length() && input.charAt(i) == ' ') {
			i++;
		}

		return input.substring(i);
	}

	public static String removeEmptySpacesFromEnd(String input) {
		int i = input.length() - 1;

		while (i >= 0 && input.charAt(i) == ' ') {
			i--;
		}

		return input.substring(0, i + 1);
	}
}