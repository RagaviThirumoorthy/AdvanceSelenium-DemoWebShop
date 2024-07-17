package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FictionEXProductPage {
	
	@FindBy(xpath = "//div[@class='product-name']/h1")
	private WebElement product;
	
	public FictionEXProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getProduct() {
		return product;
	}
	
		
}
