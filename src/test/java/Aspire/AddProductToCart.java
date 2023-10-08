package Aspire;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddProductToCart {

	@Test
	public void addProductToCartTest() {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));

		JavascriptExecutor js=(JavascriptExecutor)driver;
		driver.get("https://demo.nopcommerce.com/");
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		assertEquals(pageTitle,"nopCommerce demo store");
		
		//register
		driver.findElement(By.xpath("//a[@class='ico-register']")).click();
		String regPageTitle = driver.getTitle();
		System.out.println(regPageTitle);
		assertEquals(regPageTitle,"nopCommerce demo store. Register");
		driver.findElement(By.id("gender-male")).click();
		driver.findElement(By.id("FirstName")).sendKeys("Amruth");
		driver.findElement(By.id("LastName")).sendKeys("N");
		
		WebElement date = driver.findElement(By.name("DateOfBirthDay"));
		new Select(date).selectByValue("7");
		
		WebElement month = driver.findElement(By.name("DateOfBirthMonth"));
		new Select(month).selectByVisibleText("May");
		
		WebElement year = driver.findElement(By.name("DateOfBirthYear"));
		new Select(year).selectByVisibleText("1995");
		
		int ran= new Random().nextInt(100);
		String email="amr"+ran+"@gmail.com";
		driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.id("Company")).sendKeys("tyss");
		String pwsd="amruth123";
		driver.findElement(By.id("Password")).sendKeys(pwsd);
		driver.findElement(By.id("ConfirmPassword")).sendKeys(pwsd);
		driver.findElement(By.id("register-button")).click();


		String regSuccessMsg = driver.findElement(By.className("result")).getText();
		System.out.println(regSuccessMsg);
		assertEquals(regSuccessMsg,"Your registration completed");
		
		//login
		driver.findElement(By.xpath("//div[@class='buttons']/a[text()='Continue']")).click();
		driver.findElement(By.xpath("//a[@class='ico-login']")).click();
		driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.id("Password")).sendKeys(pwsd);
		driver.findElement(By.xpath("//button[@type='submit' and text()='Log in']")).click();
		
		//scroll down
		String productName="Apple MacBook Pro 13-inch";
		WebElement product = driver.findElement(By.xpath("//div[@class='product-item']/div[@class='details']/h2/a[text()='"+productName+"']"));
		js.executeScript("window.scrollTo(0,"+product.getLocation().getY()+")");
		product.click();
		
		String prdPageTitle = driver.getTitle();
		System.out.println(prdPageTitle);
		assertEquals(prdPageTitle,"nopCommerce demo store. Apple MacBook Pro 13-inch");
		
		String prdPrice = driver.findElement(By.id("price-value-4")).getText();
		System.out.println(prdPrice);
		driver.findElement(By.id("add-to-cart-button-4")).click();
		
		
		//scroll up
		WebElement shoppingCart = driver.findElement(By.xpath("//span[text()='Shopping cart']"));
		js.executeScript("window.scrollTo(0,"+shoppingCart.getLocation().getY()+")");
		shoppingCart.click();
		
		String cartPageTitle = driver.getTitle();
		System.out.println(cartPageTitle);
		assertEquals(cartPageTitle,"nopCommerce demo store. Shopping Cart");
		
		String actPrdName = driver.findElement(By.className("product-name")).getText();
		System.out.println(actPrdName);
		assertEquals(actPrdName, productName);
		
		String price = driver.findElement(By.xpath("//span[@class='product-unit-price']")).getText();
		System.out.println(price);
		assertEquals(prdPrice, price);
		
		String totalPrice = driver.findElement(By.xpath("//span[@class='product-subtotal']")).getText();
		System.out.println(totalPrice);
		
		WebElement checkoutBtn = driver.findElement(By.id("checkout"));
		js.executeScript("window.scrollTo(0,"+checkoutBtn.getLocation().getY()+")");
		driver.findElement(By.id("termsofservice")).click();
		checkoutBtn.click();
		String checkoutPageMsg = driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText();
		assertEquals(checkoutPageMsg,"Checkout");
		
		WebElement country = driver.findElement(By.id("BillingNewAddress_CountryId"));
		new Select(country).selectByVisibleText("India");
		WebElement state = driver.findElement(By.id("BillingNewAddress_StateProvinceId"));
		new Select(state).selectByVisibleText("Other");
		driver.findElement(By.id("BillingNewAddress_City")).sendKeys("Bangalore");
		driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("jp nagar, Bangalore");
		driver.findElement(By.id("BillingNewAddress_Address2")).sendKeys("jp nagar, Bangalore");
		driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("560058");
		driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("8576965525");

		driver.findElement(By.xpath("//button[@class='button-1 new-address-next-step-button' and @type='button' and @name='save' and text()='Continue']")).click();
		
		WebElement shippingbtn = driver.findElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button' and @type='button' and text()='Continue']"));
		wait.until(ExpectedConditions.visibilityOf(shippingbtn));

		js.executeScript("window.scrollTo(0,"+shippingbtn.getLocation().getY()+")");
		shippingbtn.click();
		
		WebElement payBtn = driver.findElement(By.xpath("//button[@class='button-1 payment-method-next-step-button' and @type='button' and text()='Continue']"));
		wait.until(ExpectedConditions.visibilityOf(payBtn));

		js.executeScript("window.scrollTo(0,"+payBtn.getLocation().getY()+")");
		payBtn.click();
		
		WebElement paynextBtn = driver.findElement(By.xpath("//button[@class='button-1 payment-info-next-step-button' and @type='button' and text()='Continue']"));
		wait.until(ExpectedConditions.visibilityOf(paynextBtn));

		js.executeScript("window.scrollTo(0,"+paynextBtn.getLocation().getY()+")");
		paynextBtn.click();
		
		WebElement confirmBtn = driver.findElement(By.xpath("//button[@class='button-1 confirm-order-next-step-button' and @type='button']"));
		wait.until(ExpectedConditions.visibilityOf(confirmBtn));
		js.executeScript("window.scrollTo(0,"+confirmBtn.getLocation().getY()+")");
		confirmBtn.click();

		String orderPlcdSuccessfulMsg = driver.findElement(By.xpath("//strong[text()='Your order has been successfully processed!']")).getText();
		assertEquals(orderPlcdSuccessfulMsg,"Your order has been successfully processed!");
		
		driver.findElement(By.xpath("//a[@class='ico-logout' and text()='Log out']")).click();
		try {
			assertEquals(pageTitle,"nopCommerce demo store");
			System.out.println("Logged out successfully");
		} catch (Exception e) {
			System.out.println("User not Logged out successfully");
		}
		
		driver.close();
	}
}
