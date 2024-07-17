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
import POM.FictionEXProductPage;
import POM.HomePage;
import POM.LoginPage;
import TestNgCodes.TestCases.BaseTest;

//Navigate to Demo web shop, Perform Login, Click on Books, Click on Fiction ex product, Verify Fiction Ex product is displayed, Logout and close.

public class BooksTestCase2 extends BaseTest{

	@Test
	public void booksTestCase2() throws IOException, InterruptedException {

		String booksPageTitle = dataUtility.getDataFromExcel("TestCaseData", 2, 3);
		String fictionPageTitle = dataUtility.getDataFromExcel("TestCaseData", 2, 4);
		
		homePage.getBooksLink().click();
		
		Assert.assertEquals(driver.getTitle(), booksPageTitle);
		System.out.println(booksPageTitle+" page is displayed");
		
		BooksPage booksPage = new BooksPage(driver);
		booksPage.getFictionEXLink().click();
		Assert.assertEquals(driver.getTitle(), fictionPageTitle);
		System.out.println(driver.getTitle()+" page is displayed");
		
		FictionEXProductPage fictionPage = new FictionEXProductPage(driver);
		String productName = fictionPage.getProduct().getText();
		Assert.assertEquals(productName, "Fiction EX");
		System.out.println(productName+" product is displayed");
	
		
	}

}
