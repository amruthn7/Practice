package externalFiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class Fetching_Data_From_Excel_File {

	@Test
	public void excelTest() throws EncryptedDocumentException, IOException {
		
		//DataFormatter df= new DataFormatter();
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\Testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet1");
		int rowCount = sheet.getLastRowNum();
		for (int i = 0; i <rowCount; i++) {
			 String key = sheet.getRow(i).getCell(0).getStringCellValue();
			String value = sheet.getRow(i).getCell(1).getStringCellValue();
			System.out.println(key+" = "+value);
		}
		wb.close();
		fis.close();
//		String data = df.formatCellValue(cell);
//		System.out.println(data);
		
		
		
//		DataFormatter df = new DataFormatter();
//		FileInputStream fis = new FileInputStream("./src/test/resources/Testdata.xlsx");
//		Workbook wb = WorkbookFactory.create(fis);
//		Sheet sheet = wb.getSheet("iccCricketTable 1");
//		int lastRowNum = sheet.getLastRowNum();
//		
//		for (int i = 1; i < lastRowNum; i++) {
//			int lastCellNum = sheet.getRow(i).getLastCellNum();
//			for (int j = 0; j < lastCellNum; j++) {
//				Cell cell = sheet.getRow(i).getCell(j);
//				String data = df.formatCellValue(cell);
//				System.out.print(data+" ");
//			}
//			System.out.println();
//		}
//		wb.close();
//		fis.close();
	}
}
