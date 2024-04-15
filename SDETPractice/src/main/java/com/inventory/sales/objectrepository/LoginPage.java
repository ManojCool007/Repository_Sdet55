package com.inventory.sales.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(name="user") private WebElement usernameEdtTxt;
	@FindBy(name="password") private WebElement passwordEdtTxt;
	@FindBy(name="btnlogin") private WebElement loginBtnClick;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getUsernameEdtTxt() 
	{
		return usernameEdtTxt;
	}

	public WebElement getPasswordEdtTxt() 
	{
		return passwordEdtTxt;
	}

	public WebElement getLoginBtnClick() 
	{
		return loginBtnClick;
	}
	
	public void loginToApp(String username, String password)
	{
		usernameEdtTxt.sendKeys(username);
		passwordEdtTxt.sendKeys(password);
		loginBtnClick.click();
	}
	
}
