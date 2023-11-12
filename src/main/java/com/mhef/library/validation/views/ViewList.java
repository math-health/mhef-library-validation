package com.mhef.library.validation.views;

import java.util.List;

/**
 * @author Henrik Beck
 * @version 0.0.3
 */
public class ViewList {
	public static void displayListRows(List<String> listContent) {
		for (int i = 0; i < listContent.size(); i++) {
			System.out.println("Line [" + (i + 1) + "]: " + listContent.get(i));
		}
	}
}