package auto;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Chimera {

	@Test
	public void test() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://cosmocode.io/automation-practice-webtable/");
		List<WebElement> countryName = driver.findElements(By.xpath("//table/tbody/tr/td[contains(text(),'Dinar')]/following-sibling::td[contains(text(),'Arabic')]/parent::tr/td/strong"));
		for (WebElement ele : countryName) {
			System.out.println(ele.getText());
		}
	}
	
}
