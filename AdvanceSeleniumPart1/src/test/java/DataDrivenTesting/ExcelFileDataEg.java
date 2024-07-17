package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import DemoWebShopTestCases.DataUtility;

public class ExcelFileDataEg {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\USER\\Documents\\Selenium TestData\\Book1.xlsx");
		//Access the workbook
		Workbook workbook = WorkbookFactory.create(fis);
		//Access the sheet
		Sheet sheet = workbook.getSheet("Sheet1");
		//Access Row
		Row row = sheet.getRow(1);
		//Access cell
		Cell cell = row.getCell(0);
		//Get String value
	/*	String v1 = cell.getStringCellValue();
		System.out.println(v1);
		//Get Number value
		double v2  = sheet.getRow(1).getCell(1).getNumericCellValue();
		System.out.println(v2);  */
		
		String email1 = sheet.getRow(1).getCell(0).toString();
		System.out.println(email1);
		String password1 = sheet.getRow(1).getCell(1).toString();
		System.out.println(password1);
		
		DataUtility dataUtility = new DataUtility();
		String email2  = dataUtility.getDataFromExcel("Sheet1",2, 0);
		System.out.println(email2);
		String password2 = dataUtility.getDataFromExcel("Sheet1",2,1);
		System.out.println(password2);

	}

}
