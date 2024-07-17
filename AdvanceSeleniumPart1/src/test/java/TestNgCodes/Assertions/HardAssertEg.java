package TestNgCodes.Assertions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class HardAssertEg{
	
	@Test
	public void testCase() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demowebshop.tricentis.com/");
		
//		Assert.assertEquals(driver.getTitle(), "Demo Web Shop");
		Assert.assertTrue(driver.getTitle().contains("Demo Web Shop"));
	 	Reporter.log(driver.getTitle()+" page is displayed");
		
		driver.findElement(By.partialLinkText("Books")).click();
//		Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Books");
		Assert.assertTrue(driver.getTitle().contains("Books"));
		Reporter.log(driver.getTitle()+" page is displayed");
		
		String actualProName = driver.findElement(By.linkText("Fiction EX")).getText();
//		Assert.assertEquals(actualProName, "Fiction EX");
		Assert.assertTrue(actualProName.contains("Fiction EX"));
		Reporter.log(actualProName+ " product is displayed");
		
		driver.quit();
		
	}

}
