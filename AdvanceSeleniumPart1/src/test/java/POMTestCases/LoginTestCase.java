package POMTestCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import DemoWebShopTestCases.DataUtility;
import POM.HomePage;
import POM.LoginPage;
import TestNgCodes.TestCases.BaseTest;


public class LoginTestCase extends BaseTest{

	@Test
	public void loginTestCase() throws IOException {
		
		DataUtility dataUtility = new DataUtility();
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(dataUtility.getDataFromProperties("url"));
		
		HomePage homePage = new HomePage(driver);
		homePage.getLoginLink().click();
		if(driver.getTitle().equals("Demo Web Shop. Login")) {
			System.out.println("Demo Web Shop. Login page is displayed");
		}else {
			System.out.println("Demo Web Shop. Login page is not displayed");
		}
			
		LoginPage loginPage = new LoginPage(driver);
		loginPage.getEmailTextField().sendKeys(dataUtility.getDataFromProperties("email"));
		loginPage.getPasswordTextField().sendKeys(dataUtility.getDataFromProperties("password"));
		loginPage.getRememberMeCheckbox().click();
		loginPage.getLoginButton().click();
		if(driver.getTitle().equals("Demo Web Shop")){
			System.out.println("Test Case Passed");
		}else {
			System.out.println("Test Case Failed");
		}
		
		driver.quit();

	}

}
