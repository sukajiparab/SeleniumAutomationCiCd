package sukajiparab.seleniumFrameworkDesign;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import sukajiparab.seleniumFrameworkDesign.TestComponent.BaseTest;

public class submitOrderTest extends BaseTest{
	String productName="ZARA COAT 3";
	@Test(dataProvider="getData",groups= {"Purchase"})
	public  void submitOrder(HashMap<String,String> input) throws IOException {
		// TODO Auto-generated method stub
		
		
	
		
		productCatalogue ProductCatalogue= LandingPage.loginApplication(input.get("email"), input.get("password"));
		
		
		List<WebElement> products=ProductCatalogue.getProductList();
		
		ProductCatalogue.addProductTOCart(input.get("product"));
		
		CartPage cartPage=ProductCatalogue.cartPage();
		
		
		Boolean match=cartPage.VerifyProductDisplay(input.get("product"));
		
		
		Assert.assertTrue(match);
		CheckoutPage checkoutPage= cartPage.goToCheckout();
		checkoutPage.selectCountry("India");
		ConfirmationPge confirmationPage=checkoutPage.submitOrder();
		

		
		
		String confirmMessage=confirmationPage.verifyConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));


	}
	
	@Test(dependsOnMethods= {"submitOrder"})
	public void OrderHistoryTest() {
		productCatalogue ProductCatalogue= LandingPage.loginApplication("sukaji@gmail.com", "Sukaji@999");
		OrderPage orderPage=ProductCatalogue.goToOrderPage();
		Assert.assertTrue(orderPage.VerifyOrderDisplay(productName));
	}
	
	
	
	@DataProvider
	public Object[][] getData() throws IOException {
//		HashMap<String,String> map=new HashMap<String,String>();
//		map.put("email", "sukaji@gmail.com");
//		map.put("password", "Sukaji@999");
//		map.put("product","ZARA COAT 3");
//		
//		HashMap<String,String> map1=new HashMap<String,String>();
//		map1.put("email", "sukaji@hotmail.com");
//		map1.put("password", "Sukaji@999");
//		map1.put("product","ADIDAS ORIGINAL");
		
		
		List<HashMap<String,String>> data=getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\sukajiparab\\seleniumFrameworkDesign\\Data\\PurchaseOrder.json");
		return new Object[][] {{data.get(0)},{data.get(1)}}; 
	}
	
	
}
