package com.inventory.sales.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLogout {

	@FindBy(id="userDropdown") private WebElement userDropDown;
	@FindBy(xpath="(//a[@data-toggle='modal'])[2]") private WebElement logoutBtn;
	@FindBy(xpath="(//a[text()='Logout'])[1]") private WebElement confirmLogoutBtn;
	
	public UserLogout(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getUserDropDown() {
		return userDropDown;
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}

	public WebElement getConfirmLogoutBtn() {
		return confirmLogoutBtn;
	}
	
	public void userLogoutFromApp() throws InterruptedException
	{
		userDropDown.click();
		logoutBtn.click();
		Thread.sleep(2000);
		confirmLogoutBtn.click();
	}
}
