package TestNgCodes.AnnotationsAttributes;

import org.testng.annotations.Test;

public class MultipleTestAnnotations {
	
	@Test(priority = 0)							//Priority-->Helper attribute
	public void register() {
		System.out.println("Register");
	}
	
	@Test(priority = 1)
	public void login() {
		System.out.println("Login");
	}
	
	@Test(priority = 2,enabled = false)
	public void addToCart() {
		System.out.println("Add to cart");
	}
	
	@Test(priority = 3)
	public void placeOrder() {
		System.out.println("Place order");
	}
	
	@Test(priority = 4)
	public void logout() {
		System.out.println("Logout");
	}
}
