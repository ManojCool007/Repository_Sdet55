package TestNG;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.inventory.sales.objectrepository.CreateCustomerPage;
import com.inventory.sales.objectrepository.CreateProductPage;
import com.inventory.sales.objectrepository.CustomerInfoPage;
import com.inventory.sales.objectrepository.HomePage;
import com.inventory.sales.objectrepository.ProductInfoPage;
import com.inventory.sales.objectrepository.SearchCustomerPage;
import com.inventory.sales.objectrepository.SearchEmployeePage;
import com.inventory.sales.objectrepository.SearchProductPage;

public class AllScriptTest extends BaseClass{

	@Test(priority = 1)
	public void scriptTest() throws IOException, InterruptedException
	{
		HomePage homePage = new HomePage(driver);
		homePage.clickOnCustomerLink();
		
		CustomerInfoPage customerInfoPage = new CustomerInfoPage(driver);
		customerInfoPage.custLookupImg();
		
		String fn = exutil.readDataFromExcel("Sheet4", 0, 1);
		String ln = exutil.readDataFromExcel("Sheet4", 1, 1);
		String pno = exutil.readDataFromExcel("Sheet4", 2, 1);
		
		CreateCustomerPage createCustomerPage = new CreateCustomerPage(driver);
		createCustomerPage.enterCustomerDetailsAndSave(fn, ln, pno);
		Thread.sleep(2000);
		
		SearchCustomerPage searchCustomerPage = new SearchCustomerPage(driver);
		searchCustomerPage.enterCustNameAndSearch(fn);

	}
	
	@Test(priority = 3)
	public void scriptempTest() throws IOException, InterruptedException
	{
		HomePage homePage = new HomePage(driver);
		homePage.clickOnEmployeeLink();
		
		String value = exutil.readDataFromExcel("Sheet1", 1, 0);
		
		SearchEmployeePage searchEmployeePage = new SearchEmployeePage(driver);
		searchEmployeePage.enterEmployeeAndClickOnSearch(value);
		
	}
	
	@Test(priority = 2)
	public void scriptProductTest() throws IOException, InterruptedException
	{
		
		HomePage homePage = new HomePage(driver);
		homePage.clickOnProductLink();
		
		ProductInfoPage productInfoPage = new ProductInfoPage(driver);
		productInfoPage.clickOnProductLookUpImg();
	
		String P_Code = exutil.readDataFromExcel("Sheet3", 0, 1);
		String name = exutil.readDataFromExcel("Sheet3", 1, 1);
		String desc = exutil.readDataFromExcel("Sheet3", 2, 1);
		String quantity = exutil.readDataFromExcel("Sheet3", 3, 1);
		String onhand = exutil.readDataFromExcel("Sheet3", 4, 1);
		String price = exutil.readDataFromExcel("Sheet3", 5, 1);
		String sel_cat = exutil.readDataFromExcel("Sheet3", 6, 1);
		String sel_sup = exutil.readDataFromExcel("Sheet3", 7, 1);
		String datestock = exutil.readDataFromExcel("Sheet3", 8, 1);
		
		
		CreateProductPage createProductPage = new CreateProductPage(driver);
		WebElement selcat = createProductPage.getSelect_Category();
		webutil.dropDown(selcat, sel_cat);
		WebElement selsup = createProductPage.getSelect_Supplier();
		webutil.dropDown(selsup, sel_sup);
	
		createProductPage.enterAllProductDetailsAndSave(P_Code, name, desc, quantity, onhand, price, datestock);
		
		SearchProductPage searchProductPage = new SearchProductPage(driver);
		searchProductPage.enterProductNameAndsearch(name);
		
	}
}
