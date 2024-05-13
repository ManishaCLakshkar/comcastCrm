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
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.BaseTest.BaseClass;
import com.comcast.crm.ListenerUtility.ListenerImplementation;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectRepoditojutility.CreateNewOrganisationPage;
import com.comcast.crm.objectRepoditojutility.HomePage;
import com.comcast.crm.objectRepoditojutility.LoginPage;
import com.comcast.crm.objectRepoditojutility.OrganisationInfoPage;
import com.comcast.crm.objectRepoditojutility.OrganisationPage;

@Listeners(com.comcast.crm.ListenerUtility.ListenerImplementation.class)
public class CreateOrganisationTest extends BaseClass {

	@Test(groups="smokeTest")
	public void createOrgTest() throws Throwable {
WebDriver driver = new ChromeDriver();

		// read data from excel
UtilityClassObject.getTest().log(Status.INFO,"read data from excel");
		String orgName = eLib.getDataFromExcel("contact", 7, 2) + jLib.getRandomNumber();
		String contactLastName = eLib.getDataFromExcel("contact", 7, 3);

//step 2: navigate to the organisation module
		UtilityClassObject.getTest().log(Status.INFO,"navigate to organisatio page");
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		hp.navigateToCampaignPage();

//step 3: click on "create Organisation Button"
		UtilityClassObject.getTest().log(Status.INFO,"navigate to org page");
		OrganisationPage op = new OrganisationPage(driver);
		op.getCreateOrgBtn().click();

//step 4: enter all the details and create new orgnisation
		UtilityClassObject.getTest().log(Status.INFO,"Create a new organisation");
		CreateNewOrganisationPage cnop= new CreateNewOrganisationPage(driver);
		cnop.getOrgNameEdt().sendKeys(orgName);
		cnop.getSaveBtn().click();

//Verify Header msg Expected Result
		
		OrganisationInfoPage oip = new OrganisationInfoPage(driver);
		String actOrgName = oip.getHeaderMsg().getText();
		if (actOrgName.contains(orgName)) {
			System.out.println(orgName + "name is verified=== PASS");
		} else {
			System.out.println(orgName + "is not verified=== fail");
		}

//go back to organisation
		hp.getOrgLink().click();
	}
}
