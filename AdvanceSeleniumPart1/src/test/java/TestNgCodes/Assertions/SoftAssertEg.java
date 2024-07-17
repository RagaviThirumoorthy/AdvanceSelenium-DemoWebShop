package TestNgCodes.Assertions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertEg {
	
	@Test
	public void testCase() {
		
		SoftAssert sa= new SoftAssert();
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		sa.assertEquals(driver.getTitle(), "OrangeHRM");
		System.out.println("Home page is displayed");
		
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		sa.assertTrue(driver.getCurrentUrl().contains("dashboard"));
		System.out.println("Login successful.........");
		
		driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).click();
		driver.findElement(By.linkText("Logout")).click();
		
		sa.assertTrue(driver.getCurrentUrl().contains("login"));
		System.out.println("Logout successful..........");
		
		driver.quit();
		
		sa.assertAll();	//Mandatory method, Must USE
	}
}
