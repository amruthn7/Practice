package externalFiles;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Writing_Data_Into_Excel_File {
	@Test
	public void excelTest() throws EncryptedDocumentException, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//		List<WebElement> columnName = driver.findElements(By.xpath("//table/thead/tr/th"));
//		
//		List<WebElement> position = driver.findElements(By.xpath("//tbody/tr/td[@class='table-body__cell table-body__cell--position u-text-right' or @class='rankings-block__banner--pos']"));
//		List<WebElement> team = driver.findElements(By.xpath("//tbody/tr/td/span[@class='u-hide-phablet']"));
//		List<WebElement> matches = driver.findElements(By.xpath("//tbody/tr/td[3][@class='table-body__cell u-center-text' or @class='rankings-block__banner--matches']"));
//		List<WebElement> points = driver.findElements(By.xpath("//tbody/tr/td[4][@class='table-body__cell u-center-text' or @class='rankings-block__banner--points']"));
//		List<WebElement> ratings = driver.findElements(By.xpath("//tbody/tr/td[@class='table-body__cell u-text-right rating' or @class='rankings-block__banner--rating u-text-right']"));
//
//		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\Testdata.xlsx");
//		Workbook wb = WorkbookFactory.create(fis);
//		Sheet sheet = wb.getSheet("Sheet2");
//		
//		for (int i = 0; i < columnName.size(); i++) {
//			for (int j = 0; j < columnName.size(); j++) {
//				sheet.createRow(i).createCell(j).setCellValue(columnName.get(j).getText());
//				FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\Testdata.xlsx");
//				wb.write(fos);
//			}
//		}
//		
//		wb.close();
//		fis.close();

		WebElement table = driver.findElement(By.xpath("//table[@class='table']"));
		List<WebElement> columnName = driver.findElements(By.xpath("//table/thead/tr/th"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Testdata.xlsx");

		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.createSheet("iccCricketTable");
		int rowNum=0;
//		int colnum=0;
//		for (WebElement cn : columnName) {
//			String text = cn.getText();
//			System.out.println(text);
//			sh.createRow(0).createCell(colnum).setCellValue(text);
//			colnum++;
		//}
		
		for ( WebElement row : rows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			 Row rw = sh.createRow(rowNum);
			int cellNum=0;
			for (WebElement cell : cells) {
				rw.createCell(cellNum).setCellValue(cell.getText());
				cellNum++;
			}
			rowNum++;
		}
		FileOutputStream fos=new FileOutputStream("./src/test/resources/Testdata.xlsx");
		wb.write(fos);
		wb.close();
		driver.close();

	}
}
