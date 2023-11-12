package com.mhef.library.validation.filters;

import com.mhef.library.validation.searches.SearchList;

import java.util.Collections;
import java.util.List;

/**
 * @author Henrik Beck
 * @version 0.0.3
 */
public class FilterList {
	// Get the index

	/**
	 * Searches for a specified value within a List of Strings, starting from a specific index and ignoring values before that index.
	 *
	 * @param listContent             The List of Strings to search in.
	 * @param searchTextMatch  The value to search for.
	 * @param searchIndexStart The index from which the search should begin.
	 * @return The index of the first occurrence of the specified value within the list, starting from the specified index. Returns -1 if the value is not found or if the startIndex is out of the valid range for the list.
	 */
	public static int getIndexOfFromListSinceStartIndex(List<String> listContent, String searchTextMatch, int searchIndexStart) {
		// If searchIndexStart value is invalid, then the search should start from the beginning of the list
		if (searchIndexStart == -1) {
			searchIndexStart = 0;
		}

		if (searchIndexStart >= 0 && searchIndexStart < listContent.size()) {
			List<String> listAux = SearchList.listSearch(listContent, searchTextMatch);

			if (!listAux.isEmpty()) {
				String searchTextMatchAux = listAux.get(0);
				int index = listContent.subList(searchIndexStart, listContent.size()).indexOf(searchTextMatchAux);

				if (index != -1) {
					// If the value is found, adjust the index to account for the sublist
					return index + searchIndexStart;
				}
			}
		}

		/**
		 * Value not found or invalid {@link @param searchIndexStart}
		 */
		return -1;
	}

	/**
	 * Find the indexes of the beginning and ending values in the list.
	 *
	 * @param listContent     The list containing the lines from the document file.
	 * @param searchTextBegin The line content to be match for validating where the document file section should start.
	 * @param searchTextEnd   The line content to be match for validating where the document file section should end.
	 * @return The integer array with the beginning and ending match values in the list.
	 */
	public static int[] getIndexOfFromListSectionInterval(List<String> listContent, String searchTextBegin, String searchTextEnd) {
		int[] result = new int[2];

		// Get the line where the first occurrence of the string value is contained
		result[0] = getIndexOfFromListSinceStartIndex(listContent, searchTextBegin, 0);

		// Guarantee the index starts from where the result[0] value was found.
		result[1] = getIndexOfFromListSinceStartIndex(listContent, searchTextEnd, result[0]);

		return result;
	}

	// @todo Create JavaDoc.
	public static int[] getIndexOfFromListSectionInterval(List<String> listContent, String searchTextBegin) {
		int[] result = new int[2];

		result[0] = listContent.indexOf(searchTextBegin);
		result[1] = getIndexOfFromListSinceStartIndex(listContent, searchTextBegin, listContent.size());

		return result;
	}

	// Get the list
	/**
	 * Extracts a sub-list of values from a List of Strings, starting from a specified start index (inclusive) and ending at a specified end index (inclusive).
	 *
	 * @param listContent The list containing the lines from the document file to extract values.
	 * @param searchIndexBegin The index of the list where the extraction should start.
	 * @param searchIndexEnd The index of the list where the extraction should end.
	 * @return A List of Strings containing the extracted values from a start to an end indexes, inclusive. Returns an empty list if the indices are invalid or out of range.
	 */
	public static List<String> getListExtractedFromFileSection(List<String> listContent, int searchIndexBegin, int searchIndexEnd) {
		if (searchIndexBegin >= listContent.size()) {
			searchIndexBegin = listContent.size() - 1;
		}

		if (searchIndexEnd >= listContent.size()) {
			searchIndexEnd = listContent.size() - 1;
		}

		if (searchIndexBegin >= 0 && searchIndexBegin < listContent.size() && searchIndexEnd >= searchIndexBegin && searchIndexEnd < listContent.size()) {
			// Add 1 to endIndex to include it in the result
			return listContent.subList(searchIndexBegin, searchIndexEnd + 1);
		}

		// Return an empty list for invalid indices
		return Collections.emptyList();
	}

	/**
	 * Extracts a sub-list of values from a List of Strings, starting from a specified start index (inclusive) and ending at a specified end index (inclusive).
	 *
	 * @param listContent The list containing the lines from the document file to extract values.
	 * @param searchTextBegin The match value of the list where the extraction should start.
	 * @param searchTextEnd The match value of the list where the extraction should end.
	 * @return The list containing only the lines extracted from a specific document file section.
	 */
	public static List<String> getListExtractedFromFileSection(List<String> listContent, String searchTextBegin, String searchTextEnd) {
		int[] listRange = getIndexOfFromListSectionInterval(listContent, searchTextBegin, searchTextEnd);

		return getListExtractedFromFileSection(listContent, listRange[0], listRange[1]);
	}

	// @todo Create JavaDoc.
	public static List<String> getListExtractedFromFileSection(List<String> listContent, String searchTextBegin) {
		int[] listRange = getIndexOfFromListSectionInterval(listContent, searchTextBegin);

		return getListExtractedFromFileSection(listContent, listRange[0], listContent.size() - 1);
	}
}