package com.inventory.sales.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransactionInfoPage {
	
	@FindBy(xpath="//input[@type='search']") private WebElement search;
	
	public TransactionInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getSearch() {
		return search;
	}
	
	public void enterTransactionNameAndClickOnSearch(String cust_name)
	{
		search.sendKeys(cust_name);;
	}
}
