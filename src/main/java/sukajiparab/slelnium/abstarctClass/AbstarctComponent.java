package sukajiparab.slelnium.abstarctClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import sukajiparab.seleniumFrameworkDesign.CartPage;
import sukajiparab.seleniumFrameworkDesign.OrderPage;

public class AbstarctComponent {
	

	WebDriver driver;
	public AbstarctComponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css="[routerLink*='cart']")
	WebElement cartHeader;
	
	@FindBy(css="[routerLink*='myorders']")
	WebElement orderHeader;
	
	public void waitForElementToApperar(By findBy) {
		
	WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
}
	
	public void waitForWebElementToApperar(WebElement findB) throws InterruptedException {
		Thread.sleep(1000);
//	WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
//	wait.until(ExpectedConditions.visibilityOf(findB));
}
	
	public CartPage cartPage() {
		cartHeader.click();
		CartPage cartPage=new CartPage(driver);
		return cartPage;
	}
	public OrderPage goToOrderPage() {
		orderHeader.click();
		OrderPage orderPage=new OrderPage(driver);
		return orderPage;
	}
	
	public void waitForElementToDispperar(WebElement ele) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
}
