package com.comcast.crm.objectRepoditojutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactPage {
	WebDriver driver;
	public CreateNewContactPage(WebDriver driver) 
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="lastname")
	private WebElement lastname;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(name="support_start_date")
	private WebElement startDate;
	
	@FindBy(name="support_end_date")
	private WebElement endDate;
	
//	@FindBy (xpath = "//img[@name='account_name']/following-sibling::img")
//	private WebElement orgNameEdt;
//	
	public WebElement getStartDate() {
		return startDate;
	}
	public WebElement getEndDate() {
		return endDate;
	}
	
	public WebElement getLastname() {
		return lastname;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	
	public WebElement getOrgNameEdt() {
		return getOrgNameEdt();
	}
	public void createcontactWithLastName(String name)
	{
		lastname.sendKeys(name);
		saveBtn.click();
	}
	public void createcontactWithSupportDate(String name,String startdate,String enddate)
	{
		lastname.sendKeys(name);
		startDate.clear();
		startDate.sendKeys(startdate);
		endDate.clear();
		endDate.sendKeys(enddate);
		saveBtn.click();
	}
}
		
	

