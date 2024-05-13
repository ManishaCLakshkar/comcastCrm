package com.comcast.crm.objectRepoditojutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationInfoPage {

	WebDriver driver;
	public OrganisationInfoPage(WebDriver driver) 
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="mouseArea_Organization Name")
	private WebElement headerOrgName;

	@FindBy(id="mouseArea_Industry")
	private WebElement headerIndustry;

	@FindBy(id="mouseArea_Type")
	private WebElement headerType;

	@FindBy(id="mouseArea_Phone")
	private WebElement headerPhone;
	
	public WebElement getHeaderOrgName() {
		return headerOrgName;
	}

	public WebElement getHeaderIndustry() {
		return headerIndustry;
	}

	public WebElement getHeaderType() {
		return headerType;
	}

	public WebElement getHeaderPhone() {
		return headerPhone;
	}

	public WebElement getHeaderMsg() {
		// TODO Auto-generated method stub
		return null;
	}

	}
