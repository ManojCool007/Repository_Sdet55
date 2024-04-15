package com.inventory.sales.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateSupplierPage {

	@FindBy(name="companyname") private WebElement company_name;
	@FindBy(xpath="//option[text()='Select Province']/..") private WebElement select_Province;
	@FindBy(xpath="//option[text()='Select City / Municipality']/..") private WebElement select_City;
	@FindBy(name="phonenumber") private WebElement Pnone_Number;
	@FindBy(xpath="//button[text()='Save']") private WebElement save;
	
	public CreateSupplierPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCompany_name() {
		return company_name;
	}

	public WebElement getSelect_Province() {
		return select_Province;
	}

	public WebElement getSelect_City() {
		return select_City;
	}

	public WebElement getPnone_Number() {
		return Pnone_Number;
	}

	public WebElement getSave() {
		return save;
	}
	
	public void enterAllDetailsAndSave(String Comp_value, String province, String city,String number)
	{
		company_name.sendKeys(Comp_value);
		select_Province.sendKeys(province);
		select_City.sendKeys(city);
		Pnone_Number.sendKeys(number);
		save.click();
	}
	
}
