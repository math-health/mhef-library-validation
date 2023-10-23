package com.mhef.library.validation.utils;

/**
 * @author Henrik Beck
 * @version 0.0.2
 */
import java.io.IOException;

// System.out.println("PDF converted to HTML successfully!");
// System.out.println("PDF converted to HTML successfully!");

/**
 * @author Henrik Beck
 * @version 0.0.2
 *
 * @todo Fix the JavaDoc.
 * @todo Migrate this class to MHEF - Validation library.
 */
public class MessageDisplay {
	/**
	 * <p>Display an error message in case of file conversion fails.</p>
	 *
	 * @param pathFileOrigin The path to the origin file to be based on.
	 * @param pathFileDestiny The path to the result file after exporting.
	 * @param error The IOExpection error value.
	 */
	public static void displayMessageFileConversionError(String pathFileOrigin, String pathFileDestiny, IOException error) {
		System.out.println("[Error]\tConversion from '" + pathFileOrigin + "' to '" + pathFileDestiny + "' file");
		System.err.println(error.getMessage());
	}

	/**
	 * <p>Display a success message in case of file conversion works.</p>
	 *
	 * @param pathFileOrigin The path to the origin file to be based on.
	 * @param pathFileDestiny The path to the result file after exporting.
	 */
	public static void displayMessageFileConversionSuccess(String pathFileOrigin, String pathFileDestiny) {
		System.out.println("[Success]\tConversion from '" + pathFileOrigin + "' to '" + pathFileDestiny + "' file");
	}

	/**
	 * <p>Display an error message in case of file write fails.</p>
	 *
	 * @param pathFile The path to the origin file to be based on.
	 * @param error The IOExpection error value.
	 */
	public static void displayMessageFileWriteError(String pathFile, IOException error) {
		System.out.println("[Error]\tData has not been written into '" + pathFile + "' file");
		System.err.println(error.getMessage());
	}

	/**
	 * <p>Display a success message in case of file write works.</p>
	 *
	 * @param pathFile The path to the origin file to be based on.
	 */
	public static void displayMessageFileWriteSuccess(String pathFile) {
		System.out.println("[Success]\tData has been written into '" + pathFile + "' file");
	}
}