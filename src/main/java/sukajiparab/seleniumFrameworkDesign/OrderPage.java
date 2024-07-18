package sukajiparab.seleniumFrameworkDesign;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sukajiparab.slelnium.abstarctClass.AbstarctComponent;

public class OrderPage extends AbstarctComponent{
	WebDriver driver;
	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//WebElement userEmail=driver.findElement(By.id("userEmail"));
	
	@FindBy(css=".totalRow button")
	WebElement checkoutEle;
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> productNames;

	
	



public Boolean VerifyOrderDisplay(String productName) {
	
	Boolean match =productNames.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
	return match;
}

	
}
