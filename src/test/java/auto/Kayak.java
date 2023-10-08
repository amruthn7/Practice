package auto;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Kayak {

	@Test
	public void KayakTest() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.kayak.co.in/");
		driver.findElement(By.xpath("//div[contains(text(),'Flights')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@role='button' and @aria-label='Remove']")).click();
		driver.findElement(By.xpath("//input[@type='text' and @placeholder='From?']")).sendKeys("dehli");
		driver.findElement(By.xpath("//span[contains(.,'New Delhi, National Capital Territory of India, India')]")).click();
		driver.findElement(By.xpath("//input[@type='text' and @placeholder='To?' ]")).sendKeys("bangalore");
		driver.findElement(By.xpath("//span[contains(.,'Bengaluru, Karnataka, India')]")).click();
		driver.findElement(By.xpath("//span[@aria-label='Start date calendar input' ]/span[@class=\"sR_k-value\"][1]")).click();
		driver.findElement(By.xpath(" //div[@aria-label='Saturday 15 July, 2023']")).click();
		driver.findElement(By.xpath(" //div[@aria-label='Saturday 22 July, 2023']")).click();
		driver.findElement(By.xpath("//button[@type='submit' and @aria-label='Search']")).click();
		Set<String> windows = driver.getWindowHandles();
		for ( String win : windows) {
			driver.switchTo().window(win);
			break;
		}
//		WebElement sort = driver.findElement(By.xpath("//div[.='Other sort' and @class='c1wE_-title']"));
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.visibilityOf(sort));
		
		driver.findElement(By.xpath("//div[.='Other sort' and @class='c1wE_-title']")).click();
		driver.findElement(By.xpath("//div[.='Less CO₂' and @class='c1wE_-title']")).click();
		List<WebElement> e = driver.findElements(By.xpath("//div[@class='f8F1-price-text']"));
		for (int i = 0; i < e.size(); i++) {
		String price=e.get(i).getText();
		System.out.println(price);
		price=price.split(";")[1].replace(",","");
		if(Integer.parseInt(price)<20000)
			System.out.println(price);
		}
	
	}

}