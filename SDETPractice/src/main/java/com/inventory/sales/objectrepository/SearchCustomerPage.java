package com.inventory.sales.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerPage {

	@FindBy(xpath="//input[@type='search']") private WebElement searchEdtTxt;
	
	public SearchCustomerPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getSearchEdtTxt() {
		return searchEdtTxt;
	}
	
	public void enterCustNameAndSearch(String fn)
	{
		searchEdtTxt.sendKeys(fn);
		searchEdtTxt.click();
	}
}
