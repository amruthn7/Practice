package auto;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FilpKart {
	@Test
	public void flipKartWashingTest() throws InterruptedException, EncryptedDocumentException, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		driver.findElement(By.name("q")).sendKeys("washing maching");
		driver.findElement(By.xpath("//div[text()='washing machines']")).click();
		driver.findElement(By.xpath("(//div[@class='col col-7-12']/div[1])[1]")).click();
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String win : allWindowHandles) {
			driver.switchTo().window(win);
			String act = driver.getTitle();
			if(act.contains("LG 7 kg 5 star rating")) {
				break;
			}
		}
		WebElement genText = driver.findElement(By.xpath("//div[text()='General']"));
		JavascriptExecutor j= (JavascriptExecutor)driver;
		j.executeScript("arguments[0].scrollIntoView()", genText);

		driver.findElement(By.xpath("//button[text()='Read More']")).click();		
		
		String filePath = "D:\\Eclipse Workspace\\Selenium Workspaces\\Practice\\src\\test\\resources\\Filpkart.xlsx";
		FileInputStream fis = new FileInputStream(filePath);
		Workbook wb = WorkbookFactory.create(fis);
		List<WebElement> key = driver.findElements(By.xpath("(//div[@class='_3k-BhJ']//table)[1]//tr/td[1]"));
		int count=0;
		for (WebElement k : key) {
			wb.getSheet("Sheet1").getRow(count).getCell(0).setCellValue(k.getText());
			count++;
		}
		
		 List<WebElement> value = driver.findElements(By.xpath("(//div[@class='_3k-BhJ']//table)[1]//tr/td[2]"));
		int count1=0;
		for (WebElement v : value){
			wb.getSheet("Sheet1").getRow(count1).getCell(1).setCellValue(v.getText());
			count1++;
		}
		FileOutputStream fos = new FileOutputStream(filePath);
		wb.write(fos);
		wb.close();
		fis.close();
		fos.close();
		
		driver.close();
	}
}
