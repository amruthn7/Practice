package auto;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoIbibo {

	@org.testng.annotations.Test
	public void Test() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.goibibo.com");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div[1]/div/div/div[2]/span/span")).click();
		System.out.println(driver.getTitle());
		//assertEquals("", "");
		
		 WebElement filgths = driver.findElement(By.xpath("//*[@id='root']/div[5]/section[3]/div/div/div[2]/div/div/p[2]"));
		Actions a= new Actions(driver);
		a.moveToElement(filgths).click().perform();
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[5]/section[3]/div/div/ul/div/div/div/li[2]/div[2]/div[1]/span/div")).click();
		System.out.println(driver.getTitle());
		//assertEquals("", "");
		
		driver.findElement(By.xpath("//*[@id=\"search-widget-checkin-input\"]")).click();
		
		String mnt = driver.findElement(By.xpath("//*[@id=\"search-widget-calendar-element\"]/div[2]/div/div/div[1]/div/p")).getText();
		for (int i = 0; ; i++) {
			if(mnt!=("October 2023")) {
				driver.findElement(By.xpath("//*[@id='search-widget-calendar-element']/div[2]/div/div/div[1]/div/div[2]/div/svg/path")).click();
				break;
			}	
		}
		driver.findElement(By.xpath("//div/ul[2]/li/span[text()='7']")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/section/div[2]/button")).click();
		System.out.println(driver.getTitle());
		//assertEquals("", "");
		
		
		
	}
}
