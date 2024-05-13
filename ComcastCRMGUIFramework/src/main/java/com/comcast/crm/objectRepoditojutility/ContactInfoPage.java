package com.comcast.crm.objectRepoditojutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	
	WebDriver driver;
	public ContactInfoPage(WebDriver driver) 
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(id="dtlview_Support End Date")
	private WebElement endHeaderMsg;

	@FindBy(id="dtlview_Support Start Date")
	private WebElement startHeaderMsg;

	@FindBy(id="mouseArea_Last Name")
	private WebElement headerLastName;

	@FindBy(id="mouseArea_Organization Name")
	private WebElement headerOrgName;



public WebElement getEndHeaderMsg() {
	return endHeaderMsg;
}
public WebElement getStartHeaderMsg() {
	return startHeaderMsg;
}
public WebElement getHeaderLastName() {
	return headerLastName;
}
public WebElement getHeaderOrgName() {
	return headerOrgName;
}


}