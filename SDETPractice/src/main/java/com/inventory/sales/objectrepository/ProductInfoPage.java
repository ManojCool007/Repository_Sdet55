package com.inventory.sales.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfoPage {

	@FindBy(xpath="//h4[contains(text(),'Product')]/a") private WebElement ProductLookImg;
	@FindBy(xpath="//a[contains(text(),'...')]") private WebElement option;
	@FindBy(xpath="//a[@class='btn btn-warning bg-gradient-warning btn-block']") private WebElement editBtn;
	
	public ProductInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getProductLookImg() {
		return ProductLookImg;
	}
	
	public WebElement getOption() 
	{
		return option;
	}
	
	public WebElement getEditBtn() 
	{
		return editBtn;
	}

	public void clickOnProductLookUpImg()
	{
		ProductLookImg.click();
	}
	
	public void clickOnOption() 
	{
		option.click();
	}
	
	public void clickOnEditBtn()
	{
		editBtn.click();
	}
}
