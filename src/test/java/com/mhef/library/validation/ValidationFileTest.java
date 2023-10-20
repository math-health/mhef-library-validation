package com.mhef.library.validation;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Henrik Beck
 * @version 0.0.1
 */
class ValidationFileTest {
	public static String projectRootPath = "";
	public static String pathRelativeCsv = "";
	public static String pathRelativeDoc = "";
	public static String pathRelativeDocx = "";
	public static String pathRelativeMd = "";
	public static String pathRelativePdf = "";
	public static String pathRelativeTxt = "";
	public static String pathRelativeXls = "";
	public static String pathRelativeXlsx = "";

	@BeforeAll
	static void aaa() {
		projectRootPath = System.getProperty("user.dir");

//		pathRelativeCsv = "/assets/data/file-example-1MB.csv";
		pathRelativeCsv = "/assets/data/cities.csv";
		pathRelativeDoc = "/assets/data/file-example-1MB.doc";
		pathRelativeDocx = "/assets/data/file-example-1MB.docx";
		pathRelativeMd = "/assets/data/file-example-1MB.md";
		pathRelativePdf = "/assets/data/file-example-1MB.pdf";
		pathRelativeTxt = "/assets/data/file-example-1MB.txt";
//		pathRelativeXls = "/assets/data/file-example-1MB.xls";
		pathRelativeXls = "/assets/data/example_XLS_50.xls";
		pathRelativeXlsx = "/assets/data/file-example-1MB.xlsx";
	}

	@Test
	void fileExists() {
		assertEquals(ValidationFile.fileExists(projectRootPath + pathRelativeCsv), true);
		assertEquals(ValidationFile.fileExists(projectRootPath + pathRelativeDoc), true);
		assertEquals(ValidationFile.fileExists(projectRootPath + pathRelativeDocx), true);
		assertEquals(ValidationFile.fileExists(projectRootPath + pathRelativeMd), false);
		assertEquals(ValidationFile.fileExists(projectRootPath + pathRelativePdf), true);
		assertEquals(ValidationFile.fileExists(projectRootPath + pathRelativeTxt), false);
		assertEquals(ValidationFile.fileExists(projectRootPath + pathRelativeXls), true);
		assertEquals(ValidationFile.fileExists(projectRootPath + pathRelativeXlsx), false);
	}

	@Test
	void getFileExtension() {
		assertEquals(ValidationFile.getFileExtension(projectRootPath), "");
		assertEquals(ValidationFile.getFileExtension(projectRootPath + null), "");
		assertEquals(ValidationFile.getFileExtension(projectRootPath + ".lalala"), ".lalala");
		assertEquals(ValidationFile.getFileExtension(projectRootPath + "/.lalala"), ".lalala");
		assertEquals(ValidationFile.getFileExtension(projectRootPath + "/lalala"), "");

		assertEquals(ValidationFile.getFileExtension(projectRootPath + pathRelativeCsv), ".csv");
		assertEquals(ValidationFile.getFileExtension(projectRootPath + pathRelativeDoc), ".doc");
		assertEquals(ValidationFile.getFileExtension(projectRootPath + pathRelativeDocx), ".docx");
		assertEquals(ValidationFile.getFileExtension(projectRootPath + pathRelativeMd), ".md");
		assertEquals(ValidationFile.getFileExtension(projectRootPath + pathRelativePdf), ".pdf");
		assertEquals(ValidationFile.getFileExtension(projectRootPath + pathRelativeTxt), ".txt");
		assertEquals(ValidationFile.getFileExtension(projectRootPath + pathRelativeXls), ".xls");
		assertEquals(ValidationFile.getFileExtension(projectRootPath + pathRelativeXlsx), ".xlsx");
	}
}