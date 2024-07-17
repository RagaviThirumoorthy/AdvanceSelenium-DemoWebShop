package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage {
	
	@FindBy(xpath = "//h2[@class='product-title']/a")
	private WebElement blueJeanProduct;
	
	public SearchResultsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getBlueJeanProduct() {
		return blueJeanProduct;
	}
	
	
}
