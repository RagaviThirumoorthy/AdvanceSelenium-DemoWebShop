package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	@FindBy(xpath = "//td[@class='product']/a")
	private WebElement product;
	
	@FindBy(xpath = "//input[@name='removefromcart']")
	private WebElement removeProductCheckbox;
	
	@FindBy(xpath="//input[@value='Update shopping cart']")
	private WebElement updateCart;
	
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getProduct() {
		return product;
	}

	public WebElement getUpdateCart() {
		return updateCart;
	}

	public WebElement getRemoveProductCheckbox() {
		return removeProductCheckbox;
	}

}
