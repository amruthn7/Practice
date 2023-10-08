package auto;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
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

public class Iphone13 {

	@Test
	public void iphoneTest() throws EncryptedDocumentException, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone 13");
		driver.findElement(By.xpath("//input[@type='submit' and @id='nav-search-submit-button']")).click();
		List<WebElement> price = driver.findElements(By.xpath("//span[@class='a-price-whole']"));

		int count=price.size();
		for (int i = 0; i <count; i++) {
			//System.out.print(price.get(i).getText());
			FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\iphone.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			
			wb.getSheet("Sheet1").createRow(i).createCell(0).setCellValue(price.get(i).getText());
			
			FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\iphone.xlsx");
			wb.write(fos);
			wb.close();
			fis.close();
		}
		driver.close();
	}
}

