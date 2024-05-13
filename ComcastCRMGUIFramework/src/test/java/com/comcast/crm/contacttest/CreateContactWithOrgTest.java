package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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
import com.comcast.crm.objectRepoditojutility.ContactsPage;
import com.comcast.crm.objectRepoditojutility.CreateNewContactPage;
import com.comcast.crm.objectRepoditojutility.CreateNewOrganisationPage;
import com.comcast.crm.objectRepoditojutility.HomePage;
import com.comcast.crm.objectRepoditojutility.OrganisationPage;
import com.comcast.crm.objectRepoditojutility.OrganizationPopUp;

public class CreateContactWithOrgTest extends BaseClass {

	@Test
	public void createContactWithOrgTest() throws Throwable {
//read testscriptdata from excel
		String orgName = eLib.getDataFromExcel("contact", 7, 2) + jLib.getRandomNumber();
		String contactlastName = eLib.getDataFromExcel("contact", 7, 3);

		// Step 2: navigate to organization Button
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
//		hp.navigateToCampaignPage();
		
//step 3: click on "create Organisation Button"
		OrganisationPage op = new OrganisationPage(driver);
		op.getCreateOrgBtn().click();
		
//step 4: enter all the details and create new orgnisation
		CreateNewOrganisationPage cnop = new CreateNewOrganisationPage(driver);
		cnop.createOrg(orgName);
		
////verify header msg expected result
//		String HeaderInfo = driver.findElement(By.className("dvHeaderText")).getText();
//		if (HeaderInfo.contains(orgName)) {
//			System.out.println(orgName + "is created=== PASS");
//		} else {
//			System.out.println(orgName + "is not created=== fail");
//		}

// Step 5: navigate to contact module  
		HomePage hp1 = new HomePage(driver);
		Thread.sleep(2000);
		hp1.getContactLink().click();

//Step 6: Click on create Contact button
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateContactLookUpBtn().click();
		
//step 7: enter all the details and create new Contact.
		CreateNewContactPage cncp= new CreateNewContactPage(driver);
		cncp.getLastname().sendKeys(contactlastName);
		cncp.getOrgNameEdt().click();
		
//switch to child window
		wLib.switchToTabOnURL(driver, "module=Accounts");
		OrganizationPopUp opop=new OrganizationPopUp(driver);
		opop.getSeachTxtEdt().sendKeys(orgName);
		opop.getSearchDD(driver, orgName);
		
//switch to parent window
		wLib.switchToTabOnURL(driver, "Contacts&action");
		driver.findElement(By.xpath("//input[@title = 'Save [Alt+S']")).click();

////verify the header msg into expected result
//
//		HeaderInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
//		if (HeaderInfo.contains(orgName)) {
//			System.out.println(orgName + "is created=== PASS");
//		} else {
//			System.out.println(orgName + "is not created=== fail");
//		}
//
////verify the header orgName into expected result
//		String actOrgName = driver.findElement(By.id("mouseArea_Organisation Name")).getText();
//		if (actOrgName.contains(orgName)) {
//			System.out.println(orgName + "is created=== PASS");
//		} else {
//			System.out.println(orgName + "is not created=== fail");
//		}

	}
}
