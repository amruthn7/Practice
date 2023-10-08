package auto;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.internal.Arguments;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon1 {

	@Test
	public void text() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get("https://www.amazon.in/");
		String hmTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		
		//Assert.assertEquals(driver.getTitle(), "Amazon.in : poco x2 back cover");
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("poco x2");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='nav-flyout-searchAjax']/div[2]/div/div[1]/div[3]/div/div[1]")));
		driver.findElement(By.xpath("//*[@id='nav-flyout-searchAjax']/div[2]/div/div[1]/div[3]/div/div[1]")).click();
		System.out.println(driver.getTitle());
		//Assert.assertEquals(driver.getTitle(), "Amazon.in : poco x2 back cover");

		WebElement l = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[11]/div/div/div/div/div/div[2]/div/div/div[1]/h2/a/span"));
		Actions a = new Actions(driver);
		a.moveToElement(l).click().perform();
		
		String parentWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();

		for ( String wind: allWindows) {
				driver.switchTo().window(wind);
		}
		System.out.println(driver.getTitle());
		//Assert.assertEquals(driver.getTitle(), "Amazon.in : poco x2 back cover");
		
		driver.findElement(By.id("add-to-cart-button")).click();
		String text = driver.findElement(By.xpath("//*[@id=\"NATC_SMART_WAGON_CONF_MSG_SUCCESS\"]/span")).getText();
		assertEquals(text, "Added to Cart");
	}

}
