package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReport {
	
	public static ExtentReports getreportobject() 
	
	{
	
	//	String path = System.getProperty("user.dir")+"/reports/index.html";
		
		String path = System.getProperty("C:\\Users\\Rahul Patekar\\eclipse-workspace\\Maven_Project")+"/reports/index2.html";
		ExtentSparkReporter report = new ExtentSparkReporter(path);
		
		report.config().setDocumentTitle("Test result");
		report.config().setReportName("Automation results");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("tester", "Rahul");
		extent.createTest(path);
		return extent;
	}

}
