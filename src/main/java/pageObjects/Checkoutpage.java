package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import abstractcomponent.Abstract_comp;

public class Checkoutpage extends Abstract_comp {
	
	WebDriver driver;

	public Checkoutpage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);	

	}

	@FindBy(xpath="//a[@class='btnn action__submit ng-star-inserted']")
	WebElement submit;
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
	WebElement selectCountry;
	
	
	
	By result= By.cssSelector(".ta-results");
	
	public void selectcountry(String countryname)
	{

		Actions a = new Actions(driver);
		a.sendKeys(country, countryname).build().perform();
		
		WaitforElementtoappear(By.cssSelector(".ta-results"));

		selectCountry.click();
	}
	
	public void scrolldown()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy (200,200)");
	}
	
	public void submitorder()
	{
		submit.click();
	}
	
	
	
	


}
