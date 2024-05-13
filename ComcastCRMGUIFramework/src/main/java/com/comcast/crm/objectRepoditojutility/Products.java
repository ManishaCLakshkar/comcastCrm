package com.comcast.crm.objectRepoditojutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Products {
	@FindBy(xpath="//img[@alt='Create Product...']")
	private WebDriver createProdutImgBtn;
	
	@FindBy(name="search")
	private WebDriver ele2;

	@FindBy(xpath="//input[@name='search_text']")
	private WebDriver ele3;

}
