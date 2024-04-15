package com.inventory.sales.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchEmployeePage {

	@FindBy(xpath="//input[@type='search']") private WebElement search;
	@FindBy(xpath="//th[.='First Name']/ancestor::table/descendant::td[@class='sorting_1']") private WebElement name;
	
	public WebElement getName() {
		return name;
	}

	public SearchEmployeePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getSearch() {
		return search;
	}
	
	public void enterEmployeeAndClickOnSearch(String value)
	{
		search.sendKeys(value);
	}
}
