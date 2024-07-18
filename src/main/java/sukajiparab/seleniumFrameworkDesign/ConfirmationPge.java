package sukajiparab.seleniumFrameworkDesign;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sukajiparab.slelnium.abstarctClass.AbstarctComponent;

public class ConfirmationPge extends AbstarctComponent{
	WebDriver driver;
	public ConfirmationPge(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css=".hero-primary")
	WebElement confirmationMessage;
	
	public String verifyConfirmationMessage() {
		return confirmationMessage.getText();
	}
	
}
