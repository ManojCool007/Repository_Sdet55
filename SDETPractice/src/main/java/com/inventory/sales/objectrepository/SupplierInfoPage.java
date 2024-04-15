package com.inventory.sales.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SupplierInfoPage {

	@FindBy(xpath="//h4[contains(text(),'Supplier')]/a") private WebElement supplierLookUpImg;
	
	public SupplierInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getSupplierLookUpImg() 
	{
		return supplierLookUpImg;
	}
	
	public void clickOnSupplierLookUpImg()
	{
		supplierLookUpImg.click();
	}
}
