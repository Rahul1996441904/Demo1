package abstractcomponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Abstract_comp {

	WebDriver driver;

	public Abstract_comp(WebDriver driver) 
	{

		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css= "[routerlink*='cart']")
	WebElement cartheader;


	@FindBy(css= "[routerlink*='myorders']")
	WebElement orderheader;

	public void gotocartpage()
	{
		cartheader.click();	
	}


	public void WaitforElementtoappear(By findby)
	{

		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));

		//wait until all product load

		wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
	}
	
	public void gotoorderpage()
	{

		orderheader.click();
	
	}
	
	

	public void WaitforWebElementtoappear(WebElement findby)
	{

		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));

		//wait until all product load

		wait.until(ExpectedConditions.visibilityOf(findby));
	}





	public void waitforElementtoDisappear(WebElement ele) throws InterruptedException
	{

		//	Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
	}
}






