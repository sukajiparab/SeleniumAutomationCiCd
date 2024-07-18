package sukajiparab.seleniumFrameworkDesign;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sukajiparab.slelnium.abstarctClass.AbstarctComponent;

public class CartPage extends AbstarctComponent{
	WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//WebElement userEmail=driver.findElement(By.id("userEmail"));
	
	@FindBy(css=".totalRow button")
	WebElement checkoutEle;
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartProducts;

	
	
public CheckoutPage goToCheckout() {
	checkoutEle.click();
	CheckoutPage checkoutPage=new CheckoutPage(driver);
	return checkoutPage;
}


public Boolean VerifyProductDisplay(String productName) {
	
	Boolean match =cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
	return match;
}

	
}
