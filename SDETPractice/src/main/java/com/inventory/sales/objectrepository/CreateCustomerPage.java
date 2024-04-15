package com.inventory.sales.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCustomerPage {

	@FindBy(name="firstname") private WebElement fnEdtTxt;
	@FindBy(name="lastname") private WebElement lnEdtTxt;
	@FindBy(name="phonenumber") private WebElement pnoEdtTxt;
	@FindBy(xpath="(//button[@type='submit'])[1]") private WebElement submitBtn;
	
	public CreateCustomerPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getFnEdtTxt() {
		return fnEdtTxt;
	}

	public WebElement getLnEdtTxt() {
		return lnEdtTxt;
	}

	public WebElement getPnoEdtTxt() {
		return pnoEdtTxt;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	public void enterCustomerDetailsAndSave(String fn, String ln, String pno)
	{
		fnEdtTxt.sendKeys(fn);
		lnEdtTxt.sendKeys(ln);
		pnoEdtTxt.sendKeys(pno);
		submitBtn.click();
	}
	
}
