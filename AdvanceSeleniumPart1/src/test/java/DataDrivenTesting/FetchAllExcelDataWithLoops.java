package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchAllExcelDataWithLoops {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\USER\\Documents\\Selenium TestData\\Book1.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("Sheet1");
		
		int lastRowNumber = sheet.getPhysicalNumberOfRows();
		System.out.println("Last Row Number is : "+lastRowNumber);
		int lastCellNumber = sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println("Last cell number is : "+lastCellNumber);
		
		for(int i=0;i<lastRowNumber;i++) {
			for(int j=0;j<lastCellNumber;j++) {
				System.out.print(sheet.getRow(i).getCell(j).toString()+" "); 
			}
			System.out.println();
		}

	}

}
