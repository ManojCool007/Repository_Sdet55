package Admin;

import static org.testng.Assert.fail;

import java.io.IOException;

import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.inventory.sales.objectrepository.HomePage;
import com.inventory.sales.objectrepository.SearchEmployeePage;

public class EmployeeSearchScriptTest extends BaseClass {
		
		@Test(retryAnalyzer = com.GenericUtilities.RetryImplementation.class)
		public void script() throws IOException, InterruptedException
		{
			HomePage homePage = new HomePage(driver);
			homePage.clickOnEmployeeLink();
			String expect = "Sales and Inventory System";
			String actual = driver.getTitle();
			
			System.out.println(actual);
			fail();
			String value = exutil.readDataFromExcel("Sheet1", 1, 0);
			
			SearchEmployeePage searchEmployeePage = new SearchEmployeePage(driver);
			searchEmployeePage.enterEmployeeAndClickOnSearch(value);
			

		}
}
