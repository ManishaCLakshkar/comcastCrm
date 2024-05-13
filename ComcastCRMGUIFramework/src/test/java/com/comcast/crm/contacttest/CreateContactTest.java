package com.comcast.crm.contacttest;

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
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.BaseTest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.objectRepoditojutility.ContactInfoPage;
import com.comcast.crm.objectRepoditojutility.ContactsPage;
import com.comcast.crm.objectRepoditojutility.CreateNewContactPage;
import com.comcast.crm.objectRepoditojutility.CreateNewOrganisationPage;
import com.comcast.crm.objectRepoditojutility.HomePage;
import com.comcast.crm.objectRepoditojutility.LoginPage;
import com.comcast.crm.objectRepoditojutility.OrganisationInfoPage;
import com.comcast.crm.objectRepoditojutility.OrganisationPage;
import com.comcast.crm.objectRepoditojutility.OrganizationPopUp;

public class CreateContactTest extends BaseClass {

	@Test(groups="smokeTest")
	public void createContactTest() throws Throwable {

		// Step 1: read data from excel
		String contactLastName = eLib.getDataFromExcel("contact", 1, 2)+jLib.getRandomNumber();

		// step 2: navigate to the contacts module
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();

		//step 3:click on create Contact Button
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateContactLookUpBtn().click();

		// step 4: enter all the detAails and create Contact.
		CreateNewContactPage cnp= new CreateNewContactPage(driver);
		cnp.getLastname().sendKeys(contactLastName);
		cnp.getSaveBtn().click();

		// verify header lastname  expected result
		ContactsPage cp1= new ContactsPage(driver);
		String actHeader=cp1.getHeaderMsg().getText();
		boolean status =actHeader.contains(contactLastName);
		Assert.assertEquals(status, true);

		CreateNewContactPage cnp1 =new CreateNewContactPage(driver);
		String actlastName =cnp1.getLastname().getText();
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actlastName, contactLastName);
	}
	

	@Test
	public void createContactWithOrgTest() throws Throwable {

		//read testscriptdata from excel
		String orgName = eLib.getDataFromExcel("contact", 7, 3) + jLib.getRandomNumber();
		String contactlastName = eLib.getDataFromExcel("contact", 7, 3);
		// Step 2: navigate to organization Button
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		//step 3: click on "create Organisation Button"
		OrganisationPage op = new OrganisationPage(driver);
		op.getCreateOrgBtn().click();

		//step 4: enter all the details and create new orgnisation
		CreateNewOrganisationPage cnop = new CreateNewOrganisationPage(driver);
		cnop.createOrg(orgName);

		//verify header msg expected result
		OrganisationInfoPage oip= new OrganisationInfoPage(driver);
		String actOrgName= oip.getHeaderOrgName().getText();
         Assert.assertEquals(actOrgName, orgName);
		
		//Step 5: navigate to contact module  
		hp.getContactLink().click();

		//Step 6: Click on create Contact button
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateContactLookUpBtn().click();

		//step 7: enter all the details and create new Contact.
		CreateNewContactPage cncp= new CreateNewContactPage(driver);
		cncp.getLastname().sendKeys(contactlastName);
		cncp.getSaveBtn().click();

		//switch to child window
		wLib.switchToTabOnURL(driver, "module=Accounts");
		OrganizationPopUp opop= new OrganizationPopUp(driver);
		opop.getSeachTxtEdt().sendKeys(orgName);
		opop.getSeachTxtEdt().click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click(); // thiz is dynamic xpath

		//switch to parent window
		wLib.switchToTabOnURL(driver, "Contacts&action");
		CreateNewContactPage c= new CreateNewContactPage(driver);
		c.getSaveBtn().click();

		//verify the header msg into expected result
		ContactInfoPage cip= new ContactInfoPage(driver);
		String actLastName = cip.getHeaderLastName().getText();

		if (actLastName.contains(contactlastName)) {
			System.out.println(contactlastName + "is created=== PASS");
		} else {
			System.out.println(contactlastName + "is not created=== fail");
		}

		//verify the header orgName into expected result
		ContactInfoPage cip1= new ContactInfoPage(driver);
		String actOrgName1 = cip1.getHeaderOrgName().getText();
		SoftAssert s1= new SoftAssert();
		s1.assertEquals(actOrgName1, orgName);
		
	}



	//testCase 3:

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
		String actHeader =cip.getStartHeaderMsg().getText();
		boolean status=actHeader.contains(startDate);
		Assert.assertEquals(status, true);


		//verify actual endDate 
		ContactInfoPage cip1 = new ContactInfoPage(driver);
		String actHeader1=cip1.getEndHeaderMsg().getText();
		SoftAssert s1= new SoftAssert();
		s1.assertTrue(status);
		s1.assertAll();

	}
}
