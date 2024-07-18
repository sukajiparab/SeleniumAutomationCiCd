package sukajiparab.seleniumFrameworkDesign;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import sukajiparab.slelnium.abstarctClass.AbstarctComponent;

public class CheckoutPage extends AbstarctComponent{
	WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//WebElement userEmail=driver.findElement(By.id("userEmail"));
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement country;
	
	By results=By.cssSelector(".ta-results");
	
	@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
	WebElement selectCountry;
	
	@FindBy(css=".action__submit")
	WebElement submit;
	

	public void selectCountry(String countryName) {
		
		Actions a =new Actions(driver);
		a.sendKeys(country,countryName).build().perform();
		waitForElementToApperar(results);
		selectCountry.click();
	}
	
public ConfirmationPge submitOrder() {
	submit.click();
	return new ConfirmationPge(driver);
}


	
}
