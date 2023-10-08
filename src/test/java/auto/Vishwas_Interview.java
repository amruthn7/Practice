package auto;

import static org.testng.Assert.assertEquals;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.util.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
public class Vishwas_Interview {



	@Test
	public void test() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[.='✕']")).click();
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		assertEquals(pageTitle, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
		//Assert.assertEquals(pageTitle, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
		driver.findElement(By.name("q")).sendKeys("mobiles");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//div[.='POCO C51 (Royal Blue, 64 GB)']")).click();
		String parent_window = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
			driver.switchTo().window(window);
		}
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")).click();		
		driver.findElement(By.xpath("//a[@class='_3SkBxJ']")).click();
		String placeOrder = driver.findElement(By.xpath("//span[.='Place Order']")).getText();		
		assertEquals(placeOrder, "PLACE ORDER");
		driver.close();
		driver.switchTo().window(parent_window);
		driver.close();
	}
}

