package TestNgCodes.AnnotationsAttributes;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ConfigureAnnotationsEg {
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Connect Server");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Connect to DB");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("Launch Browser");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Login");
	}
	
	@Test
	public void testCase1() {
		System.out.println("Test Case 1 pass");
	}
	
	@Test
	public void testCase2() {
		System.out.println("Test Case 2 pass");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("Logout");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("Close browser");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("Disconnect DB");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("Disconnect server");
	}

}
