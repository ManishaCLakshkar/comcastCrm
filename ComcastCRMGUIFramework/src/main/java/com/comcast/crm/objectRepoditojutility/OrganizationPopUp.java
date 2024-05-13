package com.comcast.crm.objectRepoditojutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class OrganizationPopUp extends WebDriverUtility {
	WebDriver driver;
	public OrganizationPopUp(WebDriver driver) 
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="search_text")
	private WebElement searchTxtEdt;
	
	@FindBy(name="search_field")
	private WebElement searchFieldEdt;
	
	@FindBy(name="search")
	private WebElement searchBtn;
	
	@FindBy (name = "search_field")
	private WebElement searchDDEle;
	
	
	public WebElement getSeachTxtEdt() {
		return searchTxtEdt;
	}

	public WebElement getSearchFieldEdt() {
		return searchFieldEdt;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public void getSearchDD(WebDriver driver, String orgName) {
		
		select(searchDDEle, "Organization Name");
		getSearchBtn().click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click(); // thiz is dynamic xpath

	}
	
	
}
