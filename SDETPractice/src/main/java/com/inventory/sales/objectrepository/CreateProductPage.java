package com.inventory.sales.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {

	@FindBy(name="prodcode") private WebElement productCode;
	@FindBy(name="name") private WebElement productName;
	@FindBy(xpath="//textarea[@name='description']") private WebElement description;
	@FindBy(name="quantity") private WebElement product_quantity;
	@FindBy(name="onhand") private WebElement onHand;
	@FindBy(name="price") private WebElement product_Price;
	@FindBy(xpath="//input[@name='datestock']") private WebElement dateStock;
	@FindBy(xpath="(//button[@type='submit'])[5]") private WebElement save;
	@FindBy(xpath="//option[text()='Select Category']/..") private WebElement select_Category;
	@FindBy(xpath="//option[text()='Select Supplier']/..") private WebElement select_Supplier;
	
	public CreateProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getProductCode() 
	{
		return productCode;
	}

	public WebElement getProductName() 
	{
		return productName;
	}

	public WebElement getDescription() 
	{
		return description;
	}

	public WebElement getQuantity() 
	{
		return product_quantity;
	}

	public WebElement getOnHand() 
	{
		return onHand;
	}

	public WebElement getPrice() 
	{
		return product_Price;
	}
	
	public WebElement getDateStock() 
	{
		return dateStock;
	}

	public WebElement getSave() 
	{
		return save;
	}
	
	public WebElement getSelect_Category() 
	{
		return select_Category;
	}
	
	public WebElement getSelect_Supplier() 
	{
		return select_Supplier;
	}

	public void enterAllProductDetailsAndSave(String P_Code, String name, String desc, String quantity, String onhand, String price, String datestock)
	{
		productCode.sendKeys(P_Code);
		productName.sendKeys(name);
		description.sendKeys(desc);
		product_quantity.sendKeys(quantity);
		onHand.sendKeys(onhand);
		product_Price.sendKeys(price);
		dateStock.click();
		dateStock.sendKeys(datestock);
		save.click();
	}
	
}
