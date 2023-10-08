package auto;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BigBasket {

	@Test
	public void bigbasket() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions a=new Actions(driver);
		driver.get("https://www.bigbasket.com");
		WebElement shopCat = driver.findElement(By.xpath("//a[contains(.,' Shop by') and @qa='categoryDD']"));
		a.moveToElement(shopCat).perform();
		
		String option = "Foodgrains, Oil & Masala";
		WebElement firstDD = driver.findElement(By.xpath("//div[@id='navbar']/descendant::a[.='"+option+"']"));
		a.moveToElement(firstDD).perform();
		
		List<WebElement> secondDD = driver.findElements(By.xpath("//div[@id='navbar']/descendant::a[@qa='catL2']"));
		//FileInputStream fis=new FileInputStream("./src/test/resources/Output.xlsx");
		//Workbook wob=WorkbookFactory.create(fis);
		//Sheet sh = wob.createSheet("bigbasket1");
		//LinkedList<String> ls=new LinkedList<String>();
		for (WebElement fv : secondDD) 
		{
			String data = fv.getText();
			System.out.println("========"+data+"========");
			WebElement ele = driver.findElement(By.xpath("//div[@id='navbar']/descendant::a[.='"+data+"']"));
			a.moveToElement(ele).perform();
			List<WebElement> fAv= driver.findElements(By.xpath("//ul[@id='navBarMegaNav']//li[.='"+option+"']/parent::ul/following-sibling::div//a[@qa='catL3']"));
			for (WebElement wb : fAv) 
			{
				System.out.println(wb.getText());
				//ls.add(wb.getText());
			}
		}
//		int i=0;
//		for (String str : ls) 
//		{
//			sh.createRow(i).createCell(0).setCellValue(str);
//			i++;
//		}
//		FileOutputStream fos=new FileOutputStream("./src/test/resources/Output.xlsx");
//		wob.write(fos);
//		wob.close();
	}
}
