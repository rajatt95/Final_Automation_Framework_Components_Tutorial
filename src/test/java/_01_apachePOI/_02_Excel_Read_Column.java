package _01_apachePOI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class _02_Excel_Read_Column {

	private static final String SubSheet_Name = "DemoSheet";
	private static final String Sheet_Location = ".//src//test//resources//apache_POI_config//Demo.xlsx";

	public static void main(String[] args) throws IOException {

		XSSFSheet sh = initializeExcelSheet();

		// Print the name of loaded sheet
		System.out.println("sh.getSheetName(): " + sh.getSheetName());

		// Print the Total no. of Column - 1st Way
		System.out.println("1st way: ");
		System.out.println(sh.getRow(0).getPhysicalNumberOfCells());// 2

		// Print the Total no. of Column - 2nd Way
		System.out.println("2nd way: ");
		System.out.println(sh.getRow(0).getLastCellNum());// 2

		// Print the Total no. of Column - 3rd Way
		System.out.println("3rd way: ");
		int columns = sh.getRow(0).getLastCellNum();
		System.out.println("Total Columns: " + columns);// 2

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
