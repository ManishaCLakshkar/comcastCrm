package com.comcast.crm.ListenerUtility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.internal.BaseClassFinder;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.BaseTest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
 
public class ListenerImplementation implements ITestListener,ISuiteListener {
	public ExtentReports report;
	public static ExtentTest test;
	
	   //this onStart method is used to configure the report instead of base clas we used listener .
	//Listener will get executed automatically.
	
	@Override
		public void onStart(ISuite suite)
		{		
		 //Spark report confi
  		ExtentSparkReporter spark= new ExtentSparkReporter("./AdvanceReport/report.html");
  		spark.config().setDocumentTitle("CRM Test Suite results");
  		spark.config().setReportName("CRM Report");
  		spark.config().setTheme(Theme.DARK);
  		
  		//add environment information and create test
  		report= new ExtentReports();
  		report.attachReporter(spark);
  		report.setSystemInfo("OS", "windows-10");
  		report.setSystemInfo("browser", "chrome-100");
	
	}

	@Override
	public void onFinish(ISuite suite) {
		report.flush();//saves the file
		
		

	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("==="+result.getMethod().getMethodName()+"====START=====");
		test  = report.createTest(result.getMethod().getMethodName());
		 UtilityClassObject.setTest(test);
		 test.log(Status.INFO, result.getMethod().getMethodName()+"====STARTED=====");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("==="+result.getMethod().getMethodName()+"====end=====");
		test.log(Status.PASS, result.getMethod().getMethodName()+"====COMPLETED=====");
	}

	@Override
	public void onTestFailure(ITestResult result)  {
		
		String testName =result.getMethod().getMethodName();
		TakesScreenshot ts = (TakesScreenshot)BaseClass.sdriver;
		String Filepath=ts.getScreenshotAs(OutputType.BASE64);
		 
		String time= new Date().toString().replace(" ", "_").replace(":", "_");
		test.addScreenCaptureFromBase64String(Filepath, testName+"_"+time);
		//concatenated time to get multiple screenshots.
		test.log(Status.FAIL, result.getMethod().getMethodName()+"====FAILED=====");
	}

	private String time(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		//
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	

}
