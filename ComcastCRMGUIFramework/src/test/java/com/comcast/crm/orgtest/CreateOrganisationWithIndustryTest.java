package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.comcast.crm.BaseTest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.objectRepoditojutility.CreateNewOrganisationPage;
import com.comcast.crm.objectRepoditojutility.HomePage;
import com.comcast.crm.objectRepoditojutility.LoginPage;
import com.comcast.crm.objectRepoditojutility.OrganisationPage;

public class CreateOrganisationWithIndustryTest extends BaseClass {
 @Test
 public void createOrganisationWithIndustryTest() throws Throwable {
	 
String orgName = eLib.getDataFromExcel("instagram", 2, 2)+ jLib.getRandomNumber();
String phoneNumber =eLib.getDataFromExcel("facebook", 0, 0).toString() ;

//step 2: navigate to the organisation module
HomePage hp = new HomePage(driver);
hp.getOrgLink().click();
hp.navigateToCampaignPage();


//step 3: click on "create Organisation Button"
OrganisationPage op = new OrganisationPage(driver);
op.getCreateOrgBtn().click();

//step 4: enter all the details and create new orgnisation
CreateNewOrganisationPage cnop= new CreateNewOrganisationPage(driver);
cnop.getOrgNameEdt().sendKeys(orgName);
cnop.getSaveBtn().click();
Thread.sleep(5000);


Actions act = new Actions(driver);
act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();Thread.sleep(2000);
driver.findElement(By.xpath("//a[text()='Sign Out']")).click();Thread.sleep(2000);
  

     //Verify the header phone Number
String actPhoneNumber=driver.findElement(By.id("dtlview_Phone")).getText();
  if(actPhoneNumber.contains(phoneNumber)) {
	  System.out.println(phoneNumber+ "information is created=== PASS");
  }
  else {
	  System.out.println(phoneNumber+ "information is not created=== Fail");
  }
  
  

}
}

