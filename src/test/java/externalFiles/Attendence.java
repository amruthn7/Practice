package externalFiles;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class Attendence {

	@Test
	public void attendenceTest() throws Throwable, IOException {

		DataFormatter df= new DataFormatter();
		FileInputStream fis = new FileInputStream("D:\\Eclipse Workspace\\Selenium Workspaces\\Practice\\src\\test\\resources\\std.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Student");
		int rowCount = sheet.getLastRowNum();

		HashMap<String,Integer> map=new HashMap<String,Integer>();
		for (int i = 1; i <=rowCount; i++) {
			Cell cell = sheet.getRow(i).getCell(1);
			Cell cell2 = sheet.getRow(i).getCell(0);
			String att = df.formatCellValue(cell);
			int attendence = Integer.parseInt(att);
			String name = df.formatCellValue(cell2);
			map.put(name, attendence);

		}
		for (int j = 1; j <=rowCount; j++) {


			for ( Entry<String, Integer> m : map.entrySet()) {
				if(m.getValue()==1) {
					m.setValue(0);
					sheet.getRow(j).getCell(1).setCellValue("0");
				}else {
					m.setValue(1);
					sheet.getRow(j).getCell(1).setCellValue("1");
				}
				System.out.println(m.getKey()+" "+m.getValue());
			}

		}
		FileOutputStream fos = new FileOutputStream("D:\\Eclipse Workspace\\Selenium Workspaces\\Practice\\src\\test\\resources\\std.xlsx");
		wb.write(fos);
		wb.close();
	}
}
