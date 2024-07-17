package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DesktopPage {
	
	@FindBy(xpath = "//div[@class='product-item']//a[text()='Simple Computer']")
	private WebElement simpleComputerLink;
	
	public DesktopPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getSimpleComputerLink() {
		return simpleComputerLink;
	}
	
}
