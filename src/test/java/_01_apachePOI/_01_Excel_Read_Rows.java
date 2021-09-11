package _01_apachePOI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class _01_Excel_Read_Rows {

	private static final String SubSheet_Name = "DemoSheet";
	private static final String Sheet_Location = ".//src//test//resources//apache_POI_config//Demo.xlsx";

	public static void main(String[] args) throws IOException {

		XSSFSheet sh = initializeExcelSheet();

		// Print the name of loaded sheet
		System.out.println("sh.getSheetName(): " + sh.getSheetName());
		System.out.println("---------------------------------");
		// Print Username from Excel sheet
		System.out.println(
				"sh.getRow(0).getCell(0).getStringCellValue(): " + sh.getRow(0).getCell(0).getStringCellValue());

		// Print P2 from Excel sheet
		System.out.println(
				"sh.getRow(2).getCell(1).getStringCellValue(): " + sh.getRow(2).getCell(1).getStringCellValue());
		System.out.println("---------------------------------");
		// Print the Total no. of Rows - 1st Way
		System.out.println("Total Rows - 1st way: " + sh.getPhysicalNumberOfRows());
		System.out.println("---------------------------------");
		// Print the Total no. of Rows - 2nd Way
		//// Here, index will work
		System.out.println("2nd way: ");
		System.out.println("  " + sh.getLastRowNum());// 5
		System.out.println("  " + sh.getFirstRowNum());// 0
		int rows = (sh.getLastRowNum() - sh.getFirstRowNum() + 1);
		System.out.println("Total rows: " + rows);
		System.out.println("---------------------------------");
		// Print the Total no. of Rows - 3rd Way
		System.out.println("3rd way: ");
		System.out.println(sh.getLastRowNum() + 1);

	}

	private static XSSFSheet initializeExcelSheet() throws FileNotFoundException, IOException {
		// Specify the location of Excel File
		File src = new File(Sheet_Location);

		// Load File
		FileInputStream fis = new FileInputStream(src);

		// Load Workbook
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		// Load Worksheet
		XSSFSheet sh = wb.getSheet(SubSheet_Name);
		return sh;
	}

}
