package com.mhef.library.validation.filters;

import com.mhef.library.validation.searches.SearchList;
import com.mhef.library.validation.utils.UtilSort;

import java.util.List;

/**
 * @author Henrik Beck
 * @version 0.0.3
 */
public class FilterListExtract {
	// Filter the match content from a list according to the occurrence

	public static String getMatchFromSingleLineUntilOccurrenceFirst(List<String> fileContent, String searchTextBegin, String searchTextEnd, String delimiter, int splitIndex) {
		List<String> listAux = FilterList.getListExtractedFromFileSection(fileContent, searchTextBegin, searchTextEnd);
		String[] splitParts = listAux.get(0).split(delimiter);

		// Check if there is at least a second part
		if (splitParts.length > 1) {
			// If splitIndex is a negative value, then the split count becomes reversed from end-to-start
			if (splitIndex < 0) {
				UtilSort.reverseArray(splitParts);
				splitIndex = (splitIndex * -1) - 1;
			}

			return splitParts[splitIndex];
		} else {
			// Handle the case where there is no second part
			return ""; // or throw an exception or handle it in a way that makes sense for your use case
		}
	}

	public static String getMatchFromAllLinesUntilOccurrenceFirst(List<String> fileContent, String searchTextBegin, String searchTextEnd, String delimiter, int splitIndex) {
		List<String> listAux = FilterList.getListExtractedFromFileSection(fileContent, searchTextBegin, searchTextEnd);
		String stringAux = SearchList.listSearchUntilFirstOccurrence(listAux, searchTextEnd);
		String[] splitParts = stringAux.split(delimiter);

		// Check if there is at least a second part
		if (splitParts.length > 1) {
			// If splitIndex is a negative value, then the split count becomes reversed from end-to-start
			if (splitIndex < 0) {
				UtilSort.reverseArray(splitParts);
				splitIndex = (splitIndex * -1) - 1;
			}

			return splitParts[splitIndex];
		} else {
			// Handle the case where there is no second part
			return ""; // or throw an exception or handle it in a way that makes sense for your use case
		}
	}

	public static String getMatchFromAllLinesUntilOccurrenceN(List<String> fileContent, String searchTextBegin, String searchTextEnd, String delimiter, int splitIndex, int occurence) {
		List<String> listAux = FilterList.getListExtractedFromFileSection(fileContent, searchTextBegin, searchTextEnd);
		String result = "";
		int count = 0; // Find all occurrences of searchTextEnd

		for (String line : listAux) {
			if (line.contains(searchTextEnd)) {
				count++;

				if (count == occurence) {
					String stringAux = SearchList.listSearchUntilFirstOccurrence(listAux, searchTextEnd);
					String[] splitParts = stringAux.split(delimiter);

					// Check if there is at least a second part
					if (splitParts.length > 1) {
						// If splitIndex is a negative value, then the split count becomes reversed from end-to-start
						if (splitIndex < 0) {
							UtilSort.reverseArray(splitParts);
							splitIndex = (splitIndex * -1) - 1;
						}

						result = splitParts[splitIndex];
					} else {
						// Handle the case where there is no second part
						result = ""; // or throw an exception or handle it in a way that makes sense for your use case
					}

					break; // Found the nth occurrence, exit the loop
				}
			}
		}

		return result;
	}
}