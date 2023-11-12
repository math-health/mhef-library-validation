package com.mhef.library.validation.searches;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Henrik Beck
 * @version 0.0.3
 */
public class SearchList {
	public static List<String> listSearch(List<String> list, String searchString) {
		return list.stream()
			.filter(str -> str.contains(searchString))
			.collect(Collectors.toList());
	}

	public static String listSearchUntilFirstOccurrence(List<String> list, String searchString) {
		return listSearchUntilOccurrence(list, searchString, 1);
	}

	public static String listSearchUntilOccurrence(List<String> list, String searchString, int occurrence) {
		long countOccurrences = 0;

		for (String str : list) {
			if (str.contains(searchString)) {
				if (++countOccurrences == occurrence) {
					// Return the string when the desired occurrence is reached
					return str;
				}
			}
		}

		// Return null if the specified occurrence is not found
		return null;
	}
}
