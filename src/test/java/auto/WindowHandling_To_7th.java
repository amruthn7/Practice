package auto;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandling_To_7th {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://secure.indeed.com/");
		driver.findElement(By.id("apple-signin-button")).click();
		Thread.sleep(2000);

		driver.findElement(By.id("login-facebook-button")).click();
		Thread.sleep(2000);

		String expTitleFB = "Facebook";
		Set<String> allWin = driver.getWindowHandles();
		ArrayList<String> list= new ArrayList<String>(allWin);
		for (String win : list) {
			String actTit = driver.getTitle();
			if(list.size()>=2){
				String thwin = list.get(2);
				driver.switchTo().window(thwin);
				Thread.sleep(2000);

				driver.close();
			}
		}
	}
}
