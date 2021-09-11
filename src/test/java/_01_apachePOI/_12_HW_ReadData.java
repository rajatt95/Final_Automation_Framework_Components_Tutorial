package _01_apachePOI;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class _12_HW_ReadData {

	// https://blog.knoldus.com/read-and-write-data-from-excel-sheet-using-apache-poi/

	private static final String SubSheet_Name = "Employee Data";
	private static final String Sheet_Location = ".//src//test//resources//apache_POI_config//HW_Write.xlsx";

	// Any exceptions need to be caught
	@Test
	public void TC_Read_Data_In_Excel() throws EncryptedDocumentException, IOException {

		// Get the excel sheet file location
		FileInputStream fis = new FileInputStream(Sheet_Location);

		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		// XSSFSheet sheet = workbook.getSheetAt(0);
		XSSFSheet sheet = workbook.getSheet(SubSheet_Name);

		// Get the total row count in the excel sheet
		Iterator<Row> iterator = sheet.rowIterator();

		// int cellIndex = 0;
		// String description = null;
		while (iterator.hasNext()) {
			Row row = iterator.next();
			for (int i = 0; i < row.getPhysicalNumberOfCells(); i++) {
				Cell cell = row.getCell(i);
				// print the cell value
				// System.out.print(i + " " + cell);
				System.out.print(cell + "    -     ");
			}
			System.out.println();
		}
	}

}