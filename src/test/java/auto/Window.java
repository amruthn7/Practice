package auto;



import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Window {
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://secure.indeed.com/");
		driver.findElement(By.id("apple-signin-button")).click();
		driver.findElement(By.id("login-facebook-button")).click();
		Set<String> allWh = driver.getWindowHandles();
		int count = allWh.size();
		System.out.println(count);
		for(String wh:allWh) {
			driver.switchTo().window(wh);
			if(driver.getTitle().equalsIgnoreCase("facebook")) {
				break;
			}
		}
		String text = driver.findElement(By.xpath("//a[text()='Create New Account']")).getText();
		System.out.println(text);
		driver.findElement(By.xpath("//a[text()='Create New Account']")).click();
		Set<String> allTabs = driver.getWindowHandles();
		for (String tab : allTabs) {
			driver.switchTo().window(tab);
			if(driver.getTitle().equals("Sign Up")) {
				break;
			}
		}
		driver.findElement(By.name("firstname")).sendKeys("firstname");
		driver.findElement(By.name("lastname")).sendKeys("lastname");
		driver.findElement(By.name("reg_email__")).sendKeys("abc@gmail.com");
		driver.findElement(By.name("reg_passwd__")).sendKeys("pass");
		WebElement day = driver.findElement(By.id("day"));
		Select d = new Select(day);
		d.selectByValue("7");
		WebElement mnt = driver.findElement(By.id("month"));
		Select m = new Select(mnt);
		m.selectByVisibleText("May");
		WebElement year = driver.findElement(By.id("year"));
		Select y = new Select(year);
		y.selectByValue("1995");

		driver.findElement(By.xpath("//input[@name='sex' and @value='2']")).click();
		
		driver.close();
	}
}
