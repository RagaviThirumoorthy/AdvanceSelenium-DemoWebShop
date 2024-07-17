package POMTestCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import DemoWebShopTestCases.DataUtility;
import POM.BooksPage;
import POM.HomePage;
import POM.LoginPage;
import TestNgCodes.TestCases.BaseTest;

//Navigate to Demo web shop, Perform Login, Click on Books Link, Verify books page is displayed or not, Logout and close.


public class BooksTestCase1 extends BaseTest{

	@Test
	public void booksTestCase1() throws IOException, InterruptedException {

		String booksPageTitle = dataUtility.getDataFromExcel("TestCaseData", 1, 3);
				
		homePage.getBooksLink().click();
		
		Assert.assertEquals(driver.getTitle(), booksPageTitle);
		System.out.println(driver.getTitle()+" page is displayed");

	}

}
