package com.comcast.crm.generic.ListenerUtility;

import java.io.File;
import java.time.LocalDateTime;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.webdriverutility.Javautility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;

import baseUtility.BaseClass;

public class ListenerUtility implements ITestListener, ISuiteListener {//interfaces use in selenium
	public ExtentReports report;
	public static ExtentTest test;
//	public static WebDriver sDriver=null;
//	ITestResult result;

	@Override
	public void onStart(ISuite suite) {
		String date = LocalDateTime.now().toString().replace(":", "-");
//		String TestName = result.getMethod().getMethodName();
		ExtentSparkReporter spark = new ExtentSparkReporter("./advanceReports/ finalReport " + date + ".html");
		spark.config().setDocumentTitle("crm application");
		spark.config().setReportName("Crm report");
		spark.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("browser", "chrome100");
		ISuiteListener.super.onStart(suite);
	}

	@Override
	public void onFinish(ISuite suite) {
		report.flush();

		ISuiteListener.super.onFinish(suite);
	}

	@Override
	public void onTestStart(ITestResult result) {
		test = report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		UtilityClassObject.getTest().log(Status.INFO, result.getMethod().getMethodName() + "===>STARTED<===");

		ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		UtilityClassObject.getTest().log(Status.INFO, result.getMethod().getMethodName() + "===>SUCESSED<===");
		ITestListener.super.onTestSuccess(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String TestName = result.getMethod().getMethodName();
		String date = LocalDateTime.now().toString().replace(":", "-");
		Javautility jutil = new Javautility();
		TakesScreenshot ts = (TakesScreenshot) BaseClass.sDriver;
		String temp = ts.getScreenshotAs(OutputType.BASE64);
		File dest = new File("./screenshot/" + date + "image.png");
		
		test.addScreenCaptureFromBase64String(temp, TestName + "_" + date);

		ITestListener.super.onTestFailure(result); 
	//	test.addScreenCaptureFromBase64String(temp, TestName + "_" + date);
	}

}
