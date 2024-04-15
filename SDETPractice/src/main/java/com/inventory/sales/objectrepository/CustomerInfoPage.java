package com.inventory.sales.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerInfoPage {

	@FindBy(xpath="//h4[contains(text(),'Customer')]/a") private WebElement customerLookUpImg;
	
	public CustomerInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCustomerLookUpImg() {
		return customerLookUpImg;
	}
	
	public void custLookupImg()
	{
		customerLookUpImg.click();
	}
}
