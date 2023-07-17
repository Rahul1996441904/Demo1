package javaComponents;

import java.io.File; 
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import abstractcomponent.Abstract_comp;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.Landing_page;

public class Base_Test  {

	public WebDriver driver;
	Landing_page lp;

	@BeforeMethod(alwaysRun = true)
	public void initilizedriver() throws IOException {

		Properties ps = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\Rahul Patekar\\eclipse-workspace\\Maven_Project\\src\\test\\java\\javaComponents\\Globel.properties");
		// FileInputStream fis = new FileInputStream("C:\\Users\\Rahul
		// Patekar\\eclipse-workspace\\Maven_Project\\sre\\test\\java\\cucumber");
		ps.load(fis);
		String Browsername = ps.getProperty("Browser");
		if (Browsername.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		else if ((Browsername.equalsIgnoreCase("Firefox"))) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		// else if ((Browsername.equalsIgnoreCase("chrome")))
		// {
		// //chrome driver code
		// }

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		// return driver;

	}

	@AfterMethod(alwaysRun = true)
	public void close() {
		driver.close();
	}

	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";

	}

	public void onTestFailure(ITestResult result, String filepath) {
		// TODO Auto-generated method stub

	}

	// public Landing_page Launchapp() throws IOException
	// {
	//
	// driver=initilizedriver();
	// Landing_page lp = new Landing_page(driver);
	// lp.goTo();
	// return lp;
	//
	// }

}
