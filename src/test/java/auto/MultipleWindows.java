package auto;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
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

public class MultipleWindows {

	@Test
	public void windowTest() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mobile"+Keys.ENTER);
		WebElement results = driver.findElement(By.xpath("//span[text()='Results']"));
		wait.until(ExpectedConditions.visibilityOf(results));
		Assert.assertEquals(results.getText(), "Results");
		List<WebElement> winlinks = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		for (int i = 0; i <=4; i++) {
			winlinks.get(i).click();
		}
		
		Set<String> wins = driver.getWindowHandles();
		ArrayList<String> list = new ArrayList<String>(wins);
		driver.switchTo().window(list.get(4));
		System.out.println(driver.getTitle());
		//WebElement addToCartElement = driver.findElement(By.id("submit.add-to-cart-announce"));
		//addToCartElement.click();
	}
}
