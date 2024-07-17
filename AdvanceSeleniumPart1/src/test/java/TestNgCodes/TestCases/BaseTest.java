package TestNgCodes.TestCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import DemoWebShopTestCases.DataUtility;
import POM.HomePage;
import POM.LoginPage;


public class BaseTest {
	
	public DataUtility dataUtility = new DataUtility();
	public WebDriver driver;
	public HomePage homePage;
	
	@BeforeClass
	public void launchBrowser() throws IOException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(dataUtility.getDataFromProperties("url"));
	}
	
	@BeforeMethod
	public void loginApplication() throws IOException {
		homePage = new HomePage(driver);
		homePage.getLoginLink().click();
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.getEmailTextField().sendKeys(dataUtility.getDataFromProperties("email"));
		loginPage.getPasswordTextField().sendKeys(dataUtility.getDataFromProperties("password"));
		loginPage.getLoginButton().click();
	}
	
	@AfterMethod
	public void logoutApplication() {
		homePage.getLogoutLink().click();
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	
}
