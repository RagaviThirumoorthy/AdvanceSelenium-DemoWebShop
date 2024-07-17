package DemoWebShopTestCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Navigate to Demowebshop, perform login,Mouse hover on computers, click on desktops, Click on Simple computer,Select processor and Add the product to cart
//Navigate to cart page and verify whether the product is added or not, Remove the product from the cart, Logout and close

public class AddTocartTestCase1 {

	public static void main(String[] args) throws IOException {
		
		DataUtility dataUtility = new DataUtility();
		
		String url = dataUtility.getDataFromProperties("url");
		String email = dataUtility.getDataFromProperties("email");
		String password = dataUtility.getDataFromProperties("password");
				
		String homePageTitle = dataUtility.getDataFromExcel("TestCaseData", 4, 1);
		String loginPageTitle = dataUtility.getDataFromExcel("TestCaseData", 4 , 2);
		String expproductName = dataUtility.getDataFromExcel("TestCaseData", 4, 3);
		String cartPageTitle = dataUtility.getDataFromExcel("TestCaseData", 4 , 4);
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//1. Navigate to Demowebshop
		driver.get(url);
		
		if(driver.getTitle().equals(homePageTitle)) {
			System.out.println("Demo Web Shop page is displayed");
		}else {
			System.out.println("Demo Web Shop page is not displayed");
		}
		
		//2. Perform login
		driver.findElement(By.xpath("//a[text()='Log in']")).click();
		
		if(driver.getTitle().equals(loginPageTitle)) {
			System.out.println("Login page is displayed");
		}else {
			System.out.println("Login page is not displayed");
		}
		
		driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		
		//3. Mouse hover on computers	
		WebElement computerEle = driver.findElement(By.xpath("//a[contains(text(),'Computers')]"));
		Actions act = new Actions(driver);
		act.moveToElement(computerEle).perform();
		
		//4. Click on desktops
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(text(),'Desktops')])[1]")));
		driver.findElement(By.xpath("(//a[contains(text(),'Desktops')])[1]")).click();
		
		//5. Click on Simple computer
		driver.findElement(By.xpath("//div[@class='product-item']//a[text()='Simple Computer']")).click();
		
		//6. Select processor
		driver.findElement(By.xpath("//input[@id='product_attribute_75_5_31_96']")).click();
		
		//7. Add the product to cart
		driver.findElement(By.xpath("//div[@class='product-name']/following-sibling::div[@class='add-to-cart']//input[@value='Add to cart']")).click();
		
		//8. Navigate to cart page
		driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();
		
		if(driver.getTitle().equals(cartPageTitle)) {
			System.out.println("Cart page is displayed");
		}else {
			System.out.println("Cart page is not displayed");
		}
		
		//9. Verify whether the product is added or not
		String actualProductName = driver.findElement(By.xpath("//td[@class='product']/a")).getText();
		if(actualProductName.equals(expproductName)) {
			System.out.println(actualProductName+" is added in the cart");
		}else {
			System.out.println(actualProductName+" is not added in the cart");
		}
		
		//10. Remove the product from the cart
		driver.findElement(By.xpath("//input[@name='removefromcart']")).click();
		driver.findElement(By.xpath("//input[@value='Update shopping cart']")).click();
		
		//11. Logout
		driver.findElement(By.xpath("//a[text()='Log out']")).click();
		
		//12. close
		driver.quit();
	}

}
