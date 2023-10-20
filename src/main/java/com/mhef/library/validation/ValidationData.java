package com.mhef.library.validation;

import java.util.List;

/**
 * @author Henrik Beck
 * @version 0.0.1
 */
public class ValidationData {
	/**
	 * @param row The list data from a single row.
	 * @return The verification about if all the values from a single row is empty (null) or not.
	 */
	public static boolean isRowContentDataEmptyOrNullable(List<String> row) {
		boolean isEmptyRow = true;

		for (String value : row) {
			if (!value.trim().isEmpty() && !value.equals("NULL") && !value.matches("^\\s*$")) {
				isEmptyRow = false;
				break;
			}
		}

		if (isEmptyRow) {
			return true;
		}

		return false;
	}

	/**
	 * @param args The arguments informed from the command line interface(CLI).
	 * @return The verification about if there is or there is not arguments.
	 */
	public static boolean isThereArguments(String[] args) {
		if (args.length == 0) {
			System.out.println("Please provide the filename as an argument.");
			return false;
		} else {
			return true;
		}
	}
}