package auto;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownUsingRobotClass {

	@Test
	public static void dropdown() throws AWTException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		
		driver.findElement(By.xpath("//a[@id='u_0_0_pU']")).click();
//		WebElement day = driver.findElement(By.id("day"));
//		Select d=new Select(day);
//		d.selectByValue("7");
		
//		WebElement year = driver.findElement(By.id("year"));
//		Select y=new Select(year);
//		y.selectByVisibleText("1995");
		
		WebElement month = driver.findElement(By.id("month"));
//		Select m=new Select(month);
//		m.selectByIndex(4);
		month.click();
		Robot r= new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		
		
		
	}
}
