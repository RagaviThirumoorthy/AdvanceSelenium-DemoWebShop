package POMTestCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import DemoWebShopTestCases.DataUtility;
import POM.HomePage;
import POM.LoginPage;
import POM.SearchResultsPage;
import TestNgCodes.TestCases.BaseTest;

//Navigate to Demo web shop, Perform Login, Search for blue jeans, Verify blue jeans product is displayed or not, Logout and close.

public class SearchProductTestCase1 extends BaseTest {

	@Test
	public void searchProductTestcase() throws IOException, InterruptedException {
	
		String productName = dataUtility.getDataFromExcel("TestCaseData", 3, 1);
		
		homePage.getSearchProductTextfield().sendKeys("Blue Jeans",Keys.ENTER);
		SearchResultsPage searchResults = new SearchResultsPage(driver);
		WebElement product = searchResults.getBlueJeanProduct();
		
		Assert.assertEquals(product.getText(), productName);
		System.out.println(product.getText()+" product is displayed");

	}

}
