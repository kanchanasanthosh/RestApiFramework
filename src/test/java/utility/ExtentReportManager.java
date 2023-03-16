package utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentReportManager {
	public static ExtentReports extentreports;
	
	public static  ExtentReports createInstance(String filename,String reportname,String documentTitle) {
		ExtentSparkReporter extentsparkreporter = new ExtentSparkReporter(filename);
		extentsparkreporter.config().setReportName(reportname);
		extentsparkreporter.config().setDocumentTitle(documentTitle);
		extentsparkreporter.config().setTheme(Theme.DARK);
		extentsparkreporter.config().setEncoding("Utf-8");
		
		 extentreports = new ExtentReports();
		extentreports.attachReporter(extentsparkreporter);
		return extentreports;
	}
	public static String getReportNamewithTimeStamp() {
		DateTimeFormatter dateTimeformatter = DateTimeFormatter.ofPattern("YYYY_MM_dd_HH_mm_ss" );
		LocalDateTime localDateTime=LocalDateTime.now();
	String formattedTime=	dateTimeformatter.format(localDateTime);
	String reportName ="TestReport"+formattedTime+".html";
	return reportName;
	
	}
	
	public static void logPassDetails(String log) {
		TestListeners.extentTest.get().pass(MarkupHelper.createLabel(log, ExtentColor.GREEN));
	}
	public static void logFailureDetails(String log) {
		TestListeners.extentTest.get().fail(MarkupHelper.createLabel(log, ExtentColor.RED));
	}
	public static void logInfoDetails(String log) {
		TestListeners.extentTest.get().info(MarkupHelper.createLabel(log, ExtentColor.GREY));
	}
	public static void logWarnDetails(String log) {
		TestListeners.extentTest.get().warning(MarkupHelper.createLabel(log, ExtentColor.YELLOW));
	}

}
