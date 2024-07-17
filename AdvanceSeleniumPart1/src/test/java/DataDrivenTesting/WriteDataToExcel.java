package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataToExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\USER\\Documents\\Selenium TestData\\Book1.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.createSheet("Sheet3");
		
		sheet.createRow(0).createCell(0).setCellValue("Ragavi");
		sheet.createRow(1).createCell(0).setCellValue("Kavya");
		sheet.createRow(2).createCell(0).setCellValue("Navaneethan");
		sheet.createRow(3).createCell(0).setCellValue("Krishnaa");
		
		FileOutputStream fos = new FileOutputStream("C:\\Users\\USER\\Documents\\Selenium TestData\\Book1.xlsx");
		//Write the data to excel
		workbook.write(fos);
		//Save the data
		fos.flush();
		

	}

}
