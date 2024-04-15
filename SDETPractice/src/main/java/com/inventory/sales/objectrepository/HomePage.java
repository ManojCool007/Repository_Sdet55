package com.inventory.sales.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy(xpath="//span[text()='Customer']") private WebElement customerLink;
	@FindBy(xpath="//span[text()='Employee']") private WebElement employeeLink;
	@FindBy(xpath="//span[text()='Product']") private WebElement productLink;
	@FindBy(xpath="//span[text()='Supplier']") private WebElement supplierLink;
	@FindBy(xpath="//span[text()='Inventory']") private WebElement inventoryLink;
	@FindBy(xpath="//span[text()='Transaction']") private WebElement transactionLink;
	@FindBy(xpath="//span[text()='Accounts']") private WebElement accountsLink;
	@FindBy(id="userDropdown") private WebElement AdminDropdown;

	@FindBy(xpath = "(//a[@data-toggle='modal'])[1]") private WebElement AdminLogout;
	
	public WebElement getAdminLogout() {
		return AdminLogout;
	}

	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCustomerLink() 
	{
		return customerLink;
	}

	public WebElement getEmployeeLink() 
	{
		return employeeLink;
	}

	public WebElement getTransactionLink() 
	{
		return transactionLink;
	}

	public WebElement getProductLink() 
	{
		return productLink;
	}

	public WebElement getSupplierLink() 
	{
		return supplierLink;
	}
	
	public WebElement getInventoryLink() 
	{
		return inventoryLink;
	}
	
	public WebElement getAccountsLink() 
	{
		return accountsLink;
	}
	
	public WebElement getAdminDropdown() {
		return AdminDropdown;
	}

	public void clickOnCustomerLink() throws InterruptedException
	{
		Thread.sleep(5000);
		customerLink.click();
	}
	
	public void clickOnEmployeeLink()
	{
		employeeLink.click();
	}
	
	public void clickOnSupplierLink()
	{
		
		supplierLink.click();
	}
	
	public void clickOnProductLink()
	{
		productLink.click();
	}
	
	public void clickOnInventoryLink()
	{
		inventoryLink.click();
	}
	
	public void clickOnTransactionLink()
	{
		transactionLink.click();
	}
	
	public void clickOnAccountsLink()
	{
		accountsLink.click();
	}
	
	public void clickOnAdminLogout() throws InterruptedException
	{
		Thread.sleep(2000);
		AdminDropdown.click();
		AdminLogout.click();
	}
}
