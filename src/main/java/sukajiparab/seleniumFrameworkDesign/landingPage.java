package sukajiparab.seleniumFrameworkDesign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sukajiparab.slelnium.abstarctClass.AbstarctComponent;

public class landingPage extends AbstarctComponent{
	WebDriver driver;
	public landingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//WebElement userEmail=driver.findElement(By.id("userEmail"));
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement passwordEle;
	
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	public productCatalogue loginApplication(String email, String password) {
		userEmail.sendKeys(email);
		passwordEle.sendKeys(password);
		submit.click();
		productCatalogue ProductCatalogue =new productCatalogue(driver);
		return ProductCatalogue;
	}
	
	public String getErrorMessage() throws InterruptedException {
		waitForWebElementToApperar(errorMessage);
		return errorMessage.getText();
	}
	
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client/");
	}
	
}
