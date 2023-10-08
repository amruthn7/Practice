package auto;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
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


public class Practice {

	@Test
	public void praticeTest() throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement table = driver.findElement(By.xpath("//table[@class='table']"));
		List<WebElement> columnName = driver.findElements(By.xpath("//table/thead/tr/th"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
	
		FileInputStream fis = new FileInputStream("./src/test/resources/Testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.createSheet("abc");
		int rowNum=0;
		for ( WebElement row : rows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			 Row rw = sheet.createRow(rowNum);
			int cellNum=0;
			for (WebElement cell : cells) {
				rw.createCell(cellNum).setCellValue(cell.getText());
				cellNum++;
			}
			rowNum++;
		}
		
		FileOutputStream fos = new FileOutputStream("./src/test/resources/Testdata.xlsx");
		
		wb.write(fos);
		wb.close();
		driver.close();
	}
}
