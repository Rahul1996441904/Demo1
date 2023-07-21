package Clarion.Maven_Project;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import abstractcomponent.Abstract_comp;
import io.github.bonigarcia.wdm.WebDriverManager;
import javaComponents.Base_Test;
import pageObjects.Cartpage;
import pageObjects.Checkoutpage;
import pageObjects.Conformationpage;
import pageObjects.Landing_page;
import pageObjects.ProductCatlog;
import pageObjects.orderpage;

public class EndtoEnd extends Base_Test  {



	//	public static void main(String[] args) throws InterruptedException, IOException {
	// TODO Auto-generated method stub
	//String productName = "ZARA COAT 3";
	@Test(dataProvider="getdata")
	public void order(String Email ,String password, String productName) throws IOException, InterruptedException
	{



		//		Base_Test bs = new Base_Test();
		//		bs.initilizedriver();		
		//		WebDriverManager.edgedriver().setup();
		//		WebDriver driver = new EdgeDriver();
		//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//		driver.manage().window().maximize();


		Landing_page landingpage = new Landing_page(driver);
		landingpage.goTo();
		landingpage.loginpage(Email,password);

		//		driver.findElement(By.id("userEmail")).sendKeys("Rahul@123.com");
		//		driver.findElement(By.id("userPassword")).sendKeys("@123123abcA");
		//		driver.findElement(By.id("login")).click();
		//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

		ProductCatlog prodcatlog = new ProductCatlog(driver);
		List<WebElement> prod = prodcatlog.getprodlist();
		prodcatlog.Addprodtocart(productName);
		//	Thread.sleep(2000);
		Abstract_comp ab = new Abstract_comp(driver);
		ab.waitforElementtoDisappear(null);
		prodcatlog.gotocartpage();


		//	List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		//	WebElement prod1 =	products.stream().filter(product->
		//		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		//	prod1.findElement(By.cssSelector(".card-body button:last-of-type")).click();		
		//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		//		//ng-animating
		//		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		//		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();

		Cartpage cartpage = new Cartpage(driver);
		Boolean match=	cartpage.verifyproductdesplay(productName);

		//	List <WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));		
		//	Boolean match = cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));

		Assert.assertTrue(match);
		Thread.sleep(1000);
		cartpage.gotocheckout();
		//	driver.findElement(By.cssSelector(".totalRow button")).click();
		Checkoutpage checkout = new Checkoutpage(driver);
		checkout.selectcountry("India");

		Thread.sleep(3000);

		checkout.scrolldown();
		checkout.submitorder();


		//		Actions a = new Actions(driver);
		//		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
		//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		//		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		Thread.sleep(2000);

		Conformationpage conform = new Conformationpage(driver);
		String massage = conform.conformationmassage();

		//		driver.findElement(By.cssSelector(".action__submit")).click();
		//		String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();

		Assert.assertTrue(massage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		System.out.println("correct");

	}

	@Test(dependsOnMethods="order",dataProvider="getdata")
	public void Orderhistorytest(String Email ,String password, String productName) throws InterruptedException
	{
		Landing_page landingpage = new Landing_page(driver);
		landingpage.goTo();
		landingpage.loginpage(Email, password);

		orderpage order = new orderpage(driver);
		order.gotoorderpage();
		Thread.sleep(2000);
		Boolean match1 = order.verifyordertdesplay(productName);
		Assert.assertTrue(match1);

	}
	
	@DataProvider
	public Object[][] getdata()
	{
		Object[][] obj = new Object[][] {{"Rahul@123.com", "@123123abcA","ZARA COAT 3"},};
		
		return obj;
		
	}
	



}
