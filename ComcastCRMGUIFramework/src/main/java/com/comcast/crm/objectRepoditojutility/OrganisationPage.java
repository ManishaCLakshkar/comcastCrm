package com.comcast.crm.objectRepoditojutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationPage {
	
	WebDriver driver;
	public OrganisationPage(WebDriver driver) 
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
			private WebElement createOrgBtn;
	
	@FindBy(name="search_text")
	private WebElement searchTxtEdt;
	
	@FindBy(name="search_field")
	private WebElement searchFieldEdt;
	
	@FindBy(name="search")
	private WebElement searchEdt;
	
	
	public WebElement getSeachTxtEdt() {
		return searchTxtEdt;
	}

	public WebElement getSearchFieldEdt() {
		return searchFieldEdt;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	
	public WebElement getCreateOrgBtn() {
		return createOrgBtn;
	}

}