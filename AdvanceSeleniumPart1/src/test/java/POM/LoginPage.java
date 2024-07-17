package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(id = "Email")
	private WebElement emailTextField;
	
	@FindBy(name = "Password")
	private WebElement passwordTextField;
	
	@FindBy(css = "input[type='checkbox']")
	private WebElement rememberMeCheckbox;
	
	@FindBy(linkText = "Forgot password?")
	private WebElement forgotPasswordLink;
	
	@FindBy(xpath = "//input[@value='Log in']")
	private WebElement loginButton;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getRememberMeCheckbox() {
		return rememberMeCheckbox;
	}

	public WebElement getForgotPasswordLink() {
		return forgotPasswordLink;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	

}
