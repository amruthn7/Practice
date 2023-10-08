package Aspire;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CricBuzz {

	@Test
	public void testName() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.cricbuzz.com/");
		driver.findElement(By.xpath("//img[@class='cb-view-all-ga']")).click();
		String team1="India";
		String team2="Nepal";
		driver.findElement(By.xpath("//a[@title='"+team1+" v "+team2+" - Quarter Final 1']")).click();
		driver.findElement(By.xpath("//a[@title='"+team1+" vs "+team2+", Quarter Final 1 Scorecard']")).click();

		//List<WebElement> players = driver.findElements(By.xpath("//div[@id='innings_1']/div[@class='cb-col cb-col-100 cb-ltst-wgt-hdr']/div[@class='cb-col cb-col-100 cb-scrd-itms']/div/a[@class='cb-text-link']"));
		List<WebElement> sc = driver.findElements(By.xpath("//div[@id='innings_1']/div[@class='cb-col cb-col-100 cb-ltst-wgt-hdr']/div[@class='cb-col cb-col-100 cb-scrd-itms']/div[@class='cb-col cb-col-8 text-right text-bold']"));
		ArrayList<Integer> list= new ArrayList<Integer>();

		for (int i = 0; i < sc.size(); i++) {
			String score = sc.get(i).getText();
			list.add(Integer.parseInt(score));
		}
		Collections.sort(list);
		
		int count=0;
		for (int i = list.size()-1; i >=0 ; i--) {
			int top=3;
			if(count<top) {
				Integer s = list.get(i);
				WebElement p = driver.findElement(By.xpath("//div[@id='innings_1']/div[@class='cb-col cb-col-100 cb-ltst-wgt-hdr']/div[@class='cb-col cb-col-100 cb-scrd-itms']/div[contains(text(),'"+s+"')]/preceding-sibling::div[@class='cb-col cb-col-25 ']/a"));
				System.out.println(p.getText()+"-->"+list.get(i));
				count++;
			}
		}
		//driver.close();
	}
}
