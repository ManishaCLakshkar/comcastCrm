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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.comcast.crm.BaseTest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.objectRepoditojutility.CreateNewOrganisationPage;
import com.comcast.crm.objectRepoditojutility.HomePage;
import com.comcast.crm.objectRepoditojutility.LoginPage;
import com.comcast.crm.objectRepoditojutility.OrganisationPage;

public class CreateOrganisationWithPhoneNumber extends BaseClass {
 public static void main(String[] args) throws Throwable {

	 WebDriver driver=null;
	//generate Random number
	Random r = new Random();
	int randomint=	r.nextInt(1000);

//read testscriptdata from excel
FileInputStream fis1 = new FileInputStream("./testdata/testscript1.xlsx");
Workbook wb=	WorkbookFactory.create(fis1);
Sheet sh =wb.getSheet("org");
Row row =sh.getRow(0);
String orgName =row.getCell(2).toString() + randomint;
wb.close();

 




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



//Verify Header msg Expected Result
 String headerInfo= driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
  if(headerInfo.contains(orgName)) {
	  System.out.println(orgName+ "is created=== PASS");
  }
  else {
	  System.out.println(orgName+ "is not created=== PASS");
  }

//Verify orgName info Expected Result
  String actOrgName=driver.findElement(By.id("dtview_Organisation")).getText();
  if(actOrgName.contains(orgName)) {
	  System.out.println(orgName+ "is created=== PASS");
  }
  else {
	  System.out.println(orgName+ "is not created=== PASS");
  }


driver.quit();

}
}
