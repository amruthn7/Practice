package auto;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FilpKartWindows {

	
	@Test
	public void Test() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		try {
			driver.findElement(By.xpath("//span[@role='button' and @class='_30XB9F']")).click();
			System.out.println("try popup");
		} catch (Exception e) {
			System.out.println("catch popup");
			driver.findElement(By.xpath("//button[text()='✕']")).click();
		}

//		driver.findElement(By.name("q")).sendKeys("iphone"+Keys.ENTER);
//		driver.findElement(By.xpath("(//div[@class='_4rR01T'])[1]")).click();
//
//		driver.findElement(By.name("q")).sendKeys(Keys.CONTROL+"a");
//		driver.findElement(By.name("q")).sendKeys(Keys.BACK_SPACE);
//
//		driver.findElement(By.name("q")).sendKeys("samsung"+Keys.ENTER);
//		driver.findElement(By.xpath("(//a[@class='_2rpwqI'])[1]")).click();
//
//		Set<String> windows = driver.getWindowHandles();
//		for (String win : windows) {
//			driver.switchTo().window(win);
//			String act = driver.getTitle();
//			if(act.contains("iPhone")) {
//				driver.close();
//			}
//		}
		driver.close();
	}
}
