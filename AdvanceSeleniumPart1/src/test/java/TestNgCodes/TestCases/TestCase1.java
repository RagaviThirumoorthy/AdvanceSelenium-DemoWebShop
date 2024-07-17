package TestNgCodes.TestCases;

import org.testng.annotations.Test;

public class TestCase1 extends BaseTest{

	@Test
	public void testCase1() {
		
		System.out.println(driver.getTitle());

	}

}
