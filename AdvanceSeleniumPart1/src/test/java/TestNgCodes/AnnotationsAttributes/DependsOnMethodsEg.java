package TestNgCodes.AnnotationsAttributes;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependsOnMethodsEg {

	@Test
	public void addAddress() {
		System.out.println("Address added");
		Assert.fail();
	}
	
	@Test(dependsOnMethods = "addAddress")
	public void modifyAddress() {
		System.out.println("Address modified");
	}
	
	@Test(dependsOnMethods = {"modifyAddress","addAddress"})
	public void deleteAddress() {
		System.out.println("Address deleted");
	}

}
