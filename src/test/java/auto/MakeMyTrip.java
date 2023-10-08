package auto;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import genericUtilities.ExcelUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTrip {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://www.makemytrip.com/");
		Thread.sleep(7000);
		//		driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");
		//		driver.findElement(By.xpath("//i[@class='wewidgeticon we_close']")).click();
		//	driver.switchTo().parentFrame();
		driver.findElement(By.id("fromCity")).sendKeys("Bengaluru");
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='BLR']/../..")));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[text()='BLR']/../..")).click();
		driver.findElement(By.id("toCity")).sendKeys("Mumbai");
		driver.findElement(By.xpath("//div[@class='calc60']//p[contains(text(),'Mumbai')]")).click();
		driver.findElement(By.xpath("//div[contains(text(),'April')]/../following-sibling::div[@class='DayPicker-Body']//p[text()='23']")).click();
		driver.findElement(By.xpath("//a[text()='Search']")).click();
		WebElement element=driver.findElement(By.xpath("//p[@class='fillingLoaderShining']"));
		//wait.until(ExpectedConditions.invisibilityOf(element));
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[@class='bgProperties icon20 overlayCrossIcon']")).click();


		driver.findElement(By.xpath("//span[text()='+ 8 more']")).click();
		List<WebElement> filters = driver.findElements(By.xpath("//p[text()='Popular Filters']/..//p[number(translate(substring-after(text(),'('),') ',''))>10]"));
		for(WebElement filter:filters) {
			filter.click();
			Thread.sleep(5000);
		}
		List<WebElement> flightlist = driver.findElements(By.xpath("//div[@class='makeFlex simpleow']"));
		Map<Integer, List<String>> map=new LinkedHashMap<Integer, List<String>>(); 
		for(int i=0;i<flightlist.size();i++) {
			List<String>list=new ArrayList<String>();
			String flightName=driver.findElement(By.xpath("(//div[@class='makeFlex simpleow']//p[@class='boldFont blackText airlineName'])["+(i+1)+"]")).getText();
			String code=driver.findElement(By.xpath("(//div[@class='makeFlex simpleow']//p[@class='fliCode'])["+(i+1)+"]")).getText();
			String boardingTime=driver.findElement(By.xpath("(//div[@class='flexOne timeInfoLeft']//p[@class='appendBottom2 flightTimeInfo'])["+(i+1)+"]")).getText();
			String departureTime=driver.findElement(By.xpath("(//div[@class='flexOne timeInfoRight']//p[@class='appendBottom2 flightTimeInfo'])["+(i+1)+"]")).getText();
			String boardingStation=driver.findElement(By.xpath("(//div[@class='flexOne timeInfoLeft']//p[@class='appendBottom2 flightTimeInfo']/following-sibling::p)["+(i+1)+"]")).getText(); 
			String departureStation=driver.findElement(By.xpath("(//div[@class='flexOne timeInfoRight']//p[@class='appendBottom2 flightTimeInfo']/following-sibling::p)["+(i+1)+"]")).getText();
			String price=driver.findElement(By.xpath("(//p[@class='blackText fontSize18 blackFont white-space-no-wrap'])["+(i+1)+"]")).getText();
			list.add(flightName);
			list.add(code);
			list.add(boardingTime);
			list.add(boardingStation);
			list.add(departureTime);
			list.add(departureStation);
			list.add(price);

			int id=i;

			System.out.println(flightName+"   "+code+" "+boardingStation+" "+boardingTime+" "+departureStation+" "+departureTime+" "+price);
			map.put(id,list);


		}
		ExcelUtility e=new ExcelUtility();
		e.setData("Sheet1", map);
		//e.saveExcel();
	}


}
