package auto;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FilpkartPractice {

	@Test
	public void flipText() {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		try {
			driver.findElement(By.xpath("//button[text()='✕']")).click();
		} catch (NoSuchElementException e) {
			// TODO: handle exception

			driver.findElement(By.name("q")).sendKeys("Samsung S20");
			List<WebElement> sugg = driver.findElements(By.xpath("//div[contains(text(),'samsung s20')]"));
			for (WebElement suggestions : sugg) 
			{
				System.out.println(suggestions.getText());

			}
		}
		//driver.findElement(By.xpath("//*[@class='L0Z3Pu']"));


		//		
		//		WebDriverManager.chromedriver().setup();
		//		WebDriver driver= new ChromeDriver();
		//		driver.manage().window().maximize();
		//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//		driver.get("https://www.flipkart.com/");
		//		System.out.println(driver.getTitle());
		//		assertEquals(driver.getTitle(), "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
		//		driver.findElement(By.xpath("//button[text()='✕']")).click();
		//		driver.findElement(By.name("q")).sendKeys("mobiles");
		//		driver.findElement(By.xpath("//button[@type='submit']")).click();
		//		driver.findElement(By.xpath("//div[.='POCO C55 (Cool Blue, 64 GB)']")).click();
		//		System.out.println(driver.getTitle());
		//		assertEquals(driver.getTitle(), "Mobiles- Buy Products Online at Best Price in India - All Categories | Flipkart.com");
		//		driver.getWindowHandle();
		//		Set<String> allWins = driver.getWindowHandles();
		//		for ( String win : allWins) {
		//			driver.switchTo().window(win);
		//		}
		//		
		//		WebElement spec = driver.findElement(By.xpath("//div[text()='Specifications']"));
		//		Actions a= new Actions(driver);
		//		a.moveToElement(spec).perform();
		//		
		//		List<WebElement> key = driver.findElements(By.xpath("//div[text()='General']/parent::div/table/tbody/tr/td"));
		//		List<WebElement> value = driver.findElements(By.xpath("//div[text()='General']/parent::div/table/tbody/tr/td/ul/li"));
		//		int count = key.size();
		//		HashMap<String,Integer> map= new HashMap<String,Integer>();
		//		for (int i = 0; i<count; i++) {
		//			List<String>list=new ArrayList<String>();
		//			list.add(key.get(i).getText());
		//			list.add(value.get(i).getText());
		//			
		//			//map.put(key, null)
		//			
		//		}
		//		driver.close();
	}
}
