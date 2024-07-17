package TestNgCodes.AnnotationsAttributes;

import org.testng.annotations.Test;

public class TestAnnotationEg {
	
	@Test
	public void testCase() {
		System.out.println("Launch Browser");
		System.out.println("Perform Login");
		System.out.println("Test Case passed");
	}
	
	public static void main(String[] args) {
		System.out.println("main method");
	}
}
