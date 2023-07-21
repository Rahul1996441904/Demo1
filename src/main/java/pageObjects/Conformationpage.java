package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponent.Abstract_comp;

public class Conformationpage extends Abstract_comp {
	
	WebDriver driver;
	
	public Conformationpage(WebDriver driver)
	
	{
		super(driver);
	   this.driver=driver;
		PageFactory.initElements(driver, this);	
	}

	
	@FindBy(css=".hero-primary")
	WebElement conformationmassage;
	
	public String conformationmassage()
	{
		String massage = conformationmassage.getText();
		return massage;
		
	}
	
	
}
