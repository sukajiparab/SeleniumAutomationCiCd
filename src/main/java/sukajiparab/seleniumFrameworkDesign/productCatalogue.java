package sukajiparab.seleniumFrameworkDesign;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sukajiparab.slelnium.abstarctClass.AbstarctComponent;

public class productCatalogue extends AbstarctComponent{
	WebDriver driver;
	public productCatalogue(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//WebElement userEmail=driver.findElement(By.id("userEmail"));
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;

	By productsBy=By.cssSelector(".mb-3");
	By addToCart=By.cssSelector(".card-body button:last-of-type");
	By toastMessage=By.id("toast-container");
	
public List<WebElement> getProductList() {
	waitForElementToApperar(productsBy);
	return products;
}

public WebElement getProductByName(String productName) {
	
	WebElement prod=getProductList().stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
	return prod;
}
	public void addProductTOCart(String productName) {
		WebElement prod=getProductByName(productName);
		prod.findElement(addToCart).click();
		waitForElementToApperar(toastMessage);
		waitForElementToDispperar(spinner);
	}
}
