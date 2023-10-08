package auto;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MoneyGraph1 {

	@Test
	public void test()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.moneycontrol.com/"); 
		driver.findElement(By.id("wzrk-cancel")).click();
		WebElement ele = driver.findElement(By.xpath("//h2[text()='Market Action']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;


		Actions act= new Actions(driver);
		act.moveToElement(ele);

		WebElement frame = driver.findElement(By.xpath("//iframe[@title=\"Indices Chart\"]"));
		driver.switchTo().frame(frame);

	}

}
