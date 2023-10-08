package auto;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipKart_MobilePrice {

	@Test
	public void mobileTest() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
		WebElement cancel = driver.findElement(By.xpath("//*[.='✕']"));
		wait.until(ExpectedConditions.elementToBeClickable(cancel)).click();
		driver.findElement(By.name("q")).sendKeys("mobiles");
		driver.findElement(By.xpath("//*[@class='L0Z3Pu']")).click();
		List<WebElement> prices = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
		for (WebElement p : prices) 
		{
			System.out.println(p.getText().replaceAll("[₹,]", ""));
		}	
	}
}