package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponent.Abstract_comp;

public class ProductCatlog extends Abstract_comp{
	
	WebDriver driver;
	public ProductCatlog(WebDriver driver)
	
	{
		super(driver);
	   this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
	//	List<WebElement> products =driver.findElements(By.cssSelector(".mb-3"));
	

	@FindBy(css = ".mb-3")
	List<WebElement> products;
	
	By prodBy = By.cssSelector(".mb-3");
	By Addtocart = By.xpath("(//button[@class='btn w-10 rounded'])[1]");
	By tostmassage= By.cssSelector("#toast-container");
	
	public  List<WebElement> getprodlist()
	{
		WaitforElementtoappear(prodBy);
		return products;
	}
	
	public WebElement getbyproductname(String Productname)
	{
		WebElement prod = getprodlist().stream().filter(s->s.findElement(By.cssSelector("b"))
				.getText().equalsIgnoreCase("ZARA COAT 3")).findFirst().orElse(null);
		
		return prod;
		
	}
	
	public void Addprodtocart(String prodname)
	{
		WaitforElementtoappear(tostmassage);
		WebElement prod=getbyproductname(prodname);
		prod.findElement(Addtocart).click();
	
	}
	

}
