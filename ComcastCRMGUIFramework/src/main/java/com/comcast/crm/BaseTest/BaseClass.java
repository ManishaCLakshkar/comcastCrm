package com.comcast.crm.BaseTest;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.databaseutility.DatabaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectRepoditojutility.HomePage;
import com.comcast.crm.objectRepoditojutility.LoginPage;

public class BaseClass {
	
	/*Create Object*/
	  
	public ExcelUtility eLib= new ExcelUtility();
    public JavaUtility jLib= new JavaUtility();
    public DatabaseUtility dLib = new DatabaseUtility();
    public FileUtility fLib=new FileUtility();
    public WebDriverUtility wLib= new WebDriverUtility();
	public WebDriver driver = null;
	public static WebDriver sdriver= null;
	public ExtentSparkReporter spark;
	public ExtentReports report;
	
	
	
	
	@BeforeSuite
	public void configBS() throws SQLException  {
		System.out.println("====connect to db=====,Report Config====");
		dLib.getDbConnection();
		
		
		
		
			
			
		
	}
	
	
	@BeforeClass
	public void configBc() throws Throwable {
		System.out.println("Launch Browser");
		String browser=fLib.getDataFromPropertiesFile("browser");
		if(browser.equals("chrome"))
		{
		driver= new ChromeDriver();	
		}
		else if(browser.equals("firefox"))
		{
			driver= new FirefoxDriver();	
		}
		else if(browser.equals("edge")) {
			driver= new EdgeDriver();	 
		}
		sdriver= driver;
		UtilityClassObject.setDriver(driver);

	}

	@BeforeMethod
	public void configBM() throws Throwable {
		System.out.println("Login");
		String url=fLib.getDataFromPropertiesFile("url");
		System.out.println(url);
		String username=fLib.getDataFromPropertiesFile("username");
		String password=fLib.getDataFromPropertiesFile("password");
		LoginPage lp = new LoginPage(driver); 
         lp.loginToApp(url, username, password);
	}
	
	
	@AfterMethod
	public void configAM() throws InterruptedException {
		System.out.println("Logout");
		HomePage hp = new HomePage(driver);
		hp.logout();
	}
	@AfterClass
	public void configAC()  {
		System.out.println("Close Browser");
		driver.close();
		
	}
	
	@AfterSuite
	public void configAs() throws Throwable {
		System.out.println("=====close connection ====Report Backup====");
		dLib.closeConnection();
		
	}
	
}
