package auto;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HorizontalScroll {

	@Test
	public void testName() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://www.medibuddy.in/");
		
		driver.switchTo().frame(0);
		WebElement popup = driver.findElement(By.xpath("//span[@class='CT_InterstitialClose']"));
		wait.until(ExpectedConditions.visibilityOf(popup));

		try {
			popup.click();
		} catch (Exception e) {
			System.out.println("popup not arise");
		}
		
		WebElement surgery = driver.findElement(By.id("hp_5"));
		int x = surgery.getLocation().getX();
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo("+x+",0)");
		
	}
}
