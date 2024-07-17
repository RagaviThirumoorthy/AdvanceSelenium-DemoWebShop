package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SimpleComputerPage {
	
	@FindBy(xpath = "//input[@id='product_attribute_75_5_31_96']")
	private WebElement processorCheckbox;
	
	@FindBy(xpath = "//div[@class='product-name']/following-sibling::div[@class='add-to-cart']//input[@value='Add to cart']")
	private WebElement addToCartLink;
	
	

	public SimpleComputerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getProcessorCheckbox() {
		return processorCheckbox;
	}

	public WebElement getAddToCartLink() {
		return addToCartLink;
	}
	
	
	
}
