package User;

import java.io.IOException;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.inventory.sales.objectrepository.UserHomePage;
import com.inventory.sales.objectrepository.UserLogout;

public class TransactionScriptTest extends BaseClass{

	@Test
	public void script() throws IOException, InterruptedException
	{
		
	String quantity = exutil.readDataFromExcel("Sheet5", 0, 1);
	
	
	String cust_name = exutil.readDataFromExcel("Sheet5", 1, 1);
	
	UserHomePage userHomePage = new UserHomePage(driver);
	userHomePage.addProductAndPerformTransaction(quantity, cust_name, webutil);
	
	webutil.confirmAlert(driver);
	
	UserLogout userLogout = new UserLogout(driver);
	userLogout.userLogoutFromApp();
	
	driver.quit();
	}
}
