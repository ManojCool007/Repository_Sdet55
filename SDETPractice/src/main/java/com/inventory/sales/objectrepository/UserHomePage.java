package com.inventory.sales.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.WebdriverUtility;

public class UserHomePage {
	
	@FindBy(linkText = "Others") private WebElement OthersBtn;
	@FindBy(xpath="//h6[text()='octane']/following-sibling::input[@name='quantity']") private WebElement quantityEdtTxt;
	@FindBy(xpath="//h6[text()='octane']/following-sibling::input[@name='addpos']") private WebElement addBtn;
	@FindBy(xpath="//option[text()='Select Customer']/..") private WebElement selectCustomer;
	@FindBy(xpath = "//button[text()='SUBMIT']") private WebElement submit;
	@FindBy(xpath="//h5[text()='SUMMARY']/../following-sibling::div/div/div/h3[contains(text(),'GRAND TOTAL')]/following-sibling::h3") private WebElement grandTotal;
	@FindBy(id="txtNumber") private WebElement textTotal;
	@FindBy(xpath="//button[text()='PROCEED TO PAYMENT']") private WebElement proceedToPaymentBtn;
	
	
	public UserHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOthersBtn() 
	{
		return OthersBtn;
	}

	public WebElement getQuantityEdtTxt()
	{
		return quantityEdtTxt;
	}

	public WebElement getAddBtn() 
	{
		return addBtn;
	}
	
	public WebElement getTextTotal() 
	{
		return textTotal;
	}

	public WebElement getSelectCustomer() 
	{
		return selectCustomer;
	}

	public WebElement getSubmit() 
	{
		return submit;
	}

	public WebElement getGrandTotal() 
	{
		return grandTotal;
	}

	public WebElement getProceedToPaymentBtn()
	{
		return proceedToPaymentBtn;
	}
	
	public void addProductAndPerformTransaction(String quantity, String cust_name,WebdriverUtility gweb) throws InterruptedException
	{
		OthersBtn.click();
		quantityEdtTxt.clear();
		quantityEdtTxt.sendKeys(quantity);
		addBtn.click();
		WebElement cust = getSelectCustomer();
		gweb.dropDown(cust, cust_name);
		submit.click();
		Thread.sleep(2000);
		String final_total=grandTotal.getText();
		System.out.println(final_total);
		textTotal.sendKeys(final_total);
		proceedToPaymentBtn.click();
	}
}
