package utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import constants.SourcePath;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class TestListeners implements ITestListener{
	
	private static ExtentReports extentreports;
	
	public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
	
	public void onStart(ITestContext context) {
		String filename = ExtentReportManager.getReportNamewithTimeStamp();
		String fullreportpath=SourcePath.USER_DIR+"\\reports\\"+filename;
		extentreports=ExtentReportManager.createInstance(fullreportpath, "XApiRestFramework Report","Test ExecutionReport");
	}
	
	public void onFinish(ITestContext context) {
		if(extentreports != null)
			extentreports.flush();
	}

	
	public void onTestStart(ITestResult result) {
	ExtentTest test=extentreports.createTest(result.getMethod().getMethodName());
	extentTest.set(test);
	}
	

}
