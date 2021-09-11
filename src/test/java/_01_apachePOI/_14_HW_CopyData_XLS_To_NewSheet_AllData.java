package _01_apachePOI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class _14_HW_CopyData_XLS_To_NewSheet_AllData {

	private static final String SubSheet_Name = "MyLinks";
	private static final String SubSheet_New_Name = "MyLinks_2";

	private static final String XLS_FILE_PATH = ".//src//test//resources//apache_POI_config//Sample_Sheet.xls";

	// https://www.quora.com/How-can-I-copy-several-rows-from-sheet-1-to-another-sheet-2-of-the-same-workbook-using-JAVA-in-Selenium

	public static void main(String[] args) throws IOException, InvalidFormatException {

		FileInputStream file = new FileInputStream(XLS_FILE_PATH);

		HSSFWorkbook workbook = new HSSFWorkbook(file);

		// Getting sheet1
		HSSFSheet sheet = workbook.getSheet(SubSheet_Name);

		// Creating sheet2
		Sheet sheetTwo = workbook.createSheet(SubSheet_New_Name);

		Row row;
		int rowCount_Sheet1 = (sheet.getLastRowNum() + 1);

		for (int j = 0; j < rowCount_Sheet1; j++) {
			// Getting row at index 0 in sheet1
			row = sheet.getRow(j);
			int rowLength = row.getPhysicalNumberOfCells();

			// Creating row at index 0 in sheet2
			Row sheetTwoRow = sheetTwo.createRow(j);

			// Setting value in row of sheet2 from sheet1
			for (int i = 0; i < rowLength; i++) {
				Cell cell = sheetTwoRow.createCell(i);
				Cell firstSheetCell = row.getCell(i);
				cell.setCellValue(firstSheetCell.getStringCellValue());
			}

		}

		writeChangesInExcelSheet(file, workbook);

		System.out.println("Success");
	}

	private static void writeChangesInExcelSheet(FileInputStream file, HSSFWorkbook workbook)
			throws IOException, FileNotFoundException {
		// Writing changes in Excel file
		file.close();
		FileOutputStream outFile = new FileOutputStream(new File(XLS_FILE_PATH));
		workbook.write(outFile);
		outFile.close();
	}

}
