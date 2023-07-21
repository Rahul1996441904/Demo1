package cucumber;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import javaComponents.Base_Test;
import pageObjects.Cartpage;
import pageObjects.Checkoutpage;
import pageObjects.Conformationpage;
import pageObjects.Landing_page;
import pageObjects.ProductCatlog;

public class Steporder extends Base_Test {


	public Landing_page landingPage;
	Landing_page lp = new Landing_page(driver);
	Cartpage cp = new Cartpage(driver);
	ProductCatlog pc = new ProductCatlog(driver);
	Checkoutpage cpg = new Checkoutpage(driver);
	Conformationpage conform = new Conformationpage(driver);
	
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException
	{
		  initilizedriver();
		//code
		 
	}
	@Given("^Logged in with username (.+) and password (.+)$")
	public void logged_in_username_and_password(String username, String password)
	{
		 lp.loginpage(username,password);
	}

	@When("^ I add product (.+) to Cart$")
	public void i_add_product_to_cart(String productName)
	{
		List<WebElement> prod = pc.getprodlist();
		pc.Addprodtocart(productName);
	}
	
	@When("^Checkout (.+) and submit the order$")
	public void  check_out_summit(String productName) throws InterruptedException

	{
		gotocartpage();
		Boolean match=	cp.verifyproductdesplay(productName);
		Assert.assertTrue(match);
		Thread.sleep(1000);
		cp.gotocheckout();
		cpg.selectcountry("India");
		cpg.submitorder();
		
	}
	

	  private void gotocartpage() {
		// TODO Auto-generated method stub
		
	}
	@Then("{String} message is displayed on ConfirmationPage")
	  public void massage_displayed_in_conformationpage(String string)
	  {
		  
			String massage = conform.conformationmassage();

			Assert.assertTrue(massage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
			System.out.println("correct");
	  }
	  

}
