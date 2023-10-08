package Aspire;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BookFlightMakeMyTrip {
	@Test
	public void bookFlightMakeMyTripTest() {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://www.makemytrip.com/");
		String pageTitle = driver.getTitle();
		assertEquals(pageTitle,"MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday");
		
		driver.findElement(By.xpath("//span[@class='commonModal__close']")).click();
		driver.findElement(By.xpath("//span[text()='From']")).click();
		driver.findElement(By.xpath("//div[@id='react-autowhatever-1']/div/ul/li/div/div[text()='BLR']")).click();
		driver.findElement(By.xpath("//span[text()='To']")).click();
		driver.findElement(By.xpath("//div[@id='react-autowhatever-1']/div/ul/li/div/div[text()='BOM']")).click();
		
		driver.findElement(By.xpath("//div[contains(text(),'October')]/parent::div/following-sibling::div[@class='DayPicker-Body']/child::div[@class='DayPicker-Week']/div[@class='DayPicker-Day']/div/p[text()='6']")).click();
		driver.findElement(By.xpath("//a[text()='Search']")).click();

		assertEquals(pageTitle,"MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday");
		
		WebElement popup = driver.findElement(By.xpath("//div[@class='commonOverlay ']/span"));
		wait.until(ExpectedConditions.visibilityOf(popup));
		try {
			popup.click();
		} catch (Exception e) {
			System.out.println("popup not arise");
		}
		
	
		List<WebElement> flightlist = driver.findElements(By.xpath("//div[@class='makeFlex spaceBetween']"));
		
		
		for(int i=0;i<flightlist.size();i++) {
			String flightName=driver.findElements(By.xpath("//div[@class='makeFlex spaceBetween']/div/div/div/p[@class='boldFont blackText airlineName']")).get(i).getText();
			String boardingTime=driver.findElements(By.xpath("//div[@class='flexOne timeInfoLeft']/p/span")).get(i).getText();
			String departureTime=driver.findElements(By.xpath("//div[@class='flexOne timeInfoRight']/p/span")).get(i).getText();
			String boardingStation=driver.findElements(By.xpath("//div[@class='flexOne timeInfoLeft']/p[@class='blackText']/font")).get(i).getText();
			String departureStation=driver.findElements(By.xpath("//div[@class='flexOne timeInfoRight']/p[@class='blackText']/font")).get(i).getText();
			String price=driver.findElements(By.xpath("//p[@class='fontSize12 darkText lightFont']/parent::div[@class='blackText fontSize18 blackFont white-space-no-wrap clusterViewPrice']")).get(i).getText();
			price=price.replaceAll("[a-zA-Z]", "");
			System.out.println(flightName+"--"+boardingTime+"--"+departureTime+"--"+boardingStation+"--"+departureStation+"--"+price);
		}
		
		String actFrom="Bengaluru";
		String expFrom = driver.findElement(By.xpath("//p[@class='font24 blackFont whiteText appendBottom20 journey-title makeFlex spaceBetween bottom']/span/b[1]")).getText();
		assertEquals(expFrom,actFrom);
		
		String actTo="Mumbai";
		String expTo = driver.findElement(By.xpath("//p[@class='font24 blackFont whiteText appendBottom20 journey-title makeFlex spaceBetween bottom']/span/b[2]")).getText();
		assertEquals(expTo,actTo);
		
	//driver.close();
	}

}
