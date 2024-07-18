package sukajiparab.seleniumFrameworkDesign.stepDefinition;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import sukajiparab.seleniumFrameworkDesign.CartPage;
import sukajiparab.seleniumFrameworkDesign.CheckoutPage;
import sukajiparab.seleniumFrameworkDesign.ConfirmationPge;
import sukajiparab.seleniumFrameworkDesign.landingPage;
import sukajiparab.seleniumFrameworkDesign.productCatalogue;
import sukajiparab.seleniumFrameworkDesign.TestComponent.BaseTest;

public class stepDefinitionImpl extends BaseTest{
	public landingPage LandingPage;
	public productCatalogue ProductCatalogue;
	public ConfirmationPge confirmationPage;
	String productName="ZARA COAT 3";
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException {
		LandingPage=launchApplication();
	}
	
	@Given("^Logged in with username (.+) and password (.+)$")
	public void Logged_in_with_username_and_password(String username,String password) {

		productCatalogue ProductCatalogue= LandingPage.loginApplication(username,password);
	}
	
	@When("^I add the product (.+) to cart$")
	public void i_add_the_product_to_cart(String productName) {
		ProductCatalogue = new productCatalogue(driver); 
		List<WebElement> products=ProductCatalogue.getProductList();
		
		ProductCatalogue.addProductTOCart(productName);
	}
	
	
	@When("^Checkout (.+) and submit the order$")
	public void checkout_and_submit_order(String productName) {
		CartPage cartPage=ProductCatalogue.cartPage();
		
		
		Boolean match=cartPage.VerifyProductDisplay(productName);
		
		
		Assert.assertTrue(match);
		CheckoutPage checkoutPage= cartPage.goToCheckout();
		checkoutPage.selectCountry("India");
		confirmationPage=checkoutPage.submitOrder();
	}
	

	@Then("{string} message is displayed on ConfirmationPage")
	public void message_displayed_confirmationPage(String string) {
		String confirmMessage=confirmationPage.verifyConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
		driver.close();
	}
	
	 @Then("^\"([^\"]*)\" message is displayed$")
	    public void something_message_is_displayed(String strArg1) throws Throwable {
	   
	    	Assert.assertEquals(strArg1, LandingPage.getErrorMessage());
	    	driver.close();
	    }
	
}