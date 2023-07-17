package Clarion.Maven_Project;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import javaComponents.Base_Test;
import pageObjects.Landing_page;

public class Errorvalidation extends Base_Test{




	@Test(groups= {"errorhandling"})
	public void order() throws IOException, InterruptedException
	{

	//	String productName = "ZARA COAT 3";
	
		Landing_page landingpage = new Landing_page(driver);
		landingpage.goTo();
		landingpage.loginpage("Rahull@123.com", "@123123abcA");
		
		
		Assert.assertEquals("Incorrect email or password.",landingpage.geterrormassage() );
		
		

}}
