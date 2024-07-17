package POMTestCases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class POMAnnotationsEg {

	//To locate multiple webelements
	@FindBy(xpath = "//h2[@class='product-title']")
	private List<WebElement> allProducts;

	//Multiple findBy for same element, Acts as OR Operator
	@FindAll({@FindBy(id = "Email"),@FindBy(name = "Email")})
	private WebElement email;
	
	//Multiple findBy for same element, Acts as AND Operator
	@FindBys({@FindBy(className = "password"),@FindBy(id="Password")})
	private WebElement password;

}
