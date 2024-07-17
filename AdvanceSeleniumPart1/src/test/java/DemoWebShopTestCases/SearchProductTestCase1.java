package DemoWebShopTestCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//Navigate to Demo web shop, Perform Login, Search for blue jeans, Verify blue jeans product is displayed or not, Logout and close.

public class SearchProductTestCase1 {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		DataUtility dataUtility = new DataUtility();
		
		String url = dataUtility.getDataFromProperties("url");
		String email = dataUtility.getDataFromProperties("email");
		String password = dataUtility.getDataFromProperties("password");
		
		String productName = dataUtility.getDataFromExcel("TestCaseData", 3, 1);
		String homePageTitle = dataUtility.getDataFromExcel("TestCaseData", 3, 2);
		String loginPageTitle = dataUtility.getDataFromExcel("TestCaseData", 3, 3);
		
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
		
		driver.findElement(By.xpath("//input[@value='Search store']")).sendKeys("Blue Jeans",Keys.ENTER);
		WebElement product = driver.findElement(By.xpath("//h2[@class='product-title']/a"));
		if(product.getText().equals(productName)) {
			System.out.println(product.getText()+" product is displayed");
		}else {
			System.out.println(product.getText()+" product is not displayed");
		}
		
		driver.findElement(By.xpath("//a[text()='Log out']")).click();
		
		Thread.sleep(3000);
		
		driver.quit();

	}

}
