package Admin;

import java.io.IOException;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.inventory.sales.objectrepository.CreateCustomerPage;
import com.inventory.sales.objectrepository.CustomerInfoPage;
import com.inventory.sales.objectrepository.HomePage;
import com.inventory.sales.objectrepository.SearchCustomerPage;

public class CreateCustomerScriptTest extends BaseClass {

	
	@Test
	public void script() throws IOException, InterruptedException
	{
		HomePage homePage = new HomePage(driver);
		homePage.clickOnCustomerLink();
		
		CustomerInfoPage customerInfoPage = new CustomerInfoPage(driver);
		customerInfoPage.custLookupImg();
		
		/*
		driver.findElement(By.xpath("//span[text()='Customer']")).click();
		driver.findElement(By.xpath("//h4[contains(text(),'Customer')]/a")).click();*/
		String fn = exutil.readDataFromExcel("Sheet4", 0, 1);
		String ln = exutil.readDataFromExcel("Sheet4", 1, 1);
		String pno = exutil.readDataFromExcel("Sheet4", 2, 1);
		
		
		/*driver.findElement(By.name("firstname")).sendKeys(fn);
		driver.findElement(By.name("lastname")).sendKeys(ln);
		driver.findElement(By.name("phonenumber")).sendKeys(pno);
		driver.findElement(By.xpath("(//button='submit'])[1]")).click();*/
		
		CreateCustomerPage createCustomerPage = new CreateCustomerPage(driver);
		createCustomerPage.enterCustomerDetailsAndSave(fn, ln, pno);
		Thread.sleep(2000);
		
		SearchCustomerPage searchCustomerPage = new SearchCustomerPage(driver);
		searchCustomerPage.enterCustNameAndSearch(fn);
		/*
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(fn);*/
		
		
		

	}
}
