package auto;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UpperCase {


	@Test
	public void test() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		List<WebElement> countryName = driver.findElements(By.xpath("//div[@class=\"caption\"][translate(text(),'abcdefghigklmnopqrstuwxyz','ABCDEFGHIGKLMNOPQRSTUWXYZ')]"));
		for (WebElement ele : countryName) {
			System.out.println(ele.getText());
		}
	}

}
