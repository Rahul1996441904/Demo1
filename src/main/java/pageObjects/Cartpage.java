package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponent.Abstract_comp;

public class Cartpage extends Abstract_comp{
	
	WebDriver driver;
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cart_Products;
	
	@FindBy(css=".totalRow button")
	WebElement Checkout;
	
	public Cartpage(WebDriver driver)
	
	{
		super(driver);
	   this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
	//List<WebElement> cart_Products = driver.findElements(By.cssSelector(".cartSection h3"));
	//driver.findElement(By.cssSelector(".totalRow button")).click();
	
	public Boolean verifyproductdesplay(String productName)
	{
	
	boolean match = cart_Products.stream().anyMatch(a->a.getText().equalsIgnoreCase(productName));
	return match;
	
	}
	
	public void gotocheckout()
	{
		Checkout.click();
	}

	
	
	
	
}
