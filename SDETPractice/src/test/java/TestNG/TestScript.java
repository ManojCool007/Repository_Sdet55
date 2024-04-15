package TestNG;

import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.inventory.sales.objectrepository.CreateCustomerPage;
import com.inventory.sales.objectrepository.CustomerInfoPage;
import com.inventory.sales.objectrepository.HomePage;
import com.inventory.sales.objectrepository.SearchCustomerPage;

public class TestScript extends BaseClass{

	@Test
	public void Script() throws Throwable
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
}
