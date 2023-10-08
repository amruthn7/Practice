package auto;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ICC {

	@Test
	void test() {
	WebDriverManager.chromedriver().setup();
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://www.icc-cricket.com/homepage");
	String title = driver.getTitle();
	Assert.assertEquals(title, "Official International Cricket Council Website");
	
	WebElement ranking = driver.findElement(By.xpath("//nav[not(@id='mobile-menu')]/ul/li/button[contains(.,'Rankings')]"));
	Actions a = new Actions(driver);
	a.moveToElement(ranking).perform();
	WebElement overview = driver.findElement(By.xpath("//a[@class=\"linked-list__link \" and contains(text(),'Overview')]"));
	overview.click();
	String rankings =driver.getTitle();
	Assert.assertEquals(rankings, "ICC Men's Cricket Rankings Overview | ICC");
	String team = "India";
	String format = "t20i";
	WebElement rank = driver.findElement(By.xpath("//div[.='"+format+"']/parent::div/following-sibling::div/div[.='"+team+"']/following-sibling::div"));
	//Assert.assertEquals(rank.getText(), "267");
	if(rank.getText().equalsIgnoreCase("267")) {
		System.out.println("India ranking is 267 and matching successfully");
	}else {
		System.out.println("India ranking is not 267");
	}
	driver.close();
	}
}
