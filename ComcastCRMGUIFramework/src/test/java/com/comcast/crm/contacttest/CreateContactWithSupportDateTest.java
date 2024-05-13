package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.comcast.crm.BaseTest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectRepoditojutility.ContactInfoPage;
import com.comcast.crm.objectRepoditojutility.ContactsPage;
import com.comcast.crm.objectRepoditojutility.CreateNewContactPage;
import com.comcast.crm.objectRepoditojutility.CreateNewOrganisationPage;
import com.comcast.crm.objectRepoditojutility.HomePage;

public class CreateContactWithSupportDateTest extends BaseClass {
	//private String orgName;

	@Test 
	public void  createContactWithSupportDateTest() throws Throwable
	{
		//Step 1: Read data from excel file
		String lastname = eLib.getDataFromExcel("contact", 4, 2)+jLib.getRandomNumber();
	
	//step 2: navigate to the contacts module
	HomePage hp = new HomePage(driver);
	hp.getContactLink().click();
	
	//step 3: click on "create contact Button"
	ContactsPage cp = new ContactsPage(driver);
	cp.getCreateContactLookUpBtn().click();
	 
	//step 4: enter all the details and create new Contact.
	String startDate=jLib.getSystemDateYYYYDDMM();
	String endDate=jLib.getRequiredDateYYYYDDMM(30);
	
    CreateNewContactPage cncp=new CreateNewContactPage(driver);
    cncp.createcontactWithSupportDate(lastname, startDate, endDate);

	//verify startdate and end date 
    ContactInfoPage cip = new ContactInfoPage(driver);
    
	 String  actStartDate=cip.getStartHeaderMsg().getText();
	 if(actStartDate.contains(startDate)) {
		  System.out.println(startDate+ "information is verified=== PASS");
	  }
	  else {
		  System.out.println(startDate+ "information is not verified=== PASS");
	  }
  
          //verify actual endDate 
	  String  actendDate=cip.getEndHeaderMsg().getText();
	  if(actendDate.contains(endDate))
	  {
		  System.out.println(endDate+ "is created=== PASS");
	  }
	  else {
		  System.out.println(endDate+ "is not created=== PASS");
	  }
	}
}
