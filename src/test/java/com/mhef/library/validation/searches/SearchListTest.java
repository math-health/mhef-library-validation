package com.mhef.library.validation.searches;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Henrik Beck
 * @version 0.0.3
 */
class SearchListTest {
	private static List<String> list = new ArrayList<>();

	@BeforeAll
	static void setupLoadVariable() {
		list = Arrays.asList("apple", "banana", "orange", "grape");
	}

	@Test
	void listSearch() {
		// Test when searchString exists in the list
		assertEquals(Arrays.asList("orange"), SearchList.listSearch(list, "orange"));

		// Test when searchString does not exist in the list
		assertEquals(Arrays.asList(), SearchList.listSearch(list, "pear"));

		// Test with an empty list
		assertEquals(Arrays.asList(), SearchList.listSearch(Arrays.asList(), "banana"));

		// Test with an empty searchString
		assertEquals(Arrays.asList("apple", "banana", "orange", "grape"), SearchList.listSearch(list, ""));
	}

	@Test
	public void testListSearchUntilFirstOccurrence() {
		List<String> list = Arrays.asList(
			"apple", "banana", "orange",
			"apple", "grape", "banana"
		);

		assertEquals("apple", SearchList.listSearchUntilFirstOccurrence(list, "apple"));
		assertEquals("orange", SearchList.listSearchUntilFirstOccurrence(list, "ra"));
	}

	@Test
	public void testListSearchUntilFirstOccurrenceNoMatch() {
		List<String> list = Arrays.asList(
			"pear", "orange", "grape",
			"kiwi", "banana", "watermelon"
		);

		String result = SearchList.listSearchUntilFirstOccurrence(list, "apple");

		assertNull(SearchList.listSearchUntilFirstOccurrence(list, "apple"));
		assertNotEquals("grape", SearchList.listSearchUntilFirstOccurrence(list, "ra"));
	}
}
