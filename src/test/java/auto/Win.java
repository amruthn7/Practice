package auto;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Win {

	@Test
	public void testName() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://secure.indeed.com/");
	//	Thread.sleep(5000);
		driver.findElement(By.id("login-google-button")).click();
		//Thread.sleep(5000);
		driver.findElement(By.id("apple-signin-button")).click();

		Set<String> allWh = driver.getWindowHandles();
		int count = allWh.size();
		System.out.println(count);
		for(String wh:allWh) {
			driver.switchTo().window(wh);
			String text = driver.getTitle();
			System.out.println(text);
		}
		//driver.close();
	}
}
