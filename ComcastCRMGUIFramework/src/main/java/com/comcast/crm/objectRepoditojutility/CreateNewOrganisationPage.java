package com.comcast.crm.objectRepoditojutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewOrganisationPage {
	WebDriver driver;
	public CreateNewOrganisationPage(WebDriver driver) 
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name="accountname")
	private WebElement orgNameEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(name="industry")
	private WebElement industryDB;
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}
	
	

	
	public void  createOrg(String orgName) {
		orgNameEdt.sendKeys(orgName);
		saveBtn.click();
	}
	public void createOrg(String orgName , String industry) {
		orgNameEdt.sendKeys(orgName);
		Select sel = new Select(industryDB);
		sel.selectByVisibleText(industry);
		saveBtn.click();
	}
	

}
