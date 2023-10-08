package auto;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrintMobileName {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		driver.findElement(By.xpath("//div[text()='Mobiles']")).click();
		WebElement mobiles = driver.findElement(By.xpath("//div[text()='Reviews for Popular Mobiles']"));
		JavascriptExecutor j= (JavascriptExecutor) driver;
		j.executeScript("arguments[0].scrollIntoView()", mobiles);
		List<WebElement> mobName = driver.findElements(By.xpath("//div[@class='_1W9f5C']/child::div|//div[@class='_30jeq3 UMT9wN']"));
		
		for (WebElement m : mobName) {
			System.out.print(m.getText()+" ");
			System.out.println();
		}
	
	}
}
