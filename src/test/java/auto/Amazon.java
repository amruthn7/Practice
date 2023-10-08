package auto;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	@Test
	public void test() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));		
		driver.get("https://www.amazon.in/");
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mobile"+Keys.ENTER);
		WebElement results = driver.findElement(By.xpath("//span[text()='Results']"));
		wait.until(ExpectedConditions.visibilityOf(results));
		Assert.assertEquals(results.getText(), "Results");
		driver.findElement(By.xpath("//span[contains(text(),'Samsung Galaxy M34 5G')]")).click();
		Set<String> windows = driver.getWindowHandles();
		for (String win : windows) {
			driver.switchTo().window(win);
		}
		WebElement addToCartElement = driver.findElement(By.id("submit.add-to-cart-announce"));
		wait.until(ExpectedConditions.visibilityOf(addToCartElement));
		Assert.assertEquals(addToCartElement.getText(), "Add to Cart");
		
	}
}
