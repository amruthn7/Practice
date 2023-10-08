package auto;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Google_Sugg {

	@Test
	public void google_Sugg() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https:google.com");
		driver.findElement(By.name("q")).sendKeys("java");
		List<WebElement> allSugg = driver.findElements(By.xpath("//span[text()='java']"));
		int count=allSugg.size();
		System.out.println(count);
//		for(WebElement i: allSugg) {
//			String text = i.getText();
//			System.out.println(text);
//		}
		allSugg.get(count-3).click();
//		driver.navigate().back();
//		driver.findElement(By.name("q")).sendKeys("Java");
//		allSugg.get(count-1);	
		}

}
