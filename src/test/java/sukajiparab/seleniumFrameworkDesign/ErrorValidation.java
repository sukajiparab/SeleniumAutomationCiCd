package sukajiparab.seleniumFrameworkDesign;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import sukajiparab.seleniumFrameworkDesign.TestComponent.BaseTest;
import sukajiparab.seleniumFrameworkDesign.TestComponent.Retry;
public class ErrorValidation extends BaseTest{
	@Test(groups= {"rrorHandling"})
	public  void LoginValidation() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		String productName="ZARA COAT 3";
		
	
		
		LandingPage.loginApplication("sukaji@mail.com", "Sukaji@999");
		Assert.assertEquals("Incorrect email or password.", LandingPage.getErrorMessage());
		
		

	}
	
	
	@Test(retryAnalyzer=Retry.class)
	public  void ProductErrorValidation() throws IOException,InterruptedException {
		// TODO Auto-generated method stub
		String productName="ZARA COAT 3";
		
	
		
		productCatalogue ProductCatalogue= LandingPage.loginApplication("sukaji@gmail.com", "Sukaji@999");
		
		
		List<WebElement> products=ProductCatalogue.getProductList();
		
		ProductCatalogue.addProductTOCart(productName);
		
		CartPage cartPage=ProductCatalogue.cartPage();
		
		
		Boolean match=cartPage.VerifyProductDisplay("ZARA COAT 33");
		
		
		Assert.assertFalse(match);
		

	}
}
