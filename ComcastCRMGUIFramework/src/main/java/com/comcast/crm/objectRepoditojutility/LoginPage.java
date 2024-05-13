package com.comcast.crm.objectRepoditojutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;


//extending to webdriver to access waitForPageLoad.
/**
 * @author lenovo
 * Contains Login page elements and business lib like login() 
 */
public class LoginPage extends WebDriverUtility 
{
	//Rule 1: create a seperate java Class
	//Rule 2: Object Creation

	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(name="user_name")
	private WebElement usernameEdt;

	@FindBy(name="user_password")
	private WebElement passwordEdt;

	@FindBy(id="submitBUtton")
	private WebElement  loginBtn;

	//Rule 4:Object Encapsulation

	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	//Rule 5: Provide action(business method)
/**
 * login to application based on url,username , password
 * @param url
 * @param username
 * @param password
 */
	public void loginToApp(String url, String username,String password)
	{
		driver.get(url);
		driver.manage().window().maximize();
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}

}
