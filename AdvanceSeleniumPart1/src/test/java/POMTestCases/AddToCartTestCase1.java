package POMTestCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import DemoWebShopTestCases.DataUtility;
import POM.CartPage;
import POM.DesktopPage;
import POM.HomePage;
import POM.LoginPage;
import POM.SimpleComputerPage;
import TestNgCodes.TestCases.BaseTest;

//Navigate to Demo web shop, perform login,Mouse hover on computers, click on desktops, Click on Simple computer,Select processor and Add the product to cart
//Navigate to cart page and verify whether the product is added or not, Remove the product from the cart, Logout and close

public class AddToCartTestCase1 extends BaseTest{

	@Test
	public void addToCart() throws IOException, InterruptedException {

		String expproductName = dataUtility.getDataFromExcel("TestCaseData", 4, 3);
		String cartPageTitle = dataUtility.getDataFromExcel("TestCaseData", 4 , 4);
		
		//1. Mouse hover on computers
		Actions act = new Actions(driver);
		act.moveToElement(homePage.getComputerLink()).build().perform();
		
		//2. Click on desktops
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(homePage.getDesktopLink()));
		homePage.getDesktopLink().click();
		Thread.sleep(3000);
		
		//3. Click on Simple computer
		DesktopPage desktopPage = new DesktopPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(desktopPage.getSimpleComputerLink()));
		desktopPage.getSimpleComputerLink().click();
		
		//4. Select processor
		SimpleComputerPage simpleComputerPage = new SimpleComputerPage(driver);
		simpleComputerPage.getProcessorCheckbox().click();
		
		//5. Add the product to cart
		simpleComputerPage.getAddToCartLink().click();
		
		//6. Navigate to cart page
		homePage.getCartLink().click();
		Assert.assertEquals(driver.getTitle(), cartPageTitle);
		System.out.println(driver.getTitle()+" page is displayed");
		
		//7. Verify whether the product is added or not
		CartPage cartpage = new CartPage(driver);
		String actualProductName = cartpage.getProduct().getText();
		Assert.assertEquals(actualProductName , expproductName );
		System.out.println(actualProductName+" is added in the cart");
		
		//8. Remove the product from the cart
		cartpage.getRemoveProductCheckbox().click();
		cartpage.getUpdateCart().click();
		
	}

}
