package auto;

import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SpiceJet {

	@Test
	public void spiceJet() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");

		WebDriver driver= new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.spicejet.com/");
		driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[2]/div/div[2]/div[2]/div/div[2]/div[2]/div")).click();
		driver.findElement(By.xpath("//input[@value='Select Destination']")).click();
		WebElement desitination = driver.findElement(By.xpath("//div[text()='Delhi']"));
		Actions a =new Actions(driver);
		a.moveToElement(desitination).click().perform();
		
		WebElement calYM=driver.findElement(By.xpath("//div[@data-testid='undefined-calendar-picker']//child::div[text()='May ']"));
		int reqDate=23;
		int reqMon=06;
		int reqyear=2023;
		WebElement next=driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[4]/div/div[2]/div[2]/div[1]"));
		next.click();
		next.click();
		WebElement previous=driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[4]/div/div[2]/div[2]/div[2]"));
		previous.click();
		/*		String calenderYrMnText= calYM.getText();
			String calYear=calenderYrMnText.split(" ")[1];
			String calMonth=calenderYrMnText.split(" ")[0];
			int currentYrNo= Integer.parseInt(calYear);
			int currentMnNo= DateTimeFormatter.ofPattern("MMMM")
					.withLocale(Locale.ENGLISH)
					.parse(calMonth)
					.get(ChronoField.MONTH_OF_YEAR);


			while (currentYrNo< reqyear || currentMnNo < reqMon ) {
				next.click();
				calenderYrMnText= calYM.getText();
				calYear=calenderYrMnText.split(" ")[1];
				calMonth=calenderYrMnText.split(" ")[0];
				currentYrNo= Integer.parseInt(calYear);
				currentMnNo= DateTimeFormatter.ofPattern("MMMM")
						.withLocale(Locale.ENGLISH)
						.parse(calMonth)
						.get(ChronoField.MONTH_OF_YEAR);
			}

			while (currentYrNo > reqyear || currentMnNo > reqMon ) {
				previous.click();
				calenderYrMnText= calYM.getText();
				calYear=calenderYrMnText.split(" ")[1];
				calMonth=calenderYrMnText.split(" ")[0];
				currentYrNo= Integer.parseInt(calYear);
				currentMnNo= DateTimeFormatter.ofPattern("MMMM")
						.withLocale(Locale.ENGLISH)
						.parse(calMonth)
						.get(ChronoField.MONTH_OF_YEAR);
			}*/
		}
	}

