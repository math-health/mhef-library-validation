package com.mhef.library.validation.interfaces;

/**
 * @author Henrik Beck
 * @version 0.0.4
 *
 * Define the regular expression pattern.
 */
public interface IPatternRegex {
	String numberIntegerOnly = "\\d+"; // Only integer values
	String numberDoubleOnly = "\\d+\\.\\d+"; // Only float values
	String numberIntegerAndDouble = "\\d+(\\.\\d+)?"; // Integer and float values
}