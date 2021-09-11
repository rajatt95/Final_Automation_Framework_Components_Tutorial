package _01_apachePOI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class _03_Excel_Read_Print_All_Cells_NW {

	
	private static final String SubSheet_Name = "DemoSheet";
	private static final String Sheet_Location = ".//src//test//resources//apache_POI_config//Demo.xlsx";

	public static void main(String[] args) throws IOException {

		XSSFSheet sh = initializeExcelSheet();

		// Print the name of loaded sheet
		System.out.println("sh.getSheetName(): " + sh.getSheetName());

		int rows = (sh.getLastRowNum() - sh.getFirstRowNum() + 1);
		int columns = sh.getRow(0).getLastCellNum();

		// Print all Cells of Excel sheet
		for (int i = 0; i <= rows; i++) {
			for (int j = 0; i <= columns; j++) {
				System.out.println(sh.getRow(i).getCell(j).getStringCellValue());
			}
		}

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
