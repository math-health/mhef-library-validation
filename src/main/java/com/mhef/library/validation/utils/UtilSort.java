package com.mhef.library.validation.utils;

/**
 * @author Henrik Beck
 * @version 0.0.3
 */
public class UtilSort {
	public static void reverseArray(String[] array) {
		int start = 0;
		int end = array.length - 1;

		while (start < end) {
			// Swap elements at start and end indices
			String temp = array[start];
			array[start] = array[end];
			array[end] = temp;

			// Move indices towards the center
			start++;
			end--;
		}
	}
}