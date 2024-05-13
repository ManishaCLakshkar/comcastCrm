package practiceTest;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReportTest {
	
	
	ExtentReports report;
	@BeforeSuite
	public void configBS() {
		//Spark report config
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
	
	@AfterSuite
	public void configAS() {
		report.flush();
	}
	
		@Test
		public void createContactTest() throws InterruptedException {
			
			WebDriver driver = new EdgeDriver();
			driver.get("https://www.amazon.in");
			
			TakesScreenshot ts = (TakesScreenshot)driver;
			String Filepath=ts.getScreenshotAs(OutputType.BASE64);
			ExtentTest test=report.createTest("createContactTest");
			test.log(Status.INFO, "Login to app");
			test.log(Status.INFO, "navigate to contact page");
			test.log(Status.INFO, "create contact");
			if("HDFC".equals("HFC"))
			{
				test.log(Status.PASS, " contact is created ");
			}
			else
			{
				test.addScreenCaptureFromBase64String(Filepath, "error file");
				}
			Thread.sleep(2000);
		
		
		}
		
		@Test
		public void createContactWithOrgPhoneNumber() {
			
			ExtentTest test=report.createTest("createContactTest");
			
			test.log(Status.INFO, "Login to app");
			test.log(Status.INFO, "navigate to contact page");
			test.log(Status.INFO, "create contact");
			if("HDFC".equals("HDFC"))
			{
				test.log(Status.PASS, " contact is created ");
			}
			else
			{
				test.log(Status.FAIL, " contact is not  created ");
			}
		}
		@Test
		public void createContactWithOrg() {
			
			ExtentTest test=report.createTest("createContactTest");
			
			test.log(Status.INFO, "Login to app");
			test.log(Status.INFO, "navigate to contact page");
			test.log(Status.INFO, "create contact");
			if("HDFC".equals("HDFC"))
			{
				test.log(Status.PASS, " contact is created ");
			}
			else
			{
				test.log(Status.FAIL, " contact is not  created ");
			}
		}}		


	


