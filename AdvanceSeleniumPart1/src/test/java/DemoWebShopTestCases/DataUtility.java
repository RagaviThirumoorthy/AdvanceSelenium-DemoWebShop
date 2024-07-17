package DemoWebShopTestCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataUtility {

	public String getDataFromProperties(String key) throws IOException {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\USER\\Documents\\Selenium TestData\\CommonData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		
		String value = prop.getProperty(key);
		return value;
	}
	
	public String getDataFromExcel(String sheetName,int rowNumber,int cellNumber) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\USER\\Documents\\Selenium TestData\\Book1.xlsx");
		//Access the workbook
		Workbook workbook = WorkbookFactory.create(fis);
		//Access the sheet
		Sheet sheet = workbook.getSheet(sheetName);
		String value = sheet.getRow(rowNumber).getCell(cellNumber).toString();
		
		return value;
	}

}

//Create a generic method to fetch data from excel file



/*		//Access Row
Row row = sheet.getRow(rowNumber);
//Access cell
Cell cell = row.getCell(colNumber);
//Get String value
String v1 = cell.toString();  */