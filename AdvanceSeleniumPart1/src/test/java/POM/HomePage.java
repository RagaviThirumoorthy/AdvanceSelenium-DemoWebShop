package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy(linkText = "Log in")
	private WebElement loginLink;
	
	@FindBy(linkText = "Log out")
	private WebElement logoutLink;
	
	@FindBy(xpath = "//span[text()='Shopping cart']")
	private WebElement cartLink;
	
	@FindBy(xpath = "//a[contains(text(),'Books')]")
	private WebElement booksLink;
	
	@FindBy(xpath = "//input[@value='Search store']")
	private WebElement searchProductTextfield;
	
	@FindBy(xpath = "//a[contains(text(),'Computers')]")
	private WebElement computerLink;
	
	@FindBy(xpath = "(//a[contains(text(),'Desktops')])[1]")
	private WebElement desktopLink;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getComputerLink() {
		return computerLink;
	}

	public WebElement getDesktopLink() {
		return desktopLink;
	}

	public WebElement getLoginLink() {
		return loginLink;
	}

	public WebElement getLogoutLink() {
		return logoutLink;
	}
	
	public WebElement getCartLink() {
		return cartLink;
	}
	
	public WebElement getBooksLink() {
		return booksLink;
	}
	
	public WebElement getSearchProductTextfield() {
		return searchProductTextfield;
	}
	
}
