package pageObjects;

import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponent.Abstract_comp;


public class Landing_page extends Abstract_comp {
	
	WebDriver driver;
	
	public Landing_page(WebDriver driver) {
		super(driver);
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id = "userEmail")
	WebElement usermail;
	
	@FindBy(id = "userPassword")
	WebElement userm;
	
	@FindBy(id = "login")
	WebElement log;
	
	@FindBy(css = "[class*='flyInOut']")
	WebElement errormassage;
	
	public void loginpage(String mail,String password)
	{
		
		usermail.sendKeys(mail);
		userm.sendKeys(password);
		log.click();
		
	}
	 
	public String geterrormassage()
	{
		WaitforWebElementtoappear(errormassage);
		return errormassage.getText();
		
	}

	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	
	
	
	
	
	

}
