package com.mhef.library.validation.filters;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Henrik Beck
 * @version 0.0.3
 */
class FilterListTest {
	private static List<String> fileContent = new ArrayList<>();

	@BeforeAll
	static void setupLoadVariables() {
		fileContent = Arrays.asList("line1", "line2", "line3", "line4", "line5");
	}

	@Test
	void testGetIndexOfFromListSinceStartIndex() {
		List<String> list = Arrays.asList( "apple", "banana", "orange", "grape" );

		// Test when searchTextMatch exists in the list and the entire line is explicit
		assertEquals(2, FilterList.getIndexOfFromListSinceStartIndex(list, "orange", 0));
		assertEquals(2, FilterList.getIndexOfFromListSinceStartIndex(list, "orange", 1));

		// Test when searchTextMatch exists in the list but only the containing values from the line is declared
		assertEquals(2, FilterList.getIndexOfFromListSinceStartIndex(list, "ran", 0));
		assertEquals(2, FilterList.getIndexOfFromListSinceStartIndex(list, "ran", 1));

		// Test when searchTextMatch does not exist in the list
		assertEquals(-1, FilterList.getIndexOfFromListSinceStartIndex(list, "pear", 0));
		assertEquals(-1, FilterList.getIndexOfFromListSinceStartIndex(list, "pear", 1));

		// Test with invalid startIndex
		assertEquals(-1, FilterList.getIndexOfFromListSinceStartIndex(list, "pear", -2));
	}

	@Test
	void testGetIndexOfFromListSectionInterval_int() {
		// Test when both searchTextBegin and searchTextEnd exist in the list
		assertArrayEquals(new int[] {1, 3}, FilterList.getIndexOfFromListSectionInterval(fileContent, "line2", "line4"));

		// Test with invalid startIndex
		assertArrayEquals(new int[] {-1, 3}, FilterList.getIndexOfFromListSectionInterval(fileContent, "line0", "line4"));

		// Test when searchTextBegin exists but searchTextEnd does not exist in the list
		assertArrayEquals(new int[] {2, -1}, FilterList.getIndexOfFromListSectionInterval(fileContent, "line3", "line6"));
	}

	@Test
	void testGetIndexOfFromListSectionInterval_String() {
		// Test when both searchTextBegin and searchTextEnd exist in the list
		assertArrayEquals(new int[] {1, -1}, FilterList.getIndexOfFromListSectionInterval(fileContent, "line2"));

		// Test when searchTextBegin exists but searchTextEnd does not exist in the list
		assertArrayEquals(new int[] {2, -1}, FilterList.getIndexOfFromListSectionInterval(fileContent, "line3"));

		// Test with invalid startIndex
		assertArrayEquals(new int[] {-1, -1}, FilterList.getIndexOfFromListSectionInterval(fileContent, "line6"));
	}

	@Test
	void testGetListExtractedFromFileSection_int() {
		// Test with valid indices
		assertEquals(Arrays.asList("line2", "line3", "line4"), FilterList.getListExtractedFromFileSection(fileContent, 1, 3));

		// Test with invalid indices
		assertEquals(Arrays.asList("line2", "line3", "line4", "line5"), FilterList.getListExtractedFromFileSection(fileContent, 1, 5));
	}

	@Test
	void testGetListExtractedFromFileSection_String() {
		// Test with valid searchTextBegin
		assertEquals(Arrays.asList("line2", "line3", "line4", "line5"), FilterList.getListExtractedFromFileSection(fileContent, "line2"));

		// Test with invalid searchTextBegin
		assertEquals(Collections.emptyList(), FilterList.getListExtractedFromFileSection(fileContent, "line6"));
	}
}