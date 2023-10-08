package auto;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tata1MG {

	@Test
	public void TataMGTest() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://www.1mg.com/");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"style__close-icon___3FflV\"]")));
		driver.findElement(By.xpath("//div[@class=\"style__close-icon___3FflV\"]")).click();
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("\"//div[text()='Cancel']\""))));
//		driver.switchTo().alert().dismiss();
		driver.findElement(By.xpath("//div[text()='Cancel']")).click();
		//driver.findElement(By.xpath("//div[text()='Lab Tests']")).click();
		
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		//Assert.assertEquals(pageTitle, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");

		String expTitle = "Find the Right";
		driver.switchTo().window(expTitle);
		
	}
}
