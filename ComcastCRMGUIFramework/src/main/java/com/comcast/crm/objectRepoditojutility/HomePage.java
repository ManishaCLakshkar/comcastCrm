package com.comcast.crm.objectRepoditojutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	public HomePage(WebDriver driver) 
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(linkText= "Organizations")
	private WebElement orgLink;
	
	@FindBy(linkText="Contacts")
	private WebElement contactLink;

	@FindBy(linkText="Campaigns")
	private WebElement campaignLink;
	
	@FindBy(linkText="More")
	private WebElement moreLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutLink;

	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}
	
	
	
	public WebElement getSignOutLink() {
		return signOutLink;
	}

	public void navigateToCampaignPage() 
	{
		Actions act = new Actions(driver);
		act.moveToElement(moreLink).perform();
		campaignLink.click();
		}
	public void logout() throws InterruptedException {
		Actions act= new Actions(driver);
		act.moveToElement(adminImg).build().perform();
		Thread.sleep(3000);
		getSignOutLink().click();
		
		}

	
	

}
