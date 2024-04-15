package Admin;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.GenericUtilities.DataBaseUtility;
import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebdriverUtility;
import com.inventory.sales.objectrepository.HomePage;
import com.inventory.sales.objectrepository.LoginPage;
import com.inventory.sales.objectrepository.TransactionInfoPage;
import com.inventory.sales.objectrepository.UserHomePage;
import com.inventory.sales.objectrepository.UserLogout;

public class ViewTransactionDetailsTest extends BaseClass{

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
	
	LoginPage loginPage = new LoginPage(driver);
	loginPage.loginToApp(Admin_UN, Admin_PWD);
	
	Thread.sleep(2000);
	webutil.confirmAlert(driver);
	
	HomePage homePage = new HomePage(driver);
	homePage.clickOnTransactionLink();;
	
	TransactionInfoPage transcationInfoPage = new TransactionInfoPage(driver);
	transcationInfoPage.enterTransactionNameAndClickOnSearch(cust_name);
	Thread.sleep(3000);
	driver.quit();
	}
}
