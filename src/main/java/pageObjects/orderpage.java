package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponent.Abstract_comp;

public class orderpage extends Abstract_comp {
	
	WebDriver driver;
	
	public orderpage(WebDriver driver)
	
	{
		super(driver);
	   this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> order_Products;
	
	public Boolean verifyordertdesplay(String productName)
	{
	
	boolean match = order_Products.stream().anyMatch(a->a.getText().equalsIgnoreCase(productName));
	return match;
	
	}

}
