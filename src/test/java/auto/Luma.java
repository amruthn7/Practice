package auto;

import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Luma {

	@Test
	public void LumaTest() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://magento.softwaretestingboard.com/");
		WebElement women = driver.findElement(By.xpath("//span[text()='Women']"));
		Actions a= new Actions(driver);
		a.moveToElement(women).perform();
		WebElement top = driver.findElement(By.xpath("//a[@id='ui-id-9']"));
		a.moveToElement(top).perform();
		driver.findElement(By.xpath("//a[@id='ui-id-13']/span[text()='Tees']")).click();
		driver.findElement(By.xpath("//input[@id='search']")).sendKeys("Tops");
		List<WebElement> qua = driver.findElements(By.xpath("//span[@class='amount']"));
		TreeSet<Integer> set= new TreeSet<Integer>();
		for (int i = 0; i < qua.size(); i++) {
			String data = qua.get(i).getText();
			int d = Integer.parseInt(data);
			set.add(d);
		}
		System.out.println(set);
		
	}
}
