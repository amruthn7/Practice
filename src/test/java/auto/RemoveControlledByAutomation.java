package auto;

import java.util.ArrayList;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RemoveControlledByAutomation {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options= new ChromeOptions();
//		ArrayList<String> list= new ArrayList<String>();
//		list.add("enable-automation");
//		options.setExperimentalOption("excludeSwitches", list);
		
		options.addArguments("incognito");
		ChromeDriver driver= new ChromeDriver(options);
		driver.get("https://www.google.com/");
	}
}
