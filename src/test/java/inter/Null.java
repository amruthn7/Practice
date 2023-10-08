package inter;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Null {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet1");
//		int rowCount = sheet.getLastRowNum();
			 String key = sheet.getRow(1).getCell(0).getStringCellValue();
			System.out.println(key);
		wb.close();
		fis.close();
		
	}

}
