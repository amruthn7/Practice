package auto;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmericanAirlines {

	@Test
	public void americanAirlinesTest() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.get("https://www.americanairlines.in/intl/in/index.jsp");
		WebElement fromAirport = driver.findElement(By.id("reservationFlightSearchForm.originAirport"));
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,"+fromAirport.getLocation().getY()+")");
		
		fromAirport.sendKeys("Bangalore");
		WebElement from = driver.findElement(By.xpath("//a[text()='Bengaluru International Airport (BLR), India']"));
		wait.until(ExpectedConditions.visibilityOf(from));
		
		driver.findElement(By.name("destination")).sendKeys("delhi");
		WebElement to = driver.findElement(By.xpath("//a[text()='Delhi (DEL), India']"));
		wait.until(ExpectedConditions.visibilityOf(to));
		
		driver.findElement(By.xpath("//label[contains(text(),'Return')]/button")).click();
		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td[@data-month='8']/a[text()='17']")).click();
		driver.findElement(By.xpath("//input[@id='bookingModule-submit']")).click();

		
	}
}
