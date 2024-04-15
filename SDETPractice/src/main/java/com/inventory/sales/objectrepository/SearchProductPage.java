package com.inventory.sales.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchProductPage {

	@FindBy(xpath="//input[@type='search']") private WebElement search;
	
	public SearchProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getSearch() {
		return search;
	}
	
	public void enterProductNameAndsearch(String name)
	{
		search.sendKeys(name);
		search.click();
	}
}
