//package javaComponents;
//
//
//import java.io.IOException; 
//
//import org.openqa.selenium.WebDriver;
//import org.testng.ITestContext;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//
//
//import resources.ExtendReport;
//
//public class Listeners extends Base_Test implements ITestListener {
//	
//	public Listeners(WebDriver driver) {
//		super(driver);
//		// TODO Auto-generated constructor stub
//	}
//
//	ExtentTest test;
//	ExtentReports extent = ExtendReport.getreportobject();
//	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>(); //Thread safe
//	@Override
//	public void onTestStart(ITestResult result) {
//		// TODO Auto-generated method stub
//		test = extent.createTest(result.getMethod().getMethodName());
//		extentTest.set(test);//unique thread id(ErrorValidationTest)->test
//	}
//
//	@Override
//	public void onTestSuccess(ITestResult result) {
//		// TODO Auto-generated method stub
//		extentTest.get().log(Status.PASS, "Test Passed");
//		
//	}
//
//	@Override
//	public void onTestFailure(ITestResult result) {
//		// TODO Auto-generated method stub
//		extentTest.get().fail(result.getThrowable());//
//		
//		try {
//			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver")
//					.get(result.getInstance());
//			
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
//		
//		
//		String filePath = null;
//		try {
//			
//			filePath = getScreenshot(result.getMethod().getMethodName(),driver);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
//		
//		
//		//Screenshot, Attach to report
//		
//		
//	}
//
//	@Override
//	public void onTestSkipped(ITestResult result) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void onStart(ITestContext context) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void onFinish(ITestContext context) {
//		// TODO Auto-generated method stub
//		extent.flush();
//		
//	}
//	
//
////	ExtentReports extent = ExtendReport.getreportobject();
////	ExtentTest test;
////	@Override
////	public void onTestStart(ITestResult result) {
////		 
////		
////		
////	//	test = extent.createTest(result.getMethod().getMethodName());
////		
////	//	ITestListener.super.onTestStart(result);
////	}
////
////	@Override
////	public void onTestSuccess(ITestResult result) {
////		
////		test.log(Status.PASS, "test pass");
////		// TODO Auto-generated method stub
////	//	ITestListener.super.onTestSuccess(result);
////	}
////
////	@Override
////	public void onTestFailure(ITestResult result) {
////		
////		//test.log(Status.FAIL, "test fail");
////		test.fail(result.getThrowable());
////		
////
////	//SS	
////	
////		
////	//	ITestListener.super.onTestFailure(result);
////	}
////
////	@Override
////	public void onTestSkipped(ITestResult result) {
////		// TODO Auto-generated method stub
////	//	ITestListener.super.onTestSkipped(result);
////	}
////
////	@Override
////	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
////		// TODO Auto-generated method stub
////	//	ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
////	}
////
////	@Override
////	public void onTestFailedWithTimeout(ITestResult result) {
////		// TODO Auto-generated method stub
////	//	ITestListener.super.onTestFailedWithTimeout(result);
////	}
////
////	@Override
////	public void onStart(ITestContext context) {
////		// TODO Auto-generated method stub
////	//	ITestListener.super.onStart(context);
////	}
////
////	@Override
////	public void onFinish(ITestContext context) {
////		// TODO Auto-generated method stub
////	//	ITestListener.super.onFinish(context);
////		
////		extent.flush();
////	}
//	
//	
//	
//
//}
