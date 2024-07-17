package DemoWebShopTestCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Navigate to Demo web shop, Perform Login, Click on Books, Click on Fiction ex product, Verify Fiction Ex product is displayed, Logout and close.

public class BooksTestCase2 {

	public static void main(String[] args) throws IOException, InterruptedException {
		DataUtility dataUtility = new DataUtility();
		
		String url = dataUtility.getDataFromProperties("url");
		String email = dataUtility.getDataFromProperties("email");
		String password = dataUtility.getDataFromProperties("password");
		
		String homePageTitle = dataUtility.getDataFromExcel("TestCaseData", 2, 1);
		String loginPageTitle = dataUtility.getDataFromExcel("TestCaseData", 2, 2);
		String booksPageTitle = dataUtility.getDataFromExcel("TestCaseData", 2, 3);
		String fictionPageTitle = dataUtility.getDataFromExcel("TestCaseData", 2, 4);
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		
		if(driver.getTitle().equals(homePageTitle)) {
			System.out.println("Demo Web Shop page is displayed");
		}else {
			System.out.println("Demo Web Shop page is not displayed");
		}
		
		driver.findElement(By.xpath("//a[text()='Log in']")).click();
		
		if(driver.getTitle().equals(loginPageTitle)) {
			System.out.println("Login page is displayed");
		}else {
			System.out.println("Login page is not displayed");
		}

		driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),'Books')]")).click();
		Thread.sleep(2000);
		
		if(driver.getTitle().equals(booksPageTitle)) {
			System.out.println("Books page is displayed");
		}else {
			System.out.println("Books page is not displayed");
		}
		
		driver.findElement(By.xpath("//a[text()='Fiction EX']")).click();
		if(driver.getTitle().equals(fictionPageTitle)) {
			System.out.println("Fiction Ex product page is displayed");
		}
		
		String productName = driver.findElement(By.xpath("//div[@class='product-name']/h1")).getText();
		if(productName.contains("Fiction EX")) {
			System.out.println(productName+" product is displayed");
		}else {
			System.out.println(productName+" product is not displayed");
		}
		
		driver.findElement(By.xpath("//a[text()='Log out']")).click();
		
		Thread.sleep(3000);
		
		driver.quit();
		
	}

}
